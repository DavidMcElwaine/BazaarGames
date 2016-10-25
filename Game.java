import java.util.Scanner;
import java.io.File;
import java.util.Date;
import java.text.DateFormat;

public class game{
	private String title;
	private int category;
	private double price;
	private String developer;
	private int sales;
    
	
	game(String name) throws Exception{
		Scanner games = new Scanner(new File(name + ".txt"));
		title = name;
		developer = games.nextLine().toString();
		category = games.nextInt();
		price = games.nextDouble();
		sales = games.nextInt();
	}
	
	
	String getTitle(){
		return title;
	}
	int getCategory(){
		return category;
	}
	double getPrice(){
		return price;
	}
	String getDeveloper(){
		return developer;
	}
	int getSales(){
		return sales;
	}
	

}