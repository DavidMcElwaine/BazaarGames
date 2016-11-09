import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserCSVWriter {
	
	public static void main(String[] args) throws Exception{
		Buy("gameGuy99", 50);
	}
	
  public static void Buy(String username, double price) throws FileNotFoundException, Exception{
  
  Scanner  details = new Scanner(new File("user.csv"));
  String updatedUsers = new String("");
                
   while(details.hasNext()){
      String currentLine = details.nextLine();
      String [] user = currentLine.split(",");
      if(user[0].matches(username)){
		  double transaction = Double.parseDouble(user[4]);
          transaction = transaction - price;
		  user[4] = Double.toString(transaction);
		  currentLine = "";
		  for(int i = 0; i < 5; i++){
			  if (i == 4)
				  currentLine += user[i];
			  else
			  currentLine += user[i] + ",";
		  }
		  updatedUsers += currentLine + " \n";
		  }
	  else 
		  updatedUsers += currentLine + " \n";
   }
   details.close();
   FileWriter newDetails = new FileWriter(new File("user.csv"));
   newDetails.write(updatedUsers);
   
   newDetails.close();     
  }
}