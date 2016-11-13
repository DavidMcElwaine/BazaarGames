package bazaar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LibraryPanel extends Panel implements ActionListener {
    private ArrayList<Product> libraryList;
    private JPanel panel;
    private ArrayList<JButton> buttons;
    private JButton button;
    private JScrollPane scroll;
    public LibraryPanel(Customer loggedInUser) throws FileNotFoundException{
        this.loggedInUser = loggedInUser;
        libraryList = new ArrayList<>();
        libraryList = UserCSVReader.getUserLibrary(loggedInUser.getUserName());
        for (int i =0; i < libraryList.size();i++)
            System.out.println(libraryList.get(i).getTitle());
        setUp();        
        setUser(this.loggedInUser);
    }    
    public void setUp()
    {
        buttons = new ArrayList<>();
        for (int i = 0; i < libraryList.size();i++)  {
            button = new JButton(libraryList.get(i).getTitle());
            button.setPreferredSize(new Dimension(550,100));
            buttons.add(i, button);
        }
        panel = new JPanel();
        panel.setPreferredSize(new Dimension (575,110 * libraryList.size()));
        scroll = new JScrollPane(panel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension (600, 450));
        this.add(scroll);
        for (int i =0; i < buttons.size(); i++){
            panel.add(buttons.get(i));
            buttons.get(i).addActionListener(this);
        }
    }
    public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
        String text = ((JButton) event.getSource()).getText();
        System.out.print(text);
        
        for (int i =0; i < buttons.size();i++)
        {
            if(source == buttons.get(i))
                JOptionPane.showMessageDialog(null,"");
        }
    }
}