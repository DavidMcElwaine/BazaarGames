package bazaar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//put observer class relating to balance

public class Screen extends JFrame implements ActionListener, Observer {
    final JPanel  panel;
    final JPanel topPanel;
    private Panel mainPanel;
    final JButton store,login,exit,library, cart;
    private double balance;
    private LoginPanel lp;
    private CartPanel cp;
    private StorePanel sp;
    private LibraryPanel Lp; 
    private Customer loggedInUser;
    public Screen ()throws IOException
    {   
        loggedInUser = new Customer("Null");
        balance = loggedInUser.getBalance();
        
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,1));
        panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension(600,600));
        
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setPreferredSize(new Dimension(350,100));
                
        mainPanel = new LoginPanel(loggedInUser);    
        
        login = new JButton("Login");
        store = new JButton("Store");
        cart = new JButton("Cart: " + balance);
        library = new JButton("Libary");
        exit = new JButton("Exit");
        login.setPreferredSize(new Dimension(100,100));
        store.setPreferredSize(new Dimension(100,100));
        cart.setPreferredSize(new Dimension(125,100));
        library.setPreferredSize(new Dimension(100,100));
        exit.setPreferredSize(new Dimension(100,100));
        
        getContentPane().add(panel);
        panel.add(topPanel);
        topPanel.add(login);
        topPanel.add(store);
        topPanel.add(cart);
        topPanel.add(library);
        topPanel.add(exit);
        panel.add(mainPanel);
        
        exit.addActionListener(this);
        library.addActionListener(this);
        login.addActionListener(this);
        store.addActionListener(this);
        cart.addActionListener(this);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
        
        if(source == exit) {
            System.exit(0);
        }
        if(source == store) {
            loggedInUser = mainPanel.getUser();
            sp = new StorePanel(loggedInUser); 
            sp.makeObserver(this);
            changePanel(sp);   
        }
        if(source == login) {
            loggedInUser = mainPanel.getUser();
            lp = new LoginPanel(loggedInUser); 
            changePanel(lp);
        }
        if(source == library) {          
            loggedInUser = mainPanel.getUser();
            try { 
                Lp = new LibraryPanel(loggedInUser);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
            }
            changePanel(Lp);
        }
        if(source == cart) {
            loggedInUser = mainPanel.getUser();
            cp = new CartPanel(loggedInUser); 
            cp.makeObserver(this);
            changePanel(cp);
        }
    }
   public void changePanel(Panel newPanel)
   {
        loggedInUser = mainPanel.getUser();
        panel.remove(mainPanel);
        mainPanel = newPanel;
        panel.add(mainPanel);
        this.repaint();
        this.revalidate(); 
        
   }
    @Override
    public void update(double change ) {
        balance = balance + change;
        cart.setText("cart = " + balance);
    }
}