import java.io.FileNotFoundException;
import java.util.ArrayList;
public class User{
	private String username;
	private int numReviews;
	private int numFriends;
	private int spendings;
	private double balance;
	private ArrayList<Product> library;
	private ArrayList<Product> cart;
	private Rank rank;
	
	public User(String username){
		this.username = username;
		this.numFriends = 0;
		this.numReviews = 0;
	        this.spendings = 0;
		this.balance = 0;
		this.library = new ArrayList<Product>();
		this.cart = new ArrayList<Product>();
	}
        /*public User(String username, int r, int f,int s, double b){
		this.username = username;
		this.numReviews = r;
		this.numFriends = f;
		this.spendings = s;
		this.balance = b;
                this.library = new ArrayList<Product>();
	}*/
	public User(String username, int r, int f,int s, double b,ArrayList<Product> library){
		this.username = username;
		this.numReviews = r;
		this.numFriends = f;
		this.spendings = s;
		this.balance = b;
		this.library = library;
		this.cart = new ArrayList<Product> cart;
	}
	
		public static User getUser(String username, int r, int f,int s, double b) throws FileNotFoundException{
		ArrayList<Product> library = LibraryCSVReader.getLibrary(username); 
                String[] details= getUserDetails(username);      
                
                
		return new User(details[0],details[1],details[2],details[3],details[4],library);
		
	}
	
	public static User getUser(String username){
		LibraryCSVReader.getLibrary(username);
		return new User(username);
		
	}
	
	ArrayList<Product> getLibrary(){
		return library;
	}
	
	
	String getName(){
		return username;
	}

	int getNumReviews(){
		return numReviews;
	}

	int getNumFriends(){
		return numFriends;
	}

	int getSpendings(){
		return spendings;
	}
        double getBalance(){
           return balance; 
        }
}


