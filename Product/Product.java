package bazaar;

public abstract class Product{
        private String title;
	private double price;
	private int sales;
	private int year;
	private String genre;
	public void buy(){}
	
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
	
	public int getSales(){
		return sales;
	}
}
