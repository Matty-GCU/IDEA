package 学生信息管理系统;
import java.io.*;
import java.util.*;
/**
 * 此类继承了泛型类LinkedList<Student>
 * 负责读取文件，将文件中数据进行解析，创建学生类对象；
 * 对存储学生对象的链表进行添加、删除、修改或查询操作；
 * 处理链表中的数据，并重新写入到文件中
 */
public class Function extends LinkedList<Student>{
	Scanner scanner = new Scanner(System.in);
	Student stu;
	File file;
	String regex = "，";
	String str,path,name;
	String[] s;
	/**
	 * 该方法负责更改文件路径
	 */
	public void setFile(String path,String name) {
		file = new File(path,name);
	}
	/**
	 * 读取文件中的信息，将信息进行解析，并利用信息创建新的学生对象
	 */
	Function() {
		FileReader reader;
		BufferedReader bReader;
		try {
			setFile("F:\\src","学生信息.txt");
			reader = new FileReader(file);
			bReader = new BufferedReader(reader);
			while((str = bReader.readLine())!= null) {
				s = str.split(regex);
				stu = new Student(s[0],s[1],s[2],s[3],s[4]);
				add(stu);
			}
			reader.close();
			bReader.close();
		} catch(IOException e) {
			System.out.println("读取文件失败");
		}
	}
	/**
	 * 利用参数s1至s5创建新的学生对象，并且将新的对象添加至链表中
	 * @param s1
	 * @param s2
	 * @param s3
	 * @param s4
	 * @param s5
	 * @return
	 */
	public String addStudent(String s1,String s2,String s3,String s4,String s5) {
		Student student = new Student(s1,s2,s3,s4,s5);
		add(student);
		return "添加成功！";
	}
	/**
	 * 利用参数s1至s5传递的数据在链表中进行查找，将符合条件的结点删除，并返回字符串
	 */
	public String deleteStudent(String s1,String s2,String s3,String s4,String s5) {
		int i = search(s1,s2,s3,s4,s5);
		stu = remove(i);
		String str = stu.ID+"，"+stu.name+"，"+stu.telephone+"，"+stu.dormitory+"，"+stu.classes;
		return "“"+str+"”"+"删除成功！";
	}
	/**
	 * 参数s作为条件，通过遍历链表查找出符合条件的结点并输出
	 */
	public String searchStudent(String s) {
		String str = null;
		boolean b = false;
		Iterator iter = iterator();
		while(iter.hasNext()) {
			Student student = (Student)iter.next();
			if(s.equals(student.ID)||s.equals(student.name)||s.equals(student.telephone)||s.equals(student.dormitory)||s.equals(student.classes)) {
				str = "您查询的学生信息如下：\n"+student.ID+"，"+student.name+"，"+student.telephone+"，"+student.dormitory+"，"+student.classes;
				b = true;
			}
		}
		if(b == false) {
			return "查无此人";
		}
		else{
			return str;
		}
	}
	/**
	 * 参数整型i作为节点位置，利用参数字符串传递的新信息创建新的学生对象，将需修改的学生替换
	 */
	public String change(int i,String s1,String s2,String s3,String s4,String s5) {
		Student student = new Student(s1,s2,s3,s4,s5);
		set(i, student);
		String str = student.ID+"，"+student.name+"，"+student.telephone+"，"+student.dormitory+"，"+student.classes;
		return "修改成功！\n"+str;
	}
	/**
	 * 将经修改的链表中学生信息写入文件中
	 */
	public void fileWriter() {
		FileWriter writer;
		BufferedWriter bWriter;
		String str;
		// TODO Auto-generated method stub
		try {
			writer = new FileWriter(file,false);
			bWriter = new BufferedWriter(writer);
			Iterator iter = iterator();
			while(iter.hasNext()) {					
				Student s = (Student)iter.next();
				str = s.ID+"，"+s.name+"，"+s.telephone+"，"+s.dormitory+"，"+s.classes;
				bWriter.write(str);
				bWriter.newLine();
				bWriter.flush();
			}
			writer.close();
			bWriter.close();
		} catch(IOException e) {
			System.out.println("写入失败");
		}
	}
	/**
	 * 此方法用于辅助删除和修改功能，遍历链表
	 */
	public int search(String s1,String s2,String s3,String s4,String s5) {
		int i = 0;
		Iterator iter = iterator();
		while(iter.hasNext()) {
			stu = (Student)iter.next();
			if(s1.equals(stu.ID)||s2.equals(stu.name)||s3.equals(stu.telephone)||s4.equals(stu.dormitory)||s5.equals(stu.classes)) {
				i = indexOf(stu);
			}
		}
		return i;
	}
}

