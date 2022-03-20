package design.pattern.ch11.composite;

public class VideoFile extends AbstractNormalFile {
    
    public VideoFile(String name) {
        super(name);
    }
    
    @Override
    public void killVirus() {
        System.out.println("---对视频文件\"" + name + "\"进行杀毒！");
    }
}
