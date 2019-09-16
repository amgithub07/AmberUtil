package getClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
/**
 * 25.2 找出並使用方法與欄位
 * 問題：需要找出任意類別裡的任何方法與欄位名稱
 * 解答：使用java.lang.reflect套件
 */
public class ListMethods {

	public static void main(String[] args) throws ClassNotFoundException {

		if (args.length == 0) {
			System.out.println("use ListMethods className");
			return;
		}

		Class c = Class.forName(args[0]);
		Constructor[] cons = c.getConstructors();
		printList("Constructors", cons);

		Method[] meths = c.getMethods();
		printList("methods", meths);
	}

	static void printList(String s, Object[] o) {
		System.out.println("***" + s + "***");
		for (int i = 0; i < o.length; i++) {
			System.out.println(o[i].toString());
		}
	}

}
