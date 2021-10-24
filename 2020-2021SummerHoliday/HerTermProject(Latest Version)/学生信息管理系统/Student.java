package 学生信息管理系统;
/**
 * 此类利用属性来存储学生信息
 */
public class Student {
	String ID,name,telephone,dormitory,classes;
	/**
	 * 参数ID、name、telephone、dormitory和classes用于接收传递给构造方法的数据，并且将参数的值存储到学生类的属性中
	 * @param ID
	 * @param name
	 * @param telephone
	 * @param dormitory
	 * @param classes
	 */
	public Student(String ID,String name,String telephone,String dormitory,String classes) {
		this.ID = ID;
		this.name = name;
		this.telephone = telephone;
		this.dormitory = dormitory;
		this.classes = classes;
	}

}
