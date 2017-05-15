import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * 
 * Created by Adolfo Segura
 * 
 */

class Main{
	public static void main(String[] args){
		String fileName = "alice.txt";
		BuildHash obj = new BuildHash(fileName);
		
	}
}

class BuildHash {
	
	public BuildHash(String fileName){
		
		try{
			String line;
			int wc = 0;			
			HashMap<String,Integer> map = new HashMap();
			
			File file = new File(fileName);
			Scanner src = new Scanner(file).useDelimiter(",|\r\n|\n| |'|-|\\.|\\*|\\[|\\]|_|\\!|\\?|\\(|\\)|\"|[0..9]|\\!|;|3|:");
			
			while(src.hasNext()){
				line = src.next();
				if(map.get(line.toUpperCase()) == null) {
					map.put(line.toUpperCase(),1);
				}
				else{
					wc = map.get(line.toUpperCase());
					map.put(line.toUpperCase(),wc + 1);
				}
			}
			treeSort hTable = new treeSort(map);
		}
		catch(FileNotFoundException e){
			System.err.println("No file found");
		}
		catch(IOException e) {
			System.err.println("IOException");
		}
	}
}

class treeSort{
	
	treeSort(HashMap myHMap) {
		
		int count = 0;
		String line;
		int val;
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		treeMap.putAll(myHMap);
		
		for(HashMap.Entry<String, Integer> temp : treeMap.entrySet()) {
			line = temp.getKey();
			val = temp.getValue();
			
			if(count != 0) {
				System.out.println(line + " " + val);
			}
			count++;
		}
	}
}

