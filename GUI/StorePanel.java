package bazaar;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class StorePanel extends Panel implements ActionListener,Subject {
    private ArrayList<Product> productsList;
    private User loggedInUser;
    final JPanel panel;
    private ArrayList<JButton> buttons;
    private Observer observer;
    private JButton button;
    private JScrollPane scroll;
    public StorePanel(User loggedInUser)
    {
        this.loggedInUser = loggedInUser;
        panel = new JPanel();
        buttons = new ArrayList<>();
        
        try {
            productsList = StoreCSVReader.getAll();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StorePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < productsList.size();i++)
        {
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
        setUser(this.loggedInUser);
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
                    updateObserver(productsList.get(i).getPrice() * -1);
                }
                else{                
                    buttons.get(i).setText(title + "(In Cart)");
                    loggedInUser.addToCart(productsList.get(i));
                    updateObserver(productsList.get(i).getPrice());
                }
                
            }
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
