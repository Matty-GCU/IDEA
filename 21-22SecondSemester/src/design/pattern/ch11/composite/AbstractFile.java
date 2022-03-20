package design.pattern.ch11.composite;

public abstract class AbstractFile {
    
    /**
     * 课本示例的变量是在各个子类里声明的，我觉得应该直接提取到抽象类里面来。
     */
    protected String name;
    
    public AbstractFile(String name) {
        this.name = name;
    }
    public abstract void addChild(AbstractFile file);
    public abstract void removeChild(AbstractFile file);
    public abstract AbstractFile getChild(int i);
    public abstract void killVirus();
}
