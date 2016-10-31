/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazaar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Screen extends JFrame implements ActionListener {
    final JPanel  panel;
    private JPanel topPanel, mainPanel;
    private JButton store,login,exit,library, cart;
    private double balance;
    public int nextScreen;
    public Screen ()
    {
        //to be replaced 
        balance = 0;
        
        nextScreen =0;
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,1));
        panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension(600,600));
        
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setPreferredSize(new Dimension(350,100));
        
        mainPanel = new LoginPanel();        
        
        login = new JButton("Login");
        store = new JButton("Store");
        cart = new JButton("Balance: " + balance);
        library = new JButton("Libary");
        exit = new JButton("Exit");
        login.setPreferredSize(new Dimension(100,100));
        store.setPreferredSize(new Dimension(100,100));
        cart.setPreferredSize(new Dimension(125,100));
        library.setPreferredSize(new Dimension(100,100));
        exit.setPreferredSize(new Dimension(100,100));
        
        getContentPane().add(panel);
        panel.add(topPanel);
        topPanel.add(login);
        topPanel.add(store);
        topPanel.add(cart);
        topPanel.add(library);
        topPanel.add(exit);
        panel.add(mainPanel);
        
        
        exit.addActionListener(this);
        library.addActionListener(this);
        login.addActionListener(this);
        store.addActionListener(this);
        cart.addActionListener(this);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
        if(source == exit) {
            System.exit(0);
        }
        if(source == store) {
            panel.remove(mainPanel);
            mainPanel = new StorePanel();
            panel.add(mainPanel);
            this.repaint();
            this.revalidate();        
        }
        if(source == login) {
            panel.remove(mainPanel);
            mainPanel = new LoginPanel();
            panel.add(mainPanel);
            this.repaint();
            this.revalidate();  
        }
        if(source == library) {
            panel.remove(mainPanel);
            mainPanel = new LibraryPanel();
            panel.add(mainPanel);
            this.repaint();
            this.revalidate();  
        }
        if(source == cart) {
            panel.remove(mainPanel);
            mainPanel = new CartPanel();
            panel.add(mainPanel);
            this.repaint();
            this.revalidate();  
        }
    }
}