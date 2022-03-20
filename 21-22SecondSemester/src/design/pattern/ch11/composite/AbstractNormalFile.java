package design.pattern.ch11.composite;

/**
 * 课本示例没有写这个抽象类
 */
public abstract class AbstractNormalFile extends AbstractFile {
    
    public AbstractNormalFile(String name) {
        super(name);
    }
    
    @Override
    public void addChild(AbstractFile file) {
        System.out.println("不支持该方法！");
    }
    
    @Override
    public void removeChild(AbstractFile file) {
        System.out.println("不支持该方法！");
    }
    
    @Override
    public AbstractFile getChild(int i) {
        System.out.println("不支持该方法！");
        return null;
    }
}
