import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Rank{

	private String username;
	private int reviews;
	private int friends;
	private String rank;
	
	public Rank(String username, int reviews, int friends){
		double spent = getSpendings(username);
		
		double rankpoints =  reviews + friends + spent;
		String rank;
		if(rankpoints > 500){
			rank = "Gold";
		}
		else if(rankpoints > 200){
			rank = "Silver";
		}
		else rank = "Bronze";
		
	}
		
	public static double getSpendings(String username){
		Scanner library;
		double total = 0; //open the two files and declare your return int
		try 
		{
			library = new Scanner(new File("library.txt"));
			while(library.hasNext())
			{ 
				String lLine = library.nextLine(); 
				String[] Lib = lLine.split(",");//splits the lines into String arrays
				
				if(Lib[0].matches(username))
				{
					for(int i = 1; i < Lib.length; i++){
						Scanner gameDetails = new Scanner(new File("games.txt"));
						while(gameDetails.hasNext())
						{
							String gLine = gameDetails.nextLine();
							String[] temp = gLine.split(",");
							if(temp[0].matches(Lib[i]))
							{
								double price = Double.parseDouble(temp[4]);
								total = total + price;// adds the cost of each one up
							}
						}
						gameDetails.close();// closes file after each iteration so that it begins the search from the beginning
				        }
				}
			}
			library.close();
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Scanner creation failed in getSpendings()");
		}
		
		return total;
	}
}
