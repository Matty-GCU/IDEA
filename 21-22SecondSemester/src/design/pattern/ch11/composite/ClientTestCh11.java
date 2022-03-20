package design.pattern.ch11.composite;

public class ClientTestCh11 {
    public static void main(String[] args) {
        AbstractFile file1, file2, file3, file4, file5, file6, file7, file8, file9, file10;
        file1 = new Folder("我的文件夹");
        file2 = new Folder("资料");
        file1.addChild(file2);
        file3 = new TextFile("今日作业.txt");
        file4 = new TextFile("SQL语句.txt");
        file2.addChild(file3);
        file2.addChild(file4);
        file5 = new Folder("图片");
        file1.addChild(file5);
        file6 = new ImageFile("搞笑.jpg");
        file7 = new ImageFile("壁纸.jpg");
        file5.addChild(file6);
        file5.addChild(file7);
        file8 = new Folder("视频");
        file1.addChild(file8);
        file9 = new VideoFile("电影.mp4");
        file10 = new VideoFile("电视剧.avi");
        file8.addChild(file9);
        file8.addChild(file10);
        
        file1.killVirus();
    }
}
