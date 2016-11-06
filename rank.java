import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class rank{
	
	public static String Rank(String username, int reviews, int friends) throws Exception{
		int spent = getSpendings(username);
		
		int rankpoints =  reviews + friends + spent;
		String rank;
		if(rankpoints > 500){
			rank = "Gold";
		}
		else if(rankpoints > 200){
			rank = "Sliver";
		}
		else rank = "Bronze";
		
		return rank;
	}
		
	public static int getSpendings(String username) throws Exception{
		Scanner library = new Scanner(new File("library.txt"));
		
		double total = 0; //open the two files and declare your return int
		
		while(library.hasNext()){ // awkward way of doing it but..
			String lLine = library.nextLine(); 
			String[] Lib = lLine.split(",");//splits the lines into String arrays
			
			if(Lib[0].matches(username)){
					for(int i = 1; i < Lib.length; i++){
						Scanner gameDetails = new Scanner(new File("games.txt"));
						while(gameDetails.hasNext()){// time consuming
							String gLine = gameDetails.nextLine();
							String[] temp = gLine.split(",");
							if(temp[0].matches(Lib[i])){
								double price = Double.parseDouble(temp[4]);
								total = total + price;// adds the cost of each one up
							}
						}
						gameDetails.close();// closes file after each iteration so that it begins the search from the beginning
			        }
			}
		}
		
		int returntype = (int)(total);
		return returntype;
	}
}

