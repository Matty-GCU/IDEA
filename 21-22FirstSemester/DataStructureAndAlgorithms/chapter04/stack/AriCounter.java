package chapter04.stack;

import reflection.A;

import java.util.Comparator;
import java.util.HashMap;

/**
 * 算术运算符类
 * @author Matty's PC
 */
public class AriCounter implements Comparator<Character> {

    private char[] operators = {'*', '/', '%', '+', '-'};
    private int[] priority = {3, 3, 3, 4, 4};

    /**
     * 注意是优先值小的运算符优先级高
     */
    private HashMap<Character, Integer> hashMap;

    public AriCounter() {
        hashMap = new HashMap<>();
        for(int i = 0; i < operators.length; i++) {
            hashMap.put(operators[i], priority[i]);
        }
    }

    /**
     * 比较算术运算符的优先值
     * @return 若返回值大于0，则o2优先级高；若返回值小于0，则o1优先级高；若返回0，则o1和o2优先级相等。
     */
    @Override
    public int compare(Character o1, Character o2) {
        int p1 = 0;
        int p2 = 0;
        try {
            p1 = hashMap.get(o1);
            p2 = hashMap.get(o2);
        }
        catch(NullPointerException e) {
            throw new IllegalArgumentException();
        }
        return p1 - p2;
    }

    /**
     * 选择运算符，对两个数字进行计算
     * @return 计算结果
     */
    public int operate(int x, int y, char operator) {
        switch(operator) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            case '%':
                return x % y;
            default:
                throw new IllegalArgumentException();
        }
    }

}
