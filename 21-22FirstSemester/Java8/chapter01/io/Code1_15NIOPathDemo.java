package chapter01.io;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Matty's PC
 * @date 2021/11/23
 */
public class Code1_15NIOPathDemo {
    public static void main(String[] args) {
        Path path = Paths.get("一个不存在的文件名。也可以用.代替");
        System.out.println("path的绝对路径：" + path);
        System.out.println("path里包含的路径数量：" + path.getNameCount());
        System.out.println("path的根路径：" + path.getRoot());
        Path absolutePath = path.toAbsolutePath();
        System.out.println("absolutePath的绝对路径：" + absolutePath);
        System.out.println("absolutePath里包含的路径数量：" + absolutePath.getNameCount());
        System.out.println("absolutePath的根路径：" + absolutePath.getRoot());

        Path path2 = Paths.get("以多个String", "来创建", "Path对象");
        System.out.println(path2);
    }
}
