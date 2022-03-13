package design.pattern.ch06.builder;

public class Actor {
    
    /**
     * 角色类型
     */
    private String type;
    
    /**
     * 性别
     */
    private String sex;
    
    /**
     * 脸型
     */
    private String face;
    
    /**
     * 服装
     */
    private String costume;
    
    /**
     * 发型
     */
    private String hairStyle;
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getFace() {
        return face;
    }
    
    public void setFace(String face) {
        this.face = face;
    }
    
    public String getCostume() {
        return costume;
    }
    
    public void setCostume(String costume) {
        this.costume = costume;
    }
    
    public String getHairStyle() {
        return hairStyle;
    }
    
    public void setHairStyle(String hairStyle) {
        this.hairStyle = hairStyle;
    }
    
    @Override
    public String toString() {
        return "Actor{" +
                "类型='" + type + '\'' +
                ", 性别='" + sex + '\'' +
                ", 脸型='" + face + '\'' +
                ", 服装='" + costume + '\'' +
                ", 发型='" + hairStyle + '\'' +
                '}';
    }
}
