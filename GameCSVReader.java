/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazaar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author EoinH
 */
public class GameCSVReader {
    public static Game getGameDetails(String gameName) throws FileNotFoundException{
    Scanner  details = new Scanner(new File("games.txt"));
    Game result;

     while(details.hasNext()){
        String currentLine = details.nextLine();
        System.out.println(currentLine);
        String [] gameInfo = currentLine.split(",");
        if(gameInfo[0].matches(gameName)){
                result = new Game (gameInfo[0],Double.parseDouble(gameInfo[1]),Integer.parseInt(gameInfo[2]),Integer.parseInt(gameInfo[3]),gameInfo[4],
                        Integer.parseInt(gameInfo[5]),gameInfo[6],Boolean.parseBoolean(gameInfo[7]));
                return result;
            
         }
     }
    details.close();
        
    return null;
    }
}
