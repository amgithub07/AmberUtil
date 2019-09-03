package file;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class Main {

	private static final String folderA = "/Users/hsinyiliu/Documents/eclipse-workspace/TrainCode_20190831/temp/nan1";
	private static final String folderB = "/Users/hsinyiliu/Documents/eclipse-workspace/TrainCode_20190831/temp/nan2";
	
	public static void main(String[] args) {

		FileList fA = new FileList();
		FileList fB = new FileList();
		FileCompare fc = new FileCompare();
		File dirFileA = new File(folderA);
		Map<String,ArrayList> mapA = fA.readFileToMap(dirFileA);
		System.out.println("mapA.size="+mapA.size());

		File dirFileB = new File(folderB);
		Map<String,ArrayList> mapB = fB.readFileToMap(dirFileB);
		System.out.println("mapB.size="+mapB.size());
		  
		for(Object a :mapA.keySet()) {
			for(Object b :mapB.keySet()) {
				if(a.equals(b)) {
					//System.out.println(a.toString()+","+b.toString()+" start... ");
					fc.compareFile(mapA.get(a), mapB.get(b));
					//System.out.println(a.toString()+","+b.toString()+" end ");
					
				}
			}
		}
		  
	}
	

}
