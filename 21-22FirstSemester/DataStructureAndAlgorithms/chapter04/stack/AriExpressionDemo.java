package chapter04.stack;

public class AriExpressionDemo {

    public static void main(String[] args) {
        String infix = "3+(1+2)*9";
        System.out.println("infix expression: " + infix);
        AriExpression e = new AriExpression();
        String postfix = postfix = e.toPostFix(infix);
        System.out.println("postfix expression: " + postfix);
        System.out.println("result:" + e.toValue(postfix));
    }

}
