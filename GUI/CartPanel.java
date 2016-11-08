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
    private ArrayList<Product> cartList;
    final JPanel panel,buttonPanel;
    private ArrayList<JButton> buttons;
    private JButton button,buy,clear;
    private JScrollPane scroll;
    public CartPanel(Database database, ArrayList<Product> cart, User loggedInUser){
        this.loggedInUser = loggedInUser;
        cartList = new ArrayList<>();
        this.cartList = cart;
        buttonPanel = new JPanel();
        panel = new JPanel();
        buttons = new ArrayList<>();
        scroll = new JScrollPane(panel);
        buy = new JButton("Buy cart");
        clear = new JButton("Clear cart");
        System.out.println("cartList size =" + cartList.size());
        for (int i = 0; i < cartList.size();i++)  {
            System.out.println(i);
            button = new JButton(cartList.get(i).getTitle());
            button.setPreferredSize(new Dimension(550,100));
            buttons.add(i, button);
        }    
        panel.setPreferredSize(new Dimension (575,100 * cartList.size()));
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
            //Transaction transaction = new Transaction(loggedInUser, cartList);
            cartList = new ArrayList<>();
            repaint();
            revalidate();
        }
        if(source == clear)
        {
            cartList = new ArrayList<>();
            repaint();
            revalidate();
        }
    }
    public void update()
    {
        
    }
}