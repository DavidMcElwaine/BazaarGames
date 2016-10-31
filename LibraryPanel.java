package bazaar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LibraryPanel extends JPanel implements ActionListener {
    private ArrayList<Game> gamesList;
    final JPanel panel;
    private ArrayList<JButton> buttons;
    private JButton button;
    private JScrollPane scroll;
    public LibraryPanel(){
        //readInGames();
        gamesList = new ArrayList<Game>();
        gamesList.add(new Game("Premier Fantasy","Circle Onyx","Strategy","Circle Onyx",22.50));
        gamesList.add(new Game("Battleplace: Fall of Warfare","DA","Action","Ice",37.50));
        gamesList.add(new Game("Last day","Circle Onyx","Strategy","Circle Onyx",22.50));
        gamesList.add(new Game("Curling Manager 2015","DA","Strategy","DA",22.50));
        gamesList.add(new Game("Dustin the Turkey At the Black Sea Games 2016","Circle Onyx","Strategy","Circle Onyx",22.50));
        
        buttons = new ArrayList<JButton>();
        for (int i = 0; i < gamesList.size();i++)  {
            button = new JButton(gamesList.get(i).getTitle());
            button.setPreferredSize(new Dimension(550,100));
            buttons.add(i, button);
        }
        panel = new JPanel();
        panel.setPreferredSize(new Dimension (575,100 * gamesList.size()));
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
    }
}
