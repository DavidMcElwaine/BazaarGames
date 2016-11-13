package bazaar;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Transaction{
        
		private User user;
		
		public Transaction(User user)
                {
                    this.user = user;
                }
		
		
		public void UpdateUserLibrary(Transaction trans) throws Exception{
			String username = user.getName();
			File originalLibrary = new File("library.csv");
			File newLibrary = new File("library.csv");
			Scanner in = new Scanner(originalLibrary);
			FileWriter writer = new FileWriter(newLibrary);
			String updatedLibrary = new String("");
			
			while(in.hasNext()){
				String currentLine = in.nextLine();
				String[] temp = currentLine.split(",");
				if((username).matches(temp[0])){	  
					updatedLibrary = updatedLibrary + currentLine;
					for(int i=0; i<(user.getCart().size());i++)
                                            updatedLibrary = updatedLibrary + "," + user.getCart().get(i).getTitle();
					updatedLibrary += "\n";
				}
				else updatedLibrary = updatedLibrary + currentLine + "\n";
			}
			
			writer.write(updatedLibrary);
			writer.flush();
			writer.close();
		}	
		
		public double CalculateBill(User user){
			
			Rank rank = new Rank(user);
			double rankDiscount = rank.getDiscount();
			
			String username = user.getName();
			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
			double discountPercent = 0;
			double initialPrice = 0;
			double discountA = 0;
			double originalCost = 0;
			
			for(Product product: user.getCart()){
				
				//add price to bill
				originalCost += product.getPrice();
				
				//calculate discount based on age of game. 1% per year up to 50% off
				int ageDifference = currentYear - product.getYear();
				double ageDiscount = 1 - (ageDifference*0.01);
				if(ageDiscount < 0.5) ageDiscount = 0.5;
				
				//calculate discount based on sales. 1% reduction in discount per 100 sales
				double modifierB = 0.5;
				double salesDiscount = modifierB + (0.0001*product.getSales());
				
				//first stage of discount is the average of age and sales discounts
				discountA = (ageDiscount+salesDiscount)/2;				
			}
			
			//add discount based on number of games this purchase
			discountPercent += 0.01*(user.getCart().size());
			if(discountPercent >= 0.15) discountPercent = 0.15;
			
			//final bill
			double finalDiscount = discountPercent + discountA + rankDiscount;
			double finalCost = originalCost * finalDiscount;	
                        JOptionPane.showMessageDialog(null, "Total cost of purchase €" + finalCost);
			return finalCost;
		}

}
