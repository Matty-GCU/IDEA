package utility;

import java.util.Scanner;

/**
 * v0.1 2022/01/24
 * v0.2 2022/02/06更新  增加对单独输入小时或分钟的支持；增加无限重新开始的功能；优化统计结果的显示，为个位数的分钟数增加前缀0。
 */
public class TimeCounter {

    public static void main(String[] args) {
        while(true) {
            count();
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
                System.out.print((minuteSum / 60) + "h");
                System.out.println(((minuteSum % 60) < 10 ? "0" : "") + (minuteSum % 60) + "min");
                int minuteAvg = minuteSum / 7;
                System.out.println("7天日均" + (minuteAvg / 60) + "h" + (minuteAvg % 60) + "min");
                double minuteAvg2 = minuteSum / 3.5;
                System.out.println("7天两日均" + (int)(minuteAvg2 / 60) + "h" + (int)(minuteAvg2 % 60) + "min");
                break;
            }
            //获取输入的时长
            String[] hourAndMinute = str.split("h");
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
}
