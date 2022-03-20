package design.pattern.ch11.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends AbstractFile {
    
    private List<AbstractFile> fileList = new ArrayList<>();
    
    public Folder(String name) {
        super(name);
    }
    
    @Override
    public void addChild(AbstractFile file) {
        fileList.add(file);
    }
    
    @Override
    public void removeChild(AbstractFile file) {
        fileList.remove(file);
    }
    
    @Override
    public AbstractFile getChild(int i) {
        return fileList.get(i);
    }
    
    @Override
    public void killVirus() {
        System.out.println("对文件夹\"" + name + "\"进行杀毒！");
        for (AbstractFile file : fileList) {
            file.killVirus();
        }
    }
}
