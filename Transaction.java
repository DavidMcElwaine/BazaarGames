import java.io.*;
import java.util.Scanner;
public class Transaction{
		
		public void UpdateCustomer(String username, String game) throws Exception{
			
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
			writer.close();
		}	
}
