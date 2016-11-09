package bazaar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CartPanel extends Panel implements ActionListener {
    final JPanel panel,buttonPanel;
    private ArrayList<JButton> buttons;
    private JButton button,buy,clear;
    private JScrollPane scroll;
    public CartPanel(Database database, User lUser){
        this.loggedInUser = lUser;
        System.out.println("User name is " + loggedInUser.getName());
        buttonPanel = new JPanel();
        panel = new JPanel();
        buttons = new ArrayList<>();
        scroll = new JScrollPane(panel);
        buy = new JButton("Buy cart");
        clear = new JButton("Clear cart");
        ArrayList cart = loggedInUser.getCart();
        System.out.println("cartList size =" + cart.size());
        for (int i = 0; i < loggedInUser.getCart().size();i++)  {
            System.out.println(i);
            button = new JButton(loggedInUser.getCart().get(i).getTitle());
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
        setUser(this.loggedInUser);
    }
    
    //Make it clear up properly.
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
            Transaction transaction = new Transaction(loggedInUser);
            transaction.CalculateBill(loggedInUser);
            
            loggedInUser.emptyCart();
            buttons = new ArrayList<>();
            repaint();
            revalidate();
        }
        if(source == clear)
        {
            loggedInUser.emptyCart();
            buttons = new ArrayList<>();
            repaint();
            revalidate();
        }
    }
    public void update()
    {
        
    }
}