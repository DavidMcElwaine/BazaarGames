import java.util.Scanner;
import java.io.File;
import java.util.Calendar;

public class Game{
	private String title;
	private int category;
	private double price;
	private String developer;
	private int sales;
	private Calendar date = Calendar.getInstance();
    
	
	Game(String name) throws Exception{
		Scanner games = new Scanner(new File(name + ".txt"));
		title = name;
		developer = games.nextLine().toString();
		category = games.nextInt();
		price = games.nextDouble();
		sales = games.nextInt();
		int day = games.nextInt();
		int month = games.nextInt();
		int year = games.nextInt();
	    date.set(date.YEAR, year);
        date.set(date.MONTH, month);
        date.set(date.DAY_OF_MONTH, day);
	}
	String getDate(){
		String dob = date.get(date.DAY_OF_MONTH) + "/" + date.get(date.MONTH) + "/" + date.get(date.YEAR);
	
		return dob;
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
	void setPrice(double p){
		price = p;
	}
	String getDeveloper(){
		return developer;
	}
	int getSales(){
		return sales;
	}
	

}
