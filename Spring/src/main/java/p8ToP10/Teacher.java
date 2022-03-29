package p8ToP10;

public class Teacher {
    String teacherName;
    long teacherId;
    
    public String getTeacherName() {
        return teacherName;
    }
    
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    
    public long getTeacherId() {
        return teacherId;
    }
    
    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }
    
    @Override
    public String toString() {
        return "Teacher{" +
                "teacherName='" + teacherName + '\'' +
                ", teacherId=" + teacherId +
                '}';
    }
}
