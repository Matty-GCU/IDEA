package design.pattern.ch11.composite;

public class ImageFile extends AbstractNormalFile {
    
    public ImageFile(String name) {
        super(name);
    }
    
    @Override
    public void killVirus() {
        System.out.println("---对图像文件\"" + name + "\"进行杀毒！");
    }
}
