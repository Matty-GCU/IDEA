package design.pattern.ch11.composite;

public class TextFile extends AbstractNormalFile {
    
    public TextFile(String name) {
        super(name);
    }
    
    @Override
    public void killVirus() {
        System.out.println("---对文本文件\"" + name + "\"进行杀毒！");
    }
}
