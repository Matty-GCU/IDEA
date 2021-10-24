package chapter04.stack;

public class MatcherDemo {
    public static void main(String[] args) {
        String target = "( (1+2)*3+4) (";
        String left = "(";
        String right = ")";
        System.out.println("测试语句：" + target);
        System.out.println("测试结果" + Matcher.check(target, left, right));
    }
}
