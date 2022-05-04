import java.util.Scanner;

/**
 * v0.1 2022/01/24创建
 * v0.2 2022/02/06更新  增加对单独输入小时或分钟的支持；增加无限重新开始的功能；优化统计结果的显示，为个位数的分钟数增加前缀0。
 * v0.3 2022/02/12更新  针对总时间为0、分钟数为0、小时数为0等特殊情况，优化统计结果的显示细节；加上try-catch语句，增强程序的容错性。
 * v0.4 2022/05/01更新  增加对“x.5”（x个半小时）的格式支持；优化显示细节，加号不换行；优化提示细节，弃用JDK自带报错，改用温馨提示。
 */
public class TimeCounter {

    public static void main(String[] args) {
        while(true) {
            try {
                count();
            }
            catch(Exception e) {
                // 温馨提示
                System.out.println("输入格式错误，请重试！");
                System.out.println("合法输入示例：1h、2.5h、1h05、1h25、3h47、5、05、25");
                System.out.println("非法输入示例：1.5、1.5h25、1h25min、1h2.5、25min");
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
                // 在学校的时候用不到这两个功能
                // System.out.println("7天日均" + format(minuteSum / 7));
                // System.out.println("7天两日均" + format(minuteSum / 3.5));
                break;
            }
            //获取输入时间
            String[] hourAndMinute = str.split("h");
            //仅输入小时或分钟
            if(hourAndMinute.length == 1) {
                //仅输入小时（格式如：1h或2.5h）
                if(str.contains("h") || str.contains(".5h")) {
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
            System.out.print("+");
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
