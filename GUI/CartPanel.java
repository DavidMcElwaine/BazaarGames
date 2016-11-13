package bazaar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CartPanel extends Panel implements ActionListener, Subject {
    private JPanel panel,buttonPanel;
    private ArrayList<JButton> buttons;
    private JButton button,buy,clear;
    private JScrollPane scroll;
    private Observer observer;
    public CartPanel(Customer lUser){
        this.loggedInUser = lUser;
        setUp();
        setUser(this.loggedInUser);
    }
    public void setUp()
    {
        buttonPanel = new JPanel();
        panel = new JPanel();
        buttons = new ArrayList<>();
        scroll = new JScrollPane(panel);
        buy = new JButton("Buy cart");
        clear = new JButton("Clear cart");
        
        ArrayList <Product> cart = loggedInUser.getCart();
        for (int i = 0; i < cart.size();i++)  {
            button = new JButton(cart.get(i).getTitle());
            button.setPreferredSize(new Dimension(550,100));
            buttons.add(i, button);
        }    
        panel.setPreferredSize(new Dimension (575,100 * loggedInUser.getCart().size()));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension (600, 350));
        this.add(scroll);
        for (int i =0; i < buttons.size(); i++){
            panel.add(buttons.get(i));
            buttons.get(i).addActionListener(this);
        }
        buy.setPreferredSize(new Dimension(100,100));
        clear.setPreferredSize(new Dimension(100,100));
        buttonPanel.setLayout(new BoxLayout(buttonPanel,2));
        buttonPanel.add(buy);
        buttonPanel.add(clear);
        buy.addActionListener(this);
        clear.addActionListener(this);
        this.add(buttonPanel);
    }
    public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
        for (int i =0; i < buttons.size();i++)
        {
            if(source == buttons.get(i))
                System.out.print(i);
        }
        if(source == buy)
        {
            for (int i =0; i < loggedInUser.getCart().size();i++)
                panel.remove(buttons.get(i));
            updateObserver(loggedInUser.getCartCost() * -1);
            Transaction transaction = new Transaction(loggedInUser);
            transaction.CalculateBill(loggedInUser); 
            try {
                LibraryCSVWriter.addToLibrary(loggedInUser.getUserName(), loggedInUser.getCart());
            } catch (IOException ex) {
                Logger.getLogger(CartPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i =0; i < loggedInUser.getCart().size(); i++){
                try {
                    UserCSVWriter.Buy(loggedInUser.getUserName(), loggedInUser.getCart().get(i).getPrice());
                } catch (Exception ex) {
                    Logger.getLogger(CartPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            loggedInUser.emptyCart();
            buttons = new ArrayList<>();
            revalidate();
            repaint();
            
        }
        if(source == clear)
        {   
            updateObserver(loggedInUser.getCartCost() * -1);
            loggedInUser.emptyCart();
            buttons = new ArrayList<>();
            repaint();
            revalidate();
        }
    }

    @Override
    public void makeObserver(Observer o) {
        observer = o;
    }

    @Override
    public void updateObserver(double change) {
        observer.update(change);
    }
}