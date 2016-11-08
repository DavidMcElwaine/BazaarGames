package bazaar;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class StorePanel extends Panel implements ActionListener {
    private ArrayList<Product> productsList;
    private User loggedInUser;
    final JPanel panel;
    private ArrayList<JButton> buttons;
    private JButton button;
    private JScrollPane scroll;
    public StorePanel(Database database, ArrayList<Product> cart, User loggedInUser)
    {
        this.loggedInUser = loggedInUser;
        panel = new JPanel();
        buttons = new ArrayList<>();
        productsList = database.giveProductList();
        this.cartList = cart;
        
        for (int i = 0; i < productsList.size();i++)
        {
            //System.out.println(productsList.get(i).getTitle());
            button = new JButton(productsList.get(i).getTitle());
            button.setPreferredSize(new Dimension(550,100));
            buttons.add(i, button);
        }       
        panel.setPreferredSize(new Dimension (575,110 * productsList.size()));
        scroll = new JScrollPane(panel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension (600, 450));
        this.add(scroll);
        for (int i =0; i < buttons.size(); i++)
        {
            panel.add(buttons.get(i));
            buttons.get(i).addActionListener(this);
        }
    }
    public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
        
        for (int i =0; i < buttons.size();i++)
        {
            if(source == buttons.get(i)){
                String title  = buttons.get(i).getText();
                if (title.contains("(In Cart)")){
                    title = title.substring(0, title.length() - 9);
                    buttons.get(i).setText(title);
                }
                else{                
                    buttons.get(i).setText(title + "(In Cart)");
                    cartList.add(productsList.get(i));
                }
                
            }
        }
    }
}
