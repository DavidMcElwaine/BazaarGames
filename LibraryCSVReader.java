package bazaar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryCSVReader {
    
    
  public static ArrayList<Product> getLibrary(String username) throws FileNotFoundException{
  ArrayList<Product> newLib = new ArrayList<Product>();
  Scanner lib = new Scanner(new File("library.csv"));
  Game game;
                
   while(lib.hasNext()){
      String libLine = lib.nextLine();
      String [] library = libLine.split(",");
      if(library[0].matches(username)){
          for (int i =1; i < library.length;i++){
            game = GameCSVReader.getGameDetails(library[i]);
            newLib.add(game);
          }
       }
   }
        
    return newLib;
  }
  
}
