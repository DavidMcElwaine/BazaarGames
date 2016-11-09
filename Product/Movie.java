public class Movie extends Product{
	
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
	
	public Movie(){
		this.title = "null";
		this.price = 0;
		this.sales = 0;
		this.year = 0;
		this.genre = "null";
		this.runtime = 0;
		this.director = "null";
		this.studio = "null";
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
	
	public int getSales(){
		return sales;
	}
	
	public int getRuntime(){
		return runtime;
	}
	
	public String getDirector(){
		return director;
	}
	
	public String getStudio(){
		return studio;
	}
	
	public void buy(){
		System.out.println("Movie purchased");
	}
}
