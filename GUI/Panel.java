package bazaar;

import java.util.ArrayList;
import javax.swing.JPanel;

public abstract class Panel extends JPanel{
    public Customer loggedInUser;
    public Panel()
    {
        
    }
    
    public Customer getUser()
    {
        return loggedInUser;
    }
    public void setUser(Customer loggedInUser){
        this.loggedInUser = loggedInUser;
    }    
}