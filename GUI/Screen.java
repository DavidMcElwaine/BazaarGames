package bazaar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Screen extends JFrame implements ActionListener {
    final JPanel  panel;
    final JPanel topPanel;
    private Panel mainPanel;
    final JButton store,login,exit,library, cart;
    private double balance;
    public Database database;
    private LoginPanel lp;
    private CartPanel cp;
    private StorePanel sp;
    private LibraryPanel Lp; 
    private static ArrayList<Product> cartList;
    private User loggedInUser;
    public Screen ()throws IOException
    {
        database = new Database();        
        balance = 0;
        //balance = loggedInUser.getBalance();
        cartList = new ArrayList<>();
        loggedInUser = new User("Null");
        
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,1));
        panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension(600,600));
        
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setPreferredSize(new Dimension(350,100));
        
        
        mainPanel = new LoginPanel(database,cartList, loggedInUser);    
        
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
            cartList = mainPanel.getCart();
            loggedInUser = mainPanel.getUser();
            sp = new StorePanel(database, cartList, loggedInUser); 
            changePanel(sp);   
        }
        if(source == login) {
            cartList = mainPanel.getCart();
            loggedInUser = mainPanel.getUser();
            lp = new LoginPanel(database, cartList, loggedInUser); 
            changePanel(lp);
        }
        if(source == library) { 
            cartList = mainPanel.getCart();           
            loggedInUser = mainPanel.getUser();
            Lp = new LibraryPanel(database, cartList, loggedInUser); 
            changePanel(Lp);
        }
        if(source == cart) {
            cartList = mainPanel.getCart();
            loggedInUser = mainPanel.getUser();
            cp = new CartPanel(database, cartList, loggedInUser);  
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
}