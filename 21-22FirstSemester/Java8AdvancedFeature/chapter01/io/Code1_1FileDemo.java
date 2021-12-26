package chapter01.io;

import java.io.File;
import java.io.IOException;

public class Code1_1FileDemo {
    public static void main(String[] args) {
        File file = new File(".");
        System.out.println(file.exists());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsoluteFile().getParent());
        File newFile = new File("C:\\Users\\Matty's PC\\Desktop\\Test.txt");
        System.out.println(newFile.exists());
        try {
            System.out.println("创建文件：" + newFile.createNewFile());;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("创建目录:" + newFile.mkdir());
        System.out.println("====当前路径下所有文件和路径如下====");
        String[] fileList = file.list();
        for(String fileName: fileList) {
            System.out.println(fileName);
        }
        System.out.println("====系统所有根目录如下：====");
        //注意此处是静态方法
        File[] roots = File.listRoots();
        for(File fileSystemRoot: roots) {
            System.out.println(fileSystemRoot);
        }
        if(newFile.delete()) {
            System.out.println("文件删除成功");
        }
    }
}
