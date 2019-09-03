package file;

import java.io.*;
import java.util.*;

public class FileList {
	
	private static final String folderA = "/Users/hsinyiliu/Documents/eclipse-workspace/TrainCode_20190831/temp/abd";
	// 設定一個全域性動態陣列，來存放檔案路徑
	// 主要遍歷資料夾，包含所有子資料夾、檔案的情況時，用到遞迴，所以要這樣設定
	public static ArrayList<String> dirAllStrArr = new ArrayList<String>();
	private static Map mapA = new HashMap();
	
	
	public static void main(String[] args) throws Exception {
		File dirFile = new File(folderA);
		System.out.println(Dir(dirFile));
		DirAll(dirFile);
		System.out.println(dirAllStrArr);
		Map m = readFileToMap(dirFile);
		System.out.println(m.size());
		  for (Object key : m.keySet()) {
	            System.out.println(key.toString());
	        }
	}

	// 這裡是僅僅查詢當前路徑下的所有資料夾、檔案並且存放其路徑到檔案陣列
	// 由於遇到資料夾不查詢其包含所有子資料夾、檔案，因此沒必要用到遞迴
	public static ArrayList<String> Dir(File dirFile) throws Exception {
		ArrayList<String> dirStrArr = new ArrayList<String>();
		if (dirFile.exists()) {
			// 直接取出利用listFiles()把當前路徑下的所有資料夾、檔案存放到一個檔案陣列
			File files[] = dirFile.listFiles();
			for (File file : files) {
				// 如果傳遞過來的引數dirFile是以檔案分隔符，也就是/或者\結尾，則如此構造
				if (dirFile.getPath().endsWith(File.separator)) {
					dirStrArr.add(file.getName());
				} else {
					// 否則，如果沒有檔案分隔符，則補上一個檔案分隔符，再加上檔名，才是路徑
					dirStrArr.add(file.getName());
				}
			}
		}
		return dirStrArr;
	}

	public static ArrayList<String>  DirAll(File dirFile)  {
		
		ArrayList<String> dirStrArr = new ArrayList<String>();
		
		try {
			if (dirFile.exists()) {
				File files[] = dirFile.listFiles();
				for (File file : files) {
					// 如果遇到資料夾則遞迴呼叫。
					if (file.isDirectory()) {
						// 遞迴呼叫
						DirAll(file);
					} else {
						// 如果遇到資料夾則放入陣列
						if (dirFile.getPath().endsWith(File.separator)) {
							dirAllStrArr.add(file.getName());
						} else {
							dirAllStrArr.add(dirFile.getPath()+File.separator+file.getName());
						}
					}
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dirAllStrArr;
	}
	
	public static Map readFileToMap(File dirFile) {
		Map map = new HashMap();
		Map map2 = readFileToMap(map,dirFile);
		return map2;
	}
	public static Map readFileToMap(Map map, File dirFile) {
	
		
		
		try {
			if (dirFile.exists()) {
				File files[] = dirFile.listFiles();
				for (File file : files) {
					// 如果遇到資料夾則遞迴呼叫。
					if (file.isDirectory()) {
						// 遞迴呼叫
						readFileToMap(map,file);
					} else {
						
						String filePath = dirFile.getPath()+File.separator+file.getName();
						
						ArrayList<String> list = readToList(filePath);
						
						map.put(file.getName(), list);
					}
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	public static ArrayList<String> readToList(String filepath) {

		ArrayList<String> list = new ArrayList<String>();
		BufferedReader br = null;
		try {

			File file = new File(filepath);
			//br = new BufferedReader(new FileReader(file));
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
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

}
