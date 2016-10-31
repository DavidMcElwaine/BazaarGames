package bazaar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel implements ActionListener{
    final JTextField name,password;
    final JButton loginButton, createButton;
    public LoginPanel()
    {
        name = new JTextField();
        password = new JTextField();
        loginButton = new JButton();
        createButton = new JButton();

        name.setPreferredSize(new Dimension (100,80));
        password.setPreferredSize(new Dimension (100,80));
        loginButton.addActionListener(this);
        loginButton.setPreferredSize(new Dimension (100,80));
        loginButton.setText("Login to Account");
        createButton.addActionListener(this);
        createButton.setPreferredSize(new Dimension (100,80));
        createButton.setText("Create a new Account");

        this.setLayout(new BoxLayout(this,1));
        
        this.add(name);
        this.add(password);
        this.add(loginButton);
        this.add(createButton);
        
    }
     public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
        if(source == loginButton)
        {
            //Login logic goes here
        }
        if (source == createButton)
        {
            //Create logic goes here
        }
    }
}
