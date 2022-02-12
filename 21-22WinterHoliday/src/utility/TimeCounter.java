package utility;

import java.util.Scanner;

/**
 * v0.1 2022/01/24创建
 * v0.2 2022/02/06更新  增加对单独输入小时或分钟的支持；增加无限重新开始的功能；优化统计结果的显示，为个位数的分钟数增加前缀0。
 * v0.3 2022/02/12更新  针对总时间为0、分钟数为0、小时数为0等特殊情况，优化统计结果的显示细节；加上try-catch语句，增强程序的容错性。
 */
public class TimeCounter {

    public static void main(String[] args) {
        while(true) {
            try {
                count();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void count() {
        System.out.println("===================");
        System.out.println("欢迎使用时间计算器！");
        Scanner scanner = new Scanner(System.in);
        //总时长，以分钟计
        int minuteSum = 0;
        while(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            //输入=表示完成录入，输出统计结果
            if("=".equals(str)) {
                System.out.println(format(minuteSum));
                System.out.println("7天日均" + format(minuteSum / 7));
                System.out.println("7天两日均" + format(minuteSum / 3.5));
                break;
            }
            //获取输入时间
            String[] hourAndMinute = str.split("h");
            //仅输入小时或分钟
            if(hourAndMinute.length == 1) {
                //仅输入小时（格式如：1h）
                if(str.contains("h")) {
                    minuteSum += Double.parseDouble(hourAndMinute[0]) * 60;
                }
                //仅输入分钟（格式如：35）
                else {
                    minuteSum += Integer.parseInt(hourAndMinute[0]);
                }
            }
            //输入小时+分钟（格式如：1h35）
            else if(hourAndMinute.length == 2) {
                minuteSum += Integer.parseInt(hourAndMinute[0]) * 60;
                minuteSum += Integer.parseInt(hourAndMinute[1]);
            }
            System.out.println("+");
        }
    }

    public static String format(double minutes) {
        return format((int) minutes);
    }

    public static String format(int minutes) {
        if(minutes == 0) {
            return "0min";
        }
        int h = minutes / 60;
        int minute = minutes % 60;
        String result = "";
        if(h != 0) {
            result += h + "h";
        }
        if(minute != 0) {
            result += (minute < 10 ? "0" : "") + minute + "min";
        }
        return result;
    }
}
