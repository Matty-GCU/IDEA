package psychology;
import java.util.*;
import java.io.*;
import input.*;
public class Administrator {
	//Question question=new StudentExam();//向上转型
	//StudentExam studentexam=(StudentExam) question;//向下转型
	StudentExam studentExam=new StudentExam();
	List<StudentExam> addlist=new ArrayList<StudentExam>();//存放添加进去的题目
	List<StudentExam> allList=new ArrayList<StudentExam>();//存放所有题目集合
	String topic;//题目
	String A,B,C,D;//选项
	int pointA,pointB,pointC,pointD;//选项分值
	int numTopic;//题目数量
	ExamResult examResult=new ExamResult();
	Scanner sc=new Scanner(System.in);
	public void addQuestion(){
		try {
			File file=new File("question-bank.txt");//创建File类的file对象
			FileWriter fw=new FileWriter(file,true);//追加写入
			System.out.print("选择录入题目的数量（0-50道）：");
			numTopic=Input.getInteger(Input.scanner.next(), 0);
			for(int i=0;i<numTopic;i++) {
				System.out.print("输入题目：");
				topic=sc.next();
				System.out.print("A.");
				A=sc.next();
				System.out.print("分值：");
				pointA=sc.nextInt();
				System.out.print("B.");
				B=sc.next();
				System.out.print("分值：");
				pointB=sc.nextInt();
				System.out.print("C.");
				C=sc.next();
				System.out.print("分值：");
				pointC=sc.nextInt();
				System.out.print("D.");
				D=sc.next();
				System.out.print("分值：");
				pointD=sc.nextInt();
				studentExam=new StudentExam(topic,A,B,C,D,pointA,pointB,pointC,pointD);
				addlist.add(studentExam);
			}
			for(int i=0;i<addlist.size();i++) {
				fw.write(addlist.get(i).toString());//学生信息写入文件
			}
			fw.flush();
			fw.close();//关闭输出流
		} 
		catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public List<StudentExam> generatePaper() {
		try {
			FileReader fr = new FileReader("question-bank.txt");//创建FileReader类的fr对象
			BufferedReader br=new BufferedReader(fr);//文件读入，向屏幕输出
			while((topic=br.readLine())!=null) {//判断读取到一行的字符是否为空
					String A=br.readLine();
					int pointA=Integer.valueOf(br.readLine());
					String B=br.readLine();
					int pointB=Integer.valueOf(br.readLine());
					String C=br.readLine();
					int pointC=Integer.valueOf(br.readLine());
					String D=br.readLine();
					int pointD=Integer.valueOf(br.readLine());
					allList.add(new StudentExam(topic,A,B,C,D,pointA,pointB,pointC,pointD));
			}
			br.close();
			fr.close();
		}
			catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		List<StudentExam> list=new ArrayList<StudentExam>(allList);//新列表，用于抽取随机生成题目
		System.out.println("请选择你要随机生成试卷的题目数量：");
		numTopic=Input.getInteger(Input.scanner.next(), 0);
		List<StudentExam> questionList=null;//空列表，用于生成试卷
		questionList=new ArrayList<StudentExam>();
		Random random=new Random();
		int questionSum=0;
		if(list.size()>=numTopic) {
			questionSum=numTopic;
		}
		else {
			questionSum=list.size();
		}
		for(int i=0;i<questionSum;i++) {
			int target=random.nextInt(list.size());
			questionList.add(allList.get(target));
			list.remove(target);
		}
		System.out.println("试卷已生成");
		return questionList;
		
	}
	public void setPaper() {
		 String[] rank = new String[4];//心理等级
		 String[] comment = new String[4];//评语
		 System.out.println("设置不同分数段对应的心理水平等级（健康，良好，中等，较差）");
		 System.out.println("100-75：");
		 rank[0]=sc.next();
		 System.out.print("评语：");
		 comment[0]=sc.next();
		 System.out.println("75-50：");
		 rank[1]=sc.next();
		 System.out.print("评语：");
		 comment[1]=sc.next();
		 System.out.println("50-25：");
		 rank[2]=sc.next();
		 System.out.print("评语：");
		 comment[2]=sc.next();
		 System.out.println("25-0：");
		 rank[3]=sc.next();
		 System.out.print("评语：");
		 comment[3]=sc.next();
		 examResult=new ExamResult(rank,comment);
	}
	
}
