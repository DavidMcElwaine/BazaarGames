import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
public class User{
	private String id;
	private int reviews;
	private int friends;
	private int spendings;
	public ArrayList<String> userlist	= new ArrayList<String>();
	public ArrayList<String> library = new ArrayList<String>(); ;
	String catagory;
	
	User(String username){
		id = username;
		friends = 0;
		reviews = 0;
	    spendings = 0;
	}
	User(String username, int r, int f,int s) throws Exception{
		id = username;
		reviews = r;
		friends = f;
		spendings = s;
		Scanner games = new Scanner(new File("games.txt"));
		int i = 0;
		while(games.hasNextLine()){
			library.add(games.nextLine().toString());
			i++;
		}
		Scanner users = new Scanner(new File("users.txt"));
		i =0;
		while(users.hasNextLine()){
			userlist.add(users.nextLine().toString());
			i++;
		}
			
		catagory = this.calculateC();
	}
	
	String calculateC(){
		int total = reviews + friends + spendings;
		if(total < 100)
			return "Bronze";
		else if(total < 300)
			return "Sliver";
		else 
			return "Gold";
	}
	String getId(){
		return id;
	}
	void setId(String i){
		id = i;
	}
	int getR(){
		return reviews;
	}
	void setR(int r){
		reviews = r;
	}
	int getF(){
		return friends;
	}
	void setF(int f){
		friends = f;
	}
	int getS(){
		return spendings;
	}
	void setS(int s){
		spendings = s;
	}
}