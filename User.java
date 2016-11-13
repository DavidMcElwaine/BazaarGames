package bazaar;

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
	public User(String username, int r, int f,int s, double b,ArrayList<Product> library){
		this.username = username;
		this.numReviews = r;
		this.numFriends = f;
		this.spendings = s;
		this.balance = b;
		this.library = library;
		this.cart = new ArrayList<>();
	}
        public User(String username, int r, int f,int s, double b){
		this.username = username;
		this.numReviews = r;
		this.numFriends = f;
		this.spendings = s;
		this.balance = b;
		this.library = new ArrayList<>();
		this.cart = new ArrayList<>();
	}	
		public User getUser(String username) throws FileNotFoundException{
		ArrayList<Product> library = LibraryCSVReader.getLibrary(username); 
                String[] details= UserCSVReader.getUserDetails(username);      
                
                
		return new User(details[0],Integer.parseInt(details[1]),Integer.parseInt(details[2]),Integer.parseInt(details[3]),Double.parseDouble(details[4]),library);	
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
	
	ArrayList<Product> getCart(){
		return cart;
	}
        
        double getCartCost()
        {
            double cost = 0;
            for (int i =0; i < cart.size();i++)
                cost+= cart.get(i).getPrice();
            return cost;
        }
        
        void addToCart (Product product)
        {
            cart.add(product);
        }
        
        void emptyCart()
        {
            cart = new ArrayList<>();
        }
}
