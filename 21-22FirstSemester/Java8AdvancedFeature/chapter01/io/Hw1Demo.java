package chapter01.io;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2021.9.3Java高级作业
 * 实现类似cmd窗口的文件目录显示和进退功能
 */
public class Hw1Demo {
    public static void main(String[] args) {
        Hw1CmdOperator hw1CmdOperator = new Hw1CmdOperator();
        System.out.println("getRoot():    " + Arrays.toString(hw1CmdOperator.getRootNames()));
        System.out.println("getChild():    " + Arrays.toString(hw1CmdOperator.getChildFiles()));
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String nextSting = sc.next();
            String endingSignal = "-1";
            if(endingSignal.equals(nextSting)) {
                return;
            }
            else if(hw1CmdOperator.updateFile(nextSting)) {
                System.out.println(Arrays.toString(hw1CmdOperator.getChildFiles()));
            }
        }
    }
}

