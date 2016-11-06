package bazaar;

import java.util.ArrayList;
import javax.swing.JPanel;


public class Panel extends JPanel{
    public ArrayList <Product> cartList;
    public User loggedInUser;
    public Panel()
    {
        loggedInUser = new User();
    }
    public void setCart(ArrayList cartList){
        this.cartList = cartList;
    }
    public ArrayList<Product> getCart()
    {
        return cartList;  
    }
    
    public User getUser()
    {
        return loggedInUser;
    }
    public void setUser(User loggedInUser){
        this.loggedInUser = loggedInUser;
    }
    
}