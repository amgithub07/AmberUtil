package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class FileCompare {

	private static final String fileA = "/Users/hsinyiliu/Documents/eclipse-workspace/TrainCode_20190831/temp/test1.html";
	private static final String fileB = "/Users/hsinyiliu/Documents/eclipse-workspace/TrainCode_20190831/temp/test2.html";
	private static final String outputFile = "/Users/hsinyiliu/Documents/eclipse-workspace/TrainCode_20190831/temp/result.txt";
	private static int num = 0;
	
	
	public static void main(String[] args) {

		FileCompare o = new FileCompare();
		ArrayList<String> listA = o.readToList(fileA);
		ArrayList<String> listB = o.readToList(fileB);

		o.compareFile(listA, listB);
		System.out.println("num=" + num);
		// System.out.println(listB.size());
	}

	public ArrayList<String> readToList(String filepath) {

		ArrayList<String> list = new ArrayList<String>();
		BufferedReader br = null;
		try {

			File file = new File(filepath);
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (br != null) {
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

		// System.out.println("lineA="+lineA);
		BufferedWriter brResult = null;
		String lineStr = "-\n";
		try {
			//brResult = new BufferedWriter(new FileWriter(outputFile,true));
			brResult = new BufferedWriter (new OutputStreamWriter (new FileOutputStream (outputFile,true),"UTF-8"));
			for (int i = 0; i < listA.size(); i++) {
				String lineA = listA.get(i).toString();

				if (lineA == null) {
					continue;
				}

				if ("".equals(lineA)) {
					continue;
				}

				if (!listB.contains(lineA)) {
					num++;
					String str = "different line :"+ (i+1) + "-"+lineA+"\n";
					System.out.println(str);
					brResult.write(str);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (brResult != null) {
				try {
					brResult.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
