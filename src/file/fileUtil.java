package file;

public class fileUtil {

	private static final String folderA = "/Users/hsinyiliu/Documents/eclipse-workspace/TrainCode_20190831/temp/nan1";
	
	public static void main(String[] args) {

		fileUtil f = new fileUtil();
		
		f.getFileList(folderA);
	}

	public void getFileList(String folderPath) {
		// String folderPath = "C:\\";//資料夾路徑
		StringBuffer fileList = new StringBuffer();
		try {
			java.io.File folder = new java.io.File(folderPath);
			String[] list = folder.list();
			for (int i = 0; i < list.length; i++) {
				fileList.append(list[i]).append(", ");
			}
		} catch (Exception e) {
			System.out.println("'" + folderPath + "'此資料夾不存在");
		}
		System.out.println(fileList);
	}
	
	
	

}
