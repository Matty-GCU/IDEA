package psychology;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Login {
	String ID;
	String password;
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Login() {
		System.out.println("系统启动中。。。");
	}
	public Login(String ID,String password) {
		this.setID(ID);
		this.setPassword(password);
	}
	private Map<String,String> administrator=new HashMap<String,String>();
	{
		administrator.put("张老师","123");
	}
	public boolean check() {
		try{
			InputStreamReader ir=new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(ir);
			System.out.print("输入ID：");
			ID = in.readLine();
			System.out.print("输入密码：");
			password = in.readLine(); 
			
		}catch(IOException e){
		System.out.println("错误信息为："+e.toString());
		}
		if(administrator.get(ID)!=null && administrator.get(ID).equals(password)){
			System.out.println("管理员登录成功！");
	        return true;
	    }
	    else { 
	    	System.out.println("信息输入错误！");
	        return false;
	    }
	}
	
}
	
