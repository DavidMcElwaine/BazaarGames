public class Game{
	private String title;
	private String category;
	private double price;
	private String developer;
	private int sales;
	private int year;
	
	
	public Game(String title, String category, double price, String developer, int sales, int year) throws Exception{
		
		this.title = title;
		this.developer = developer;
		this.category = category;
		this.price = price;
		this.sales = sales;
		this.year = year;
	}
	
	public int getYear(){
		return year;
	}
	
	public String getTitle(){
		return title;
	}
	public String getCategory(){
		return category;
	}
	public double getPrice(){
		return price;
	}
	public void setPrice(double p){
		price = p;
	}
	public String getDeveloper(){
		return developer;
	}
	public int getSales(){
		return sales;
	}
	

}
