package chapter04.stack;

/**
 * 算术表达式类(Arithmetic Expression)
 * 在使用时有如下限制：
 * 数字只能是个位数整数；运算符只能是加减乘除求余5种。
 * @author Matty's PC
 */
public class AriExpression {//功能是什么？用之间用不用Matcher检查一下括号的匹配

    AriCounter ariCounter;

    public AriExpression() {
        ariCounter = new AriCounter();
    }

    /**
     * @param infix 中序表达式
     * @return 后续表达式
     */
    public String toPostFix(String infix) {
        System.out.println(BracketsMatcher.check(infix, "(", ")"));
        //选用LinkedList，因为我实现的那个SequentialList的push和pop的时间效率都比较低
        Stack<Character> stack = new LinkedStack<>();
        //选用StringBuilder，因为这里是单线程场景
        StringBuilder postfix = new StringBuilder();
        int i = 0;
        while(i < infix.length()) {
            char ch = infix.charAt(i);
            if(ch >= '0' && ch <= '9') {
                //将数字添加到后缀表达式，以空格为界
                postfix.append(ch).append(" ");
                i++;
            }
            else {
                switch(ch) {
                    //跳过空格
                    case ' ':
                        i++;
                        break;
                    //遇到左括号，入栈
                    case '(':
                        stack.push('(');
                        i++;
                        break;
                    //遇右括号，出栈直到遇到左括号或栈空（栈空就是括号不匹配）
                    case ')':
                        Character out;
                        while((out = stack.pop()) != null && out != '(') {
                            postfix.append(out).append(" ");
                        }
                        i++;
                        break;
                    //以上都不匹配，执行default
                    default:
                        while(!stack.isEmpty() && !stack.peek().equals('(') && ariCounter.compare(ch, stack.peek()) >= 0) {
                            postfix.append(stack.pop()).append(" ");
                        }
                        stack.push(ch);
                        i++;
                }
            }
        }
        while(!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }
        return postfix.toString();
    }

    public int toValue(String postfix) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        int value = 0;
        char[] ch = postfix.toCharArray();
        for(char c: ch) {
            if(c >= '0' && c <= '9') {
                stack.push(Integer.parseInt(String.valueOf(c)));
            }
            else if(c == ' ') {
                continue;
            }
            else {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(ariCounter.operate(a, b, c));
            }
        }
        return stack.pop();
    }

}
