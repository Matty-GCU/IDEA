package chapter03.string;

/**
 * 3.3.2模式匹配应用，例3.3，课本82页
 * java.lang.StringBuffer类没有声明【查找替换子串】和【查找删除子串】操作，本例增加此功能
 * @author Matty's PC
 */
public class StringBufferUtil {
    StringBuffer stringBuffer;

    public StringBufferUtil() {
        stringBuffer = new StringBuffer();
    }

    public StringBufferUtil(String str) {
        stringBuffer = new StringBuffer(str);
    }

    //已测试
    public StringBuffer replaceAll(String pattern, String s) {
        return replaceAll(this.stringBuffer, pattern, s);
    }

    //已测试
    public static StringBuffer replaceAll(StringBuffer target, String pattern, String s) {
        int i = target.indexOf(pattern);
        while(i != -1) {
            target.delete(i, i + pattern.length());
            target.insert(i, s);
            i = target.indexOf(pattern, i + s.length());
        }
        return target;
    }

    //已测试
    public StringBuffer removeAll(String pattern) {
        return removeAll(this.stringBuffer, pattern);
    }

    //已测试
    public static StringBuffer removeAll(StringBuffer target, String pattern) {
        //低效率方法，时间复杂度O(N*N)：return replaceAll(target, pattern, "");
        //而这种方法只需一次遍历，不需回溯
        //算法图解可以看看课本83页
        int targetLen = target.length();
        int patternLen = pattern.length();
        int remove = target.indexOf(pattern);
        int nextRemove = remove;
        while(nextRemove != -1) {
            int move = nextRemove + patternLen;
            nextRemove = target.indexOf(pattern, move);
            while(nextRemove > 0 && move < nextRemove || nextRemove < 0 && move < targetLen) {
                //如果存在nextRemove，就把move~nextRemove-1之间的字符串挪到remove处
                //如果不存在nextRemove，就把move~targetLen-1之间的字符串挪到remove处
                target.setCharAt(remove++, target.charAt(move++));
            }
        }
        if(remove != -1) {
            //如果remove等于-1，说明程序根本没进去上面那个while循环，因为target里压根就没有pattern，啥也不用删
            //如果remove不等于-1，说明target已经经过了挪动，现在是时候把多余的位置删掉了。
            target.setLength(remove);
        }
        return target;
    }

    @Override
    public String toString() {
        return stringBuffer.toString();
    }

}
