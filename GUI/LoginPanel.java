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
    public LoginPanel(Database database, User loggedIn)
    {
        this.loggedInUser = loggedIn;
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
                System.out.print(allUsers.get(i).getName());
                if (userName.matches(allUsers.get(i).getName()))
                {
                    loggedInUser = allUsers.get(i);
                    System.out.println("User = " + loggedInUser.getName());
                    found = true;
                    JOptionPane.showMessageDialog(null,"Logged in to " + userName + " account");
                }
            }
            if (found == false)
                JOptionPane.showMessageDialog(null,"No user with that name!");
        }
        if (source == createButton)
        {
            userName = name.getText();
            if (userName.length() > 0){
                loggedInUser = new User (userName);
                try {
                    database.addUser(loggedInUser);
                } catch (IOException ex) {
                    Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.printf("Error");
                }
            }
            else {
               JOptionPane.showMessageDialog(null,"Please enter a name"); 
            }
        }
        setUser(this.loggedInUser);
    }
    public String getUserName()
    {
        return userName;
    }
}