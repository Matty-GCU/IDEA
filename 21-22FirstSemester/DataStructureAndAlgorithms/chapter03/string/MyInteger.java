package chapter03.string;

/**
 * @author Matty's PC
 */
public final class MyInteger implements Comparable<MyInteger>{

    public final int intValue;

    /**
     * 最小值常量，-2^31=-2147483648
     */
    public static final int MIN_VALUE = 0x80000000;

    /**
     * 最大值常量，2^31=2147483647
     */
    public static final int MAX_VALUE = 0x7fffffff;

    public MyInteger(int value) {
        intValue = value;
    }

    public int intValue() {
        return intValue;
    }

    @Override
    public String toString() {
        return intValue + "";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof MyInteger && intValue == ((MyInteger)obj).intValue();
    }

    @Override
    public int compareTo(MyInteger iObj) {
        return intValue == iObj.intValue() ? 0 : (intValue > iObj.intValue() ? 1 : -1);
    }

    public static int parseInt(String s) {//要抛异常吗？？？？？？？？？？？？？
        return parseInt(s, 10);
    }

    /**
     * 未测试，因为没有测试用例
     * N进制转十进制
     */
    public static int parseInt(String s, int radix) {
        final int MAX_RADIX = 16;
        final int MIN_RADIX = 2;
        if(s == null) {
            throw new NullPointerException();
        }
        //限制进制范围，只需要在2-16进制的范围内处理
        if(radix < MIN_RADIX || radix > MAX_RADIX) {
            throw new NumberFormatException("进制超出范围");
        }
        //最终结果的绝对值（十进制数字）
        int value = 0;
        //正在处理的数字或符号在s中的下标
        int i = 0;
        //最终结果的符号（到时候乘上）
        int sign = s.charAt(0)=='-' ? -1 : 1;
        //下标跳过符号
        if(s.charAt(0) == '-' || s.charAt(0) == '+') {
            i++;
            if(s.length() == 1) {
                throw new NumberFormatException();
            }
        }
        //从左到右，将每一个N进制数字转化为10进制
        while(i < s.length()) {
            char ch = s.charAt(i++);
            //如果ch是数字0-9，那它必须满足'0' <= ch < '0'+radix
            //但是在极端情况下，满足'0' <= ch < '0'+radix的ch也有可能是ASCII码紧跟在'9'后面的几个标点符号之一，该算法的容错性不足以无法处理这种情况
            //如果ch是字母A-F或a-f，那它一定不满足ch < '0'+radix，因为距离'0'最近的'A'(65)的ASCII码比'0'(48)大很多
            if(ch >= '0' && ch < '0'+radix) {
                //因为事先不知道这个字符串有多长（数字有多少位），所以只能在处理到下一个数字时，将它前面所有数字的位数识别为比原来高一位（位数高1位，值自然要翻radix倍）
                value = value * radix + (ch - '0');
            }
            //进入这个else时，ch必然不是数字0-9
            //因此我们只需要处理ch是小写字母或大写字母两种情况
            else {
                if(radix > 10 && ch >= 'a' && ch < 'a'+radix-10) {
                    value = value * radix + (ch - 'a' + 10);
                }
                else if(radix > 10 && ch >= 'A' && ch < 'A'+radix-10) {
                    value = value * radix + (ch - 'a' + 10);
                }
                else {
                    throw new NumberFormatException();
                }
            }

        }

        return value * sign;
    }

}