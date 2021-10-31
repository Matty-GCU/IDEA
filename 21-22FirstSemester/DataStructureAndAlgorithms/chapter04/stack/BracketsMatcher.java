package chapter04.stack;

/**
 * 栈的应用：设计算法判断一个算术表达式的圆括号是否正确配对。
 * 例如：
 * 第一个式子：  1*(2+3*(4*(2-1)*(3+x)+5)-6)  能够正确匹配
 * 第二个式子：  1*(2+3*4*(2-1)*(3+x)+5)-6)   不能够正确匹配
 * 分别采取顺序栈和链栈实现，在第一题的基础上调用函数直接完成。
 * 提示：碰到“（” 进行入栈操作，碰到“）”进行出栈操作，有以下情况：
 * 一、 需要进行出栈时，栈空，说明有多余的“）”，不匹配
 * 二、 表达式扫描完成，栈非空，说明有多余的“（”，不匹配
 * 三、 表达式扫描完成，栈空，匹配
 */
public class BracketsMatcher {
    /**
     * O(1)
     */
    public static String check(String target, String left, String right) {
        SequentialStack<Character> stack = new SequentialStack<>();
        char[] ch = target.toCharArray();
        for(char c: ch) {
            if(c == '(') {
                stack.push('(');
            }
            else if(c == ')') {
                if(stack.pop() == null) {
                    return "有多余的“）”，不匹配";
                }
            }
        }
        return stack.size() == 0 ? "圆括号已正确配对" : "有多余的“（”，不匹配";
    }
}
