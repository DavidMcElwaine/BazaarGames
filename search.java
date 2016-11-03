import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class search{

	
	public static ArrayList<String> getGSearchResult(String searchItem) throws Exception{
		ArrayList<String> result = new ArrayList<String>();
		Scanner gameDetails = new Scanner(new File("games.txt"));
		while(gameDetails.hasNext()){  //goes through each line in the file
			String line = gameDetails.nextLine(); 
			String[] temp = line.split(",");//splits the string into an array
			for(int i = 0; i < temp.length; i++){
				if(searchItem.matches(temp[i])){
					result.add(temp[0].toString());
				}
			}
		}
		HashSet<String> ridDuplicates = new HashSet<>();
		//puts the array into a hashset to get rid of duplicates
		ridDuplicates.addAll(result);
		result.clear();
		result.addAll(ridDuplicates);
		return result;
	} 
	
	
	public static ArrayList<String> getMSearchResult(String searchItem) throws Exception{
		ArrayList<String> result = new ArrayList<String>();
		Scanner gameDetails = new Scanner(new File("movies.txt"));
		while(gameDetails.hasNext()){  //goes through each line in the file
			String line = gameDetails.nextLine(); 
			String[] temp = line.split(",");//splits the string into an array
			for(int i = 0; i < temp.length; i++){
				if(searchItem.matches(temp[i])){
					result.add(temp[0].toString());
				}
			}
		}
		HashSet<String> ridDuplicates = new HashSet<>();
		//puts the array into a hashset to get rid of duplicates
		ridDuplicates.addAll(result);
		result.clear();
		result.addAll(ridDuplicates);
		return result;
	} 
	
}