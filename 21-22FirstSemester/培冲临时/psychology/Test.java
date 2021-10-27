package psychology;
import java.io.*;
import java.util.*;
import input.*;
public class Test{
	public static void main(String[] args) {
		Login user=new Login();//初始化登录类
		Administrator administrator=new ExamMachine();//向上转型
		ExamMachine examMachine=new ExamMachine();//初始化考试机器类
		Student student=new Student();//创建学生对象
		int choice;//登录类型的选择
		int score=0;//学生分数
		int judgement;//学生功能选择
		String[] answer = null;//学生测试的选择
		List<StudentExam> testList = null;//生成试卷的列表
		Scanner sc=new Scanner(System.in);
		while(true) {
			
			System.out.println("---------请选择登录的用户的类型：---------\n");
		System.out.println("\t1.管理员 2.学生 0.退出系统\n");
		System.out.println("-----------------------------------------");
		judgement=Input.getInteger(Input.scanner.next(), 0);
			if(judgement==1) {
				boolean flag=user.check();//判断管理员账号密码是否输入正确
					while(flag) {
						System.out.println("----------------------------\n");
						System.out.println("1.录入题目     ");
						System.out.println("2.选择题目并生成试卷");
						System.out.println("3.设置心理等级和评语");
						System.out.println("4.查看学生测试记录和结果");
						System.out.println("5.对心理测试结果进行统计和分析");
						System.out.println("0.退出管理员登录");
						System.out.println("\n----------------------------");
						choice=Input.getInteger(Input.scanner.next(), 0);
						switch(choice) {
						case 1:administrator.addQuestion();break;//添加试卷
						case 2:testList=administrator.generatePaper();break;//生成试卷
						case 3:administrator.setPaper();break;//设置心理等级和评语
						case 4:examMachine.seekResult(examMachine.result());break;//查看测试结果
						case 5:examMachine.analyzeResult(examMachine.result());break;//对心理测试结果进行统计和分析
						case 0:flag=false;break;//终止while循环
						}
					}
			}
			else if(judgement==2){
				boolean flag=true;
				System.out.println("完善你的个人信息：");
				String stuName;//姓名
				String stuMajor;//专业
				long stuID;//学号
				String stuGrade;//班级
				System.out.print("输入姓名：");
				stuName=sc.next();
				System.out.print("输入专业：");
				stuMajor=sc.next();
				System.out.print("输入学号：");
				stuID=Input.getLong(Input.scanner.next(), 0);
				System.out.print("输入班级：");
				stuGrade=sc.next();
				if(stuID==0) {
					flag=false;
				}
				try {
					FileReader fr = new FileReader("ID-list.txt");
					BufferedReader br=new BufferedReader(fr);
					String line=br.readLine();
					while(line!=null) {
						String[] strings=line.split(" ");
						long[] ids = new long[strings.length];
						line=br.readLine();
						for(int i=0;i<strings.length;i++) {
							ids[i]=Long.parseLong(strings[i]);
						if(stuID==ids[i]) {
							System.out.println("你已经参加过测试！");
							flag=false;
							break;
						}
					}
					}
					br.close();
					fr.close();
				}
				catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				student=new Student(stuName,stuMajor,stuID,stuGrade);
				while(flag) {//进入学生功能
				System.out.println("1.进入考试\t2.查看心理测评记录和结果\t0.退出学生登录");
				choice=Input.getInteger(Input.scanner.next(), 0);
				switch(choice) {
				case 1:
					if(testList==null) {//试卷为空
						System.out.println("试卷还未生成...");
						break;
					}
					try {
						if(student.getConstant()==0) {
							String result="测试结果：";
							String strID;
							answer=student.exam(testList);//进入测试
							score=student.checkExam(testList,answer);//学生分数
							result+=examMachine.testResult(score);//测试结果				
							student.setConstant(1);
								File file=new File("result.txt");//测试结果写入文本
								FileWriter fw=new FileWriter(file,true);//文本内容追加
								BufferedWriter bw=new BufferedWriter(fw);
								File file1=new File("ID-list.txt");//测试结果写入文本
								FileWriter fw1=new FileWriter(file1,true);//文本内容追加
								BufferedWriter bw1=new BufferedWriter(fw1);
								bw.write(student.toString());	//写入学生基本信息
								bw.newLine();//换行
								bw.write(result);//写入测试结果
								bw.newLine();//换行
								strID=String.valueOf(student.getID());
								bw1.write(strID);//写入学生学号
								bw1.write(" ");
								bw.close();//文件关闭
								bw1.close();//文件关闭	
						}
						else {
							System.out.println("你已经参加过测试！");
						}
					} 
					catch (IOException e) {
	 					// TODO 自动生成的 catch 块
						e.printStackTrace();
					}break;
				case 2:
					if(answer==null) {//测评记录为空
						System.out.println("暂无测评记录与结果！");
						break;
					}
					else {
						System.out.println("你的测试结果为：");
						System.out.println("你的分数为："+score);
						System.out.println("你的心理等级为："+examMachine.testResult(score));
						break;
					}	
				case 0:flag=false;break;//结束学生功能
				}
				}
			}
			else if(judgement==0){
				System.exit(0);//退出系统
			}
			}
}
}
	
	
	
	



