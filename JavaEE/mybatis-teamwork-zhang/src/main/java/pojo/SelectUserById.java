package pojo;

public class SelectUserById {
	private Integer uid;
	private String uname;
	private String code;
	
	@Override
	public String toString() {
		return "用户信息[学号："+uid+",姓名："+uname+",借书卡号："+code+"]";
	}
	public Integer getuId() {
		return uid;
	}
	public void setId(Integer uid) {
		this.uid = uid;
	}
	public String getuName() {
		return uname;
	}
	public void setuName(String uname) {
		this.uname = uname;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
