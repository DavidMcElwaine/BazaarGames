/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazaar;

/**
 *
 * @author EoinH
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author EoinH
 */
public class StoreCSVReader {
    public static ArrayList<Product> getAll() throws FileNotFoundException{
        ArrayList<Product> all = new ArrayList<>();
        Game game;
        File inFile = new File ("games.csv");
        String line;
        String[] lineElements;
        if (inFile.exists())
        {
            Scanner in = new Scanner (inFile);
            while(in.hasNext()){
                line = in.nextLine();
                lineElements = line.split(",");
                game = new Game(lineElements[0],Double.parseDouble(lineElements[1]),Integer.parseInt(lineElements[2]),Integer.parseInt(lineElements[3]),lineElements[4],
                        Integer.parseInt(lineElements[5]),lineElements[6],Boolean.parseBoolean(lineElements[7]));
                all.add(game);
            }           
            in.close();
        }
        else 
            System.out.println("games.csv Not found");
        return all;
    }
}