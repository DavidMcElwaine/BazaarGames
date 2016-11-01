package bazaar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CartPanel extends JPanel implements ActionListener {
    private ArrayList<Game> gamesList;
    final JPanel panel,buttonPanel;
    private ArrayList<JButton> buttons;
    private JButton button,buy,clear;
    private JScrollPane scroll;
    public CartPanel(){    
        //readInGames();
        buttonPanel = new JPanel();
        panel = new JPanel();
        gamesList = new ArrayList<Game>();
        buttons = new ArrayList<JButton>();
        scroll = new JScrollPane(panel);
        buy = new JButton("Buy cart");
        clear = new JButton("Clear cart");
        
        gamesList.add(new Game("Premier Fantasy","Circle Onyx","Strategy","Circle Onyx",22.50));
        gamesList.add(new Game("Battleplace: Fall of Warfare","DA","Action","Ice",37.50));
        gamesList.add(new Game("Last day","Circle Onyx","Strategy","Circle Onyx",22.50));
        gamesList.add(new Game("Curling Manager 2015","DA","Strategy","DA",22.50));
        gamesList.add(new Game("Dustin the Turkey At the Black Sea Games 2016","Circle Onyx","Strategy","Circle Onyx",22.50));
        

        for (int i = 0; i < gamesList.size();i++)  {
            button = new JButton(gamesList.get(i).getTitle());
            button.setPreferredSize(new Dimension(550,100));
            buttons.add(i, button);
        }    
        panel.setPreferredSize(new Dimension (575,100 * gamesList.size()));
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
        String text = ((JButton) event.getSource()).getText();
        System.out.print(text);
    }
}
