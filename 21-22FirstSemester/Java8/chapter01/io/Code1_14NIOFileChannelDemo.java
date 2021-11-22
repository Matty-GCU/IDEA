package chapter01.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;

/**
 * @author Matty's PC
 * @date 2021/11/19
 */
public class Code1_14NIOFileChannelDemo {
    public static void main(String[] args) {
        File file = new File("C://User//Matty's PC//Desktop//test.txt");
        if(! file.exists()) {
            try {
                file.createNewFile();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileChannel fileChannel = new FileInputStream(file).getChannel();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        

        file.delete();
    }
}
