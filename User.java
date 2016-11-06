import java.util.ArrayList;
public class User{
	private String username;
	private int numReviews;
	private int numFriends;
	private int spendings;
	private ArrayList<String> library;
	private Rank rank;
	
	public User(String username){
		this.username = username;
		this.numFriends = 0;
		this.numReviews = 0;
	    	this.spendings = 0;
		this.library = new ArrayList<String>();
	}
	public User(String username, int r, int f,int s){
		this.username = username;
		this.numReviews = r;
		this.numFriends = f;
		this.spendings = s;
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
