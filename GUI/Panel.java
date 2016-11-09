package bazaar;

import java.util.ArrayList;
import javax.swing.JPanel;

public abstract class Panel extends JPanel{
    public User loggedInUser;
    public Panel()
    {
        
    }
    
    public User getUser()
    {
        return loggedInUser;
    }
    public void setUser(User loggedInUser){
        this.loggedInUser = loggedInUser;
    }    
}