package pojo;

public class SelectUserById {
	private Integer uid;
	private String uname;
	private String code;
	
	@Override
	public String toString() {
		return "�û���Ϣ[ѧ�ţ�"+uid+",������"+uname+",���鿨�ţ�"+code+"]";
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
