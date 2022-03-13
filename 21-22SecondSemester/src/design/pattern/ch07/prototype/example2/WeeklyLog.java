package design.pattern.ch07.prototype.example2;

import java.io.*;

public class WeeklyLog implements Serializable {
    private Attachment attachment;
    private String name;
    private String date;
    private String content;
    
    public WeeklyLog deepClone() {
        WeeklyLog clone = null;
        try {
            //将对象写入流中
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            ObjectOutputStream objectOut = new ObjectOutputStream(byteArrayOut);
            objectOut.writeObject(this);
            //将对象从流中取出
            ByteArrayInputStream byteArrayIn = new ByteArrayInputStream(byteArrayOut.toByteArray());
            ObjectInputStream objectIn = new ObjectInputStream(byteArrayIn);
            clone = (WeeklyLog) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clone;
    }
    
    public Attachment getAttachment() {
        return attachment;
    }
    
    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
}
