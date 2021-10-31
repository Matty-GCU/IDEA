package chapter04.stack;

public class BracketsMatcherDemo {
    public static void main(String[] args) {
        String target = "1*(2+3*4*(2-1)*(3+x)+5)-6)";
//        String target = "3+(1+2)*9";
        String left = "(";
        String right = ")";
        System.out.println("测试语句：" + target);
        System.out.println("测试结果" + BracketsMatcher.check(target, left, right));
    }
}
