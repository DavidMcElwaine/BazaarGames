import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryCSVReader {
    
    
  public static ArrayList<String> getLibrary(String username) throws FileNotFoundException{
  ArrayList<String> newLib = new ArrayList<String>();
  Scanner lib = new Scanner(new File("library.csv"));
                
   while(lib.hasNext()){
      String libLine = lib.nextLine();
      String [] library = libLine.split(",");
      if(library[0].matches(username)){
          for(int i = 1 ; i < library.length ; i++){
            newLib.add(library[i]);
          }
       }
   }
        
    return newLib;
  }
}
