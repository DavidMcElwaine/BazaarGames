package bazaar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserCSVReader {
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
       details.close(); 
    return result;
  }
  public static ArrayList<Customer> getAll()throws IOException{
      ArrayList<Customer> users = new ArrayList<>();
      Customer customer;
      String currentLine;
      String[] elements;
      File usersFile = new File("users.csv");
      if (usersFile.exists()){
          Scanner in = new Scanner(usersFile);
          while (in.hasNext())
          {
              currentLine = in.nextLine();
              elements = currentLine.split(",");
              customer = new Customer(elements[0],Integer.parseInt(elements[1]),Integer.parseInt(elements[2]),Integer.parseInt(elements[3]),Double.parseDouble(elements[4]));
              users.add(customer);
          }
          in.close();
      }
      else 
          System.out.print("Users.csv not found");
      
      return users;
  }
  public static ArrayList <Product> getUserLibrary(String username) throws FileNotFoundException{
  ArrayList <Product> result = new ArrayList<>();
  Scanner  details = new Scanner(new File("library.csv"));
  Product product;            
   while(details.hasNext()){
      String currentLine = details.nextLine();
      String [] user = currentLine.split(",");
      if(user[0].matches(username)){
          System.out.print("Match found for "  + username);
          System.out.println("+ " + user.length);
          for(int i = 1 ; i < user.length ; i++){
              System.out.println(i);
              product = GameCSVReader.getGameDetails(user[i]);
              System.out.println(product.getTitle());
               result.add(product);
          }
       }
   }
   
     details.close();    
    return result;
  }
}
