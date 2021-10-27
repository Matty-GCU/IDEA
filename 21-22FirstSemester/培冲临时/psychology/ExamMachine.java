package psychology;
import java.io.*;
import java.util.*;
import input.*;
public class ExamMachine extends Administrator{
	//Scanner sc=new Scanner(System.in);
	List idList=new ArrayList();
	List resultList=new ArrayList();
	Map<String,String> map=new HashMap<String,String>();
	public String[] exam(List<StudentExam> studenttest){
		long time=60;
		Date date=new Date();
		long endTime=date.getTime()+time*1000;
		long nowTime;
        String[] answers=new String[studenttest.size()];
        for(int i=0;i<studenttest.size();i++){
            nowTime=new Date().getTime();
            if(nowTime>endTime) {
            	System.out.println("对不起测试时间已结束！");
            	return answers;
            }
            System.out.println((i+1)+"."+studenttest.get(i).link());
            System.out.println("请输入你的选择：");
            answers[i]=sc.nextLine();
        }
        System.out.println("共"+studenttest.size()+"道题。\n");   
        for(int i=0;i<answers.length;i++) {
        	nowTime=new Date().getTime();
            if(nowTime>endTime) {
            	System.out.println("对不起测试时间已结束！");
            	return answers;
            }
        	if(!(answers[i].equals("A")||answers[i].equals("B")||answers[i].equals("C")||answers[i].equals("D"))) {
        		System.out.println("你还有题目未答完！");
        		System.out.println((i+1)+"."+studenttest.get(i).link());
                System.out.println("请输入你的选择：");
                answers[i]=sc.nextLine();
        	}
        }
                return answers;
        }
	public int checkExam(List<StudentExam> studentresult,String[] an) {
		int score=0;
		for(int i=0;i<studentresult.size();i++) {
			
				if(an[i].equals("A")) {
					score+=studentresult.get(i).getScoreA();
			}
				else if(an[i].equals("B")) {
					score+=studentresult.get(i).getScoreB();
				}
				else if(an[i].equals("C")) {
					score+=studentresult.get(i).getScoreC();
				}
				else if(an[i].equals("D")) {
					score+=studentresult.get(i).getScoreD();
				}
		}
		return score;
	}
	public String testResult(int num) {
			if(num<=100&&num>75) {
				return examResult.level[0];
			}
			else if(num<=75&&num>50) {
				return examResult.level[1];
			}
			else if(num<=50&&num>25) {
				return examResult.level[2];
			}
			else if(num<=25&&num>=0) {
				return examResult.level[3];
			}
			return null;
	}
	//查看学生心理测试结果
	public void seekResult(Map<String,String> m) {
		Iterator iter=m.keySet().iterator();
		while(iter.hasNext()) {
			String key=(String)iter.next();
			String value=(String)m.get(key);
			System.out.println(key);
			System.out.println(value);
		}
	}
	//系统分析并统计结果
	public void analyzeResult(Map<String,String> m) {
		Map<String,Integer> analyzeResult=new HashMap<String,Integer>();
		Iterator iter=m.keySet().iterator();
		Iterator iter2=analyzeResult.keySet().iterator();
		int length=m.size();
		String[] s=new String[length];
		int n=0;
		while(iter.hasNext()) {
			String key=(String)iter.next();
			String value=(String)m.get(key);
			s[n]=value;
			n++;
		}
		for(int i=0;i<length;i++) {
			int num=0;
			for(int j=0;j<length;j++) {
				if(s[i].contains(s[j])) {
					num++;
				}
			}
			analyzeResult.put(s[i], num);
		}
		for(Map.Entry<String, Integer> entry:analyzeResult.entrySet()) {
			System.out.println(entry.getKey()+"\t人数为："+entry.getValue());
		}
	}
	public Map<String,String> result() {
		try {
			FileReader fr;
			fr = new FileReader("result.txt");
			BufferedReader br=new BufferedReader(fr);
			String line=br.readLine();
			while(line!=null) {
				idList.add(line);
				line=br.readLine();
			}
			br.close();
			fr.close();
		}
		catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();  
		}
		String[] al=(String[])idList.toArray(new String[idList.size()]);
		for(int i=0;i<al.length-1;i+=2) {
			map.put(al[i], al[i+1]);
		}
		return map;
	}
}
