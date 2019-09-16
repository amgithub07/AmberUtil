package getClass;

import java.lang.reflect.Field;
import java.util.Calendar;
/**
 * 25.2 找出並使用方法與欄位
 * 問題：需要找出任意類別裡的任何方法與欄位名稱
 * 解答：使用java.lang.reflect套件
 */
public class FindField {

	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		FindField gf = new FindField();
		Object o = new YearHolder();
		int value = gf.intFieldValue(o, "currentYear");
		System.out.println("currentYear=" + value);
	}

	int intFieldValue(Object o, String s)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class c = o.getClass();
		Field fld = c.getField(s); //public int getClass.YearHolder.currentYear
		int value = fld.getInt(o);
		return value;
	}

}

class YearHolder {
	public int currentYear = Calendar.getInstance().get(Calendar.YEAR);
}
