package chapter03.string;

import java.io.Serializable;

/**
 * @author Matty's PC
 */
public final class MyString implements Comparable<MyString>, Serializable {

    private final char[] value;

    public MyString() {
        value = new char[0];
    }

    public MyString(String s) {
        value = new char[s.length()];
        for(int i = 0; i < s.length(); i++) {
            value[i] = s.charAt(i);
        }
    }

    /**
     * 以value数组从i开始的n个字符构造串(长度为n)
     */
    public MyString(char[] value, int i, int n) {
        if(i >=0 && n >=0 && i+n<=value.length) {
            this.value = new char[n];
//            System.arraycopy(value, i, this.value, 0, n);
            for(int j = 0; j < n; j++) {
                //因为是基本数据类型，所以是深拷贝
                this.value[j] = value[i + j];
            }
        }
        else {
            throw new StringIndexOutOfBoundsException();
        }
    }

    public MyString(char[] value) {
        this(value, 0, value.length);
    }

    public MyString(MyString s) {
        this(s.value);
    }

    public char charAt(int i) {
        if(i >= 0 && i < value.length) {
            return value[i];
        }
        throw new StringIndexOutOfBoundsException(i);
    }

    @Override
    public String toString() {
        return new String(value);
    }


    /**
     * 自己写的
     * @return 比s大，返回正数；比s小，返回负数；和s一样，返回0
     */
    @Override
    public int compareTo(MyString s) {
        if(this.value.length == s.value.length) {
            for(int i = 0; i < this.value.length; i++) {
                if(this.value[i] != s.value[i]) {
                    return (this.value[i] - s.value[i] > 0) ? 1 : -1;
                }
            }
            return 0;
        }
        return (this.value.length - s.value.length > 0) ? 1 : -1;
    }

    /**
     * 思考3-1
     * 忽略大小写进行比较
     */
    public int compareToIgnoreCase(MyString s) {
        if(this.value.length == s.value.length) {
            for(int i = 0; i < this.value.length; i++) {
                int sub = this.value[i] - s.value[i];
                if(this.value[i] != s.value[i] && sub != 32 && sub != -32) {
                    return (this.value[i] - s.value[i] > 0) ? 1 : -1;
                }
            }
            return 0;
        }
        return (this.value.length - s.value.length > 0) ? 1 : -1;
    }

    /**
     * @return 从start到end-1的子串
     */
    public MyString subString(int start, int end) {
        return new MyString(this.value, start, end);
    }

    /**
     * 自己写的
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof MyString && this.compareTo((MyString)obj) == 0;
    }

    /**
     * @return 返回this与s串连接生成的串
     */
    public MyString contact(MyString s) {
        MyString emptyString = new MyString("");
        if(s == null || emptyString.equals(s)) {
            return new MyString(this);
        }
        char[] buffer = new char[this.value.length + s.value.length];
        int i;
        for(i = 0; i < this.value.length; i++) {
            buffer[i] = this.value[i];
        }
        for(int j = 0; j < s.value.length; j++) {
            buffer[i + j] = s.value[j];
        }
        return new MyString(buffer);
    }

    /**
     * 思考3-1
     * 自己写的
     */
    public MyString trim() {
        char[] buffer = new char[value.length];
        int j = 0;
        for(int i = 0; i < value.length; i++) {
            if(charAt(i) != ' ') {
                buffer[j] = charAt(i);
                j++;
            }
        }
        return new MyString(buffer, 0, j);
    }

}
