package po;

public class BorrowerCard {
	private Integer id;
	private String code;
	@Override
	public String toString() {
		return "借书卡信息[编号："+id+",卡号："+code+"]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
