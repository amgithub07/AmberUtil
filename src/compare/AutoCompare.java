package compare;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AutoCompare {

	private static final String fileA = "/Users/hsinyiliu/Documents/eclipse-workspace/TrainCode_20190831/temp/test1.html";
	private static final String fileB = "/Users/hsinyiliu/Documents/eclipse-workspace/TrainCode_20190831/temp/test2.html";
	private static final String outputFile = "/Users/hsinyiliu/Documents/eclipse-workspace/TrainCode_20190831/temp/result.txt";
	private static int num=0;
	
	public static void main(String[] args) {
		
		AutoCompare o = new AutoCompare();
		ArrayList<String> listA = o.addToList(fileA);
		ArrayList<String> listB = o.addToList(fileB);
		
		o.compareFile(listA, listB);
	}
	
	
	
	public ArrayList<String> addToList(String filepath) {
		
		ArrayList<String> list = new ArrayList<String>();
		BufferedReader br = null;
		try {
			
			File file = new File(filepath);
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			if(br !=null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	public void compareFile(ArrayList<String> listA, ArrayList<String> listB) {
		
		
		BufferedWriter brResult = null;
		
		try {
			
			brResult = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_8));
			int lineNum = 0;
			for(int i=0; i<listA.size(); i++) {
				String lineStr = "-\n";
				String lineA = listA.get(i).toString();
				if (lineA == null) {
					continue;
				}
				
				if ("".equals(lineA)) {
					//brResult.write(lineStr);
					continue;
				}
				
				
				for(int k=0; k<listB.size(); k++) {
					String lineB = listB.get(k).toString();
					//System.out.println("lineA="+lineA);
					if (lineA.equals(lineB)) {
						lineStr = "fileA第" + (i+1) + "行＝fileB第" + (k+1) + "行=>" + lineB + "\n";
						brResult.write(lineStr);
						lineNum++;
						break;
					}
					
				}
				
				
			}

			System.out.println("lineNum="+lineNum);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(brResult !=null) {
				try {
					brResult.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
