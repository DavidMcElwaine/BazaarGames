import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Rank{

	private User user;
	private String rank;
	
	public Rank(User user){
		this.user = user;
		double spent = getSpendings(user);
		
		double rankpoints =  (5*user.getNumReviews()) + (2*user.getNumFriends()) + spent;

		if(rankpoints > 500)		this.rank = "Gold";
		else if(rankpoints > 200)	this.rank = "Silver";
		else 				this.rank = "Bronze";	
	}
		
	public static double getSpendings(User user){
		double total = 0; //open the two files and declare your return int
		try {
			ArrayList<Product> library = user.getLibrary();
			
					for(int i = 0; i < library.size(); i++){
						Scanner gameDetails = new Scanner(new File("games.txt"));
						while(gameDetails.hasNext())
						{
							String gLine = gameDetails.nextLine();
							String[] temp = gLine.split(",");
							if(temp[0].matches(library.get(i).getTitle()));
							{
								double price = Double.parseDouble(temp[4]);
								total = total + price;// adds the cost of each one up
							}
						}
						gameDetails.close();// closes file after each iteration so that it begins the search from the beginning
				        }
			
		}
		catch (FileNotFoundException e) {
			System.out.println("Scanner creation failed in getSpendings()");
		}
		return total;
	}
	
	public double getDiscount(){
		if(this.rank.matches("Gold")) return 0.2;
		else if(this.rank.matches("Silver")) return 0.1;
		else return 0;
	}
}
