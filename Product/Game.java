public class Game implements Product{
	
	private int numberOfPlayers;
	private String developer;
	private boolean onlineSupport;
	
	private String title;
	private double price;
	private int sales;
	private int year;
	private String genre;
	
	public Game(String title, double price, int sales, int year, String genre, int numberOfPlayers, String developer, boolean onlineSupport){
		
		this.title = title;
		this.price = price;
		this.sales = sales;
		this.year = year;
		this.genre = genre;
		this.numberOfPlayers = numberOfPlayers;
		this.developer = developer;
		this.onlineSupport = onlineSupport;
	}
	
	public int getYear(){
		return year;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getGenre(){
		return genre;
	}
	
	public double getPrice(){
		return price;
	}
	
	public double getSales(){
		return sales;
	}
	
	public String getDeveloper(){
		return developer;
	}
  
  	public int getNumberOfPlayers(){
		return numberOfPlayers;
	}
	
 	public boolean getOnlineSupport(){
		return onlineSupport;
	}
	
	public void buy(String username, String title){
	}
}
