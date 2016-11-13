package bazaar;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryCSVWriter {
    public static void addToLibrary(String username,  ArrayList<Product> games)throws IOException
    {
        ArrayList <String> lines = new ArrayList<>();
        String line;
        File file = new File ("library.csv");
        System.out.println("username = " + username);
        if(file.exists())
        {
            Scanner in = new Scanner(file);
            while(in.hasNext())
            {
                line = in.nextLine();
                if (line.contains(username))
                {
                    System.out.println("If hit");
                    for (int i =0; i < games.size();i++)
                        line += games.get(i).getTitle() + ",";
                    lines.add(line);
                }
                else
                {
                    lines.add(line);
                }
            }
            in.close();
            PrintWriter out = new PrintWriter (file);
            for (int i =0;  i < lines.size();i++)
                out.println(lines.get(i));
            out.close();
        }
        else
            System.out.println("library.csv does not exist");
    }
}
