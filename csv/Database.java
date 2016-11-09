import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Database {
    private ArrayList<Product> allProducts;
    private ArrayList<User> allUsers;
    private Scanner in;
    
    public Database()throws IOException
    {
        allProducts = new ArrayList<Product>();
        allUsers = new ArrayList<User>();
        readGames();
    }
    public void readGames() throws IOException
    {
        Game game;
       
        File file = new File("games.txt");
        if (file.exists()){
            in = new Scanner(file);
            String line;
            String lineElements[];
            while(in.hasNext())
            {
                line = in.nextLine();
                lineElements = line.split(",");
                game = new Game(lineElements[0],Double.parseDouble(lineElements[1]),Integer.parseInt(lineElements[2]),Integer.parseInt(lineElements[3]),lineElements[4],Integer.parseInt(lineElements[5]),lineElements[6],Boolean.parseBoolean(lineElements[7]));
                allProducts.add(game);
            }
            in.close();
        }
        else {
            System.out.print("No games.txt file");
        }
    }
    public ArrayList <Product> giveProductList()
    {
        return allProducts;
    }
    public ArrayList <User> giveUserList()
    {
        return allUsers;
    }
    public void addUser(User user)throws IOException
    {
        File file = new File("users.txt");
        
        if (file.exists()){
            in = new Scanner(file);
            while(in.hasNext())
            {
            }
        }
        in.close();
        PrintWriter out = new PrintWriter(file);
        out.print("" + user.getName() + "," + user.getNumFriends() + "," + user.getNumReviews() +"," + user.getSpendings() + "," + user.getBalance());
        
    }
}



