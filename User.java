import java.util.ArrayList;
public class User{
	private String username;
	private int numReviews;
	private int numFriends;
	private int spendings;
	private double balance;
	private ArrayList<Product> library;
	private Rank rank;
	
	public User(String username){
		this.library = new ArrayList<String>();
		this.username = username;
		this.numFriends = 0;
		this.numReviews = 0;
	    this.spendings = 0;
		this.balance = 0;
		this.library = new ArrayList<String>();
	}
	public User(String username, int r, int f,int s, double b,ArrayList<String> library){
		this.username = username;
		this.numReviews = r;
		this.numFriends = f;
		this.spendings = s;
		this.balance = b;
		this.library = library;
	}
	
		public static User getUser(String username, int r, int f,int s, double b){
		ArrayList<String> library = LibraryCSVReader.getLibrary(username);
		return new User(username,r,f,s,b,library);
		
	}
	
	public static User getUser(String username){
		//braryCSVReader.getLibrary(username);
		return new User(username);
		
	}
	
	ArrayList<String> getLibrary(){
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

}


