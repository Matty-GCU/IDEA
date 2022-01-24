package utility;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @date 2022/01/24
 */
public class TimeCounter {
    public static void main(String[] args) {
        System.out.println("欢迎使用时间计算器！");
        Scanner scanner = new Scanner(System.in);
        //总分钟数
        int minuteSum = 0;
        while(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if("=".equals(str)) {
                System.out.println((minuteSum / 60) + "h" + (minuteSum % 60) + "min");
                int minuteAvg = minuteSum / 7;
                System.out.println("7天日均" + (minuteAvg / 60) + "h" + (minuteAvg % 60) + "min");
                double minuteAvg2 = minuteSum / 3.5;
                System.out.println("7天两日均" + (int)(minuteAvg2 / 60) + "h" + (int)(minuteAvg2 % 60) + "min");
                break;
            }
            String[] hourAndMinute = str.split("h");
            minuteSum += Integer.parseInt(hourAndMinute[0]) * 60;
            minuteSum += Integer.parseInt(hourAndMinute[1]);
            System.out.print("+");
        }
    }
}
