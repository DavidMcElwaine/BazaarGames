import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
public class Transaction{
        private User user;
		private ArrayList<Product> additions;
		public Transaction(User user, ArrayList<Product> additions)
                {
                    this.user = user;
					this.additions = additions;
                }
		public void UpdateUserLibrary(Transaction trans) throws Exception{
			String username = user.getName();
			File originalLibrary = new File("library.csv");
			File newLibrary = new File("newLibrary.csv");
			Scanner in = new Scanner(originalLibrary);
			FileWriter writer = new FileWriter(newLibrary);
			String updatedLibrary = new String("");
			
			while(in.hasNext()){
				String currentLine = in.nextLine();
				String[] temp = currentLine.split(",");
				if((username).matches(temp[0])) updatedLibrary = updatedLibrary + currentLine + "," + game + "\n" ;
				else updatedLibrary = updatedLibrary + currentLine + "\n";
			}
			
			writer.write(updatedLibrary);
			writer.flush();
			writer.close();
		}	
		
		public double CalculateBill(User user){
			
			Rank rank = new Rank(user);
			double rankDiscount = rnak.getDiscount();
			
			String username = user.getName();
			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			double discountPercent = 0;
			double initialPrice = 0;
			double discountA = 0;
			double originalCost = 0;
			
			for(Game game: newGames){
				
				//add price to bill
				originalCost += game.getPrice();
				
				//calculate discount based on age of game. 1% per year up to 50% off
				int ageDifference = currentYear - game.getYear();
				double ageDiscount = 1 - (ageDifference*0.01);
				if(ageDiscount < 0.5) ageDiscount = 0.5;
				
				//calculate discount based on sales. 1% reduction in discount per 100 sales
				double modifierB = 0.5;
				double salesDiscount = modifierB + (0.0001*game.getSales());
				
				//first stage of discount is the average of age and sales discounts
				discountA = (ageDiscount+salesDiscount)/2;				
			}
			
			//add discount based on number of games this purchase
			discountPercent += 0.01*(newGames.size());
			if(discountPercent >= 0.15) discountPercent = 0.15;
			
			//final bill
			double finalDiscount = discountPercent + discountA + rankDiscount;
			double finalCost = originalCost * finalDiscount;	

			return finalCost;
		}
}
