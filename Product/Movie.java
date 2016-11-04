public class Movie{
	
	private int runtime; // in minutes
	private String director;
	private String studio;
	
	private String title;
	private double price;
	private int sales;
	private int year;
	private String genre;

	public Movie(String title, double price, int sales, int year, String genre, int runtime, String director, String studio){
	
		this.title = title;
		this.price = price;
		this.sales = sales;
		this.year = year;
		this.genre = genre;
		this.runtime = runtime;
		this.director = director;
		this.studio = studio;
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
	
	public double getYear(){
		return year;
	}
	
	public double getRuntime(){
		return runtime;
	}
	
	public double getDirector(){
		return director;
	}
	
	public double getStudio(){
		return studio;
	}
	
	public void buy(){
	}
}