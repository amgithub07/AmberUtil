package getClass;

import java.util.Calendar;
/**
 * 25.1 取得類別描述表
 * 問題：想要從一個類別名稱或個體，取得一個class物件
 * 解答：使用.class關鍵字取得該類別個體
 */
public class ClassKeyword {

	public static void main(String[] args) {

		System.out.println("try the classname keyword:");
		System.out.println("Object:" + Object.class);
		System.out.println("String:" + String.class);
		System.out.println("Calendar:" + Calendar.class);
		System.out.println("Current:" + ClassKeyword.class);
		System.out.println("Robin the Fearless:".getClass());
		System.out.println(Calendar.getInstance().getClass());
	}

}
