package chapter01.io;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

/**
 * @author Matty's PC
 * @date 2021/11/19
 */
public class Code1_14NIOFileChannelDemo {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Matty's PC\\Desktop", "test.txt");
        if(! file.exists()) {
            try {
                file.createNewFile();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileChannel inChannel = new FileInputStream(file).getChannel();
            //课本有错，这里new FileOutPutStream默认append参数为false，会清空文件中的内容。正常使用需加上true参数
            FileChannel outChannel = new FileOutputStream(file, true).getChannel();
            //将FileChannel里的全部数据映射成ByteBuffer
            MappedByteBuffer byteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            //将ByteBuffer中的数据全部输出，然后必须调用clear来恢复limit、position的位置，否则39行转换内容啥也没有。
            outChannel.write(byteBuffer);
            byteBuffer.clear();
            //使用UTF-8字符集来创建解码器，并使用解码器将ByteBuffer转换为CharBuffer
            Charset charset = StandardCharsets.UTF_8;
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = decoder.decode(byteBuffer);
            System.out.println(charBuffer.toString());
        } catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.delete());
    }
}
