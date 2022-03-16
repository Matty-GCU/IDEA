package design.pattern.ch10.bridge.example2;

public abstract class Image {
    protected OS os;
    
    public void setOs(OS os) {
        this.os = os;
    }
    
    public abstract void display(String fileName);
}
