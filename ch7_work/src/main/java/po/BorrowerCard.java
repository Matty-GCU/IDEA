package po;

public class BorrowerCard {
	private Integer id;
	private String code;
	@Override
	public String toString() {
		return "���鿨��Ϣ[��ţ�"+id+",���ţ�"+code+"]";
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
