package design.pattern.ch07.prototype.example2;

public class Test {
    public static void main(String[] args) {
        WeeklyLog oldLog = new WeeklyLog();
        Attachment oldAttachment = new Attachment();
        oldLog.setAttachment(oldAttachment);
        
        WeeklyLog newLog = oldLog.deepClone();
        
        System.out.println(newLog == oldLog);
        System.out.println(newLog.getAttachment() == oldLog.getAttachment());
    }
}
