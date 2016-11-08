import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserCSVReader {
	
	
	public static void main(String[] args) throws Exception{
		String[] result = getUserDetails("user123");
		for(int i = 0; i< 5; i++){
			System.out.println(result[i]);
		}
	}
    
    
  public static String[] getUserDetails(String username) throws FileNotFoundException{
  String[] result = new String[5];
  Scanner  details = new Scanner(new File("user.csv"));
                
   while(details.hasNext()){
      String currentLine = details.nextLine();
      String [] user = currentLine.split(",");
      if(user[0].matches(username)){
          for(int i = 0 ; i < user.length ; i++){
            result[i] = user[i];
          }
       }
   }
        
    return result;
  }
}