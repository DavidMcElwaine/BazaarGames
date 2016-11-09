public class Admin implements User{
	private static Admin instance = new Admin();
	private int control;
	
	private Admin(){
		this.username = "Admin";
		this.control =0;
	}
	public static Admin getInstance(){
		return instance;
	}
	public int getControl(){
		return control;
	}
	
}