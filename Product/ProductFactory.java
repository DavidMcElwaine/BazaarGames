public class ProductFactory{
	public static Product getProduct(String type){
		if(type.equals("Game")) return new Game();
		else if(type.equals("Movie")) return new Movie();
		else return null;
	}
}
