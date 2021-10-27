package input;

import java.util.*;

public class Input {
	public static Scanner scanner = new Scanner(System.in);
	 /**
	  * 将字符串转为整型数，如果输入的字符串不是整型数，则返回参数中的int数
	  * 
	  * @param numStr
	  *            要转换的字符串
	  * @param deInt
	  *            默认的整型数
	  * @return 返回转换的结果
	  */
	 public static int getInteger(String input, int flag) {
	  int common=0;
	  try {
	   common=Integer.parseInt(input);
	  } catch (Exception e) {
	   common=flag;
	   System.out.println("输入格式错误！");
	  }
	  
	  return common;
	 }
	 public static long getLong(String input, long flag) {
		  long common=0;
		  try {
		   common=Long.parseLong(input);
		  } catch (Exception e) {
		   common=flag;
		  }
		  System.out.println("输入格式错误！");
		  return common;
		 }
}
