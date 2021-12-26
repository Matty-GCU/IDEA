package chapter01.io;

import java.nio.CharBuffer;

/**
 * @author Matty's PC
 * @date 2021/11/19
 */
public class Code1_13NIOBufferDemo {

    static CharBuffer charBuffer;

    public static void main(String[] args) {
        charBuffer = CharBuffer.allocate(8);
        getInfo();
        charBuffer.put('a');
        charBuffer.put('b');
        charBuffer.put('c');
        getInfo();
        charBuffer.flip();
        getInfo();
        System.out.println(charBuffer.get());
        System.out.println(charBuffer.get());
        getInfo();
        charBuffer.clear();
        System.out.println(charBuffer.get());
        System.out.println(charBuffer.get(2));
        getInfo();
    }

    public static void getInfo() {
        System.out.println("capacity(): " + charBuffer.capacity());
        System.out.println("position(): " + charBuffer.position());
        System.out.println("limit(): " + charBuffer.limit());
        System.out.println();

    }
}
