package getClass;

import java.lang.reflect.Method;
import java.util.Date;
/**
 * 25.2 找出並使用方法與欄位
 * 問題：需要找出任意類別裡的任何方法與欄位名稱
 * 解答：使用java.lang.reflect套件
 */
public class GetMethod {

	public static void main(String[] args) {

		//有人傳了一個我不知道類別的物件
		Object something = SomeOne.returnSomething();
		//但我知道他有一個work(String,Date)的方法

		//
		Class[] argTypes = { String.class, Date.class };
		Object[] argValues = { "Chocolate Chlips", new Date() };

		try {
			
			//取得不知名的類別
			Class clX = something.getClass();
			
			//取得該類別方法的Method物件
			Method worker = clX.getMethod("work", argTypes);
			
			//執行這個方法並傳入參數
			worker.invoke(new X(), argValues);
			
		} catch (Exception e) {

			System.err.println("Invoke failed:" + e);
		}

	}

}

class X {

	public void work(String s, Date d) {
		System.out.println(s + "," + d.toString());
	}
}

class SomeOne {
	public static X returnSomething() {
		return new X();
	}
}