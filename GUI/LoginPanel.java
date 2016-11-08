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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginPanel extends Panel implements ActionListener{
    final JTextField name,password;
    final JButton loginButton, createButton;
    private String userName;
    ArrayList<User> allUsers;
    Database database;
    public LoginPanel(Database database, ArrayList<Product> cart, User loggedIn)
    {
        this.loggedInUser = loggedIn;
        cartList = new ArrayList<>();
        this.cartList = cart;
        this.database = database;
        
        name = new JTextField();
        password = new JTextField();
        loginButton = new JButton();
        createButton = new JButton();
        allUsers = database.giveUserList();
        
        System.out.println("Starting userList");
        for (int i =0; i < allUsers.size(); i ++)
            System.out.println(i + "" + allUsers.get(i).getName());
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
            userName = name.getText();           
            boolean found = false;
            for (int i =0 ; i < allUsers.size() && !found;i++)
            {
                if (userName.matches(allUsers.get(i).getName()))
                {
                    User copy = allUsers.get(i);
                    //loggedInUser = getUser(copy.getName(),copy.)
                    found = true;
                }
            }
            if (found == false)
                JOptionPane.showMessageDialog(null,"No user with that name!");
        }
        if (source == createButton)
        {
            userName = name.getText();
            loggedInUser = new User (userName);
            try {
                database.addUser(loggedInUser);
            } catch (IOException ex) {
                Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
                System.out.printf("Error");
            }
        }
    }
    public String getUserName()
    {
        return userName;
    }
}