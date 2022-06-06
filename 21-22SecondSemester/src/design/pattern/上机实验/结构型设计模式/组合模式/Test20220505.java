package design.pattern.上机实验.结构型设计模式.组合模式;

public class Test20220505 {
    public static void main(String[] args) {
        School beijingSchool = new School("北京总校");
        beijingSchool.addOffice(new EduOffice("北京总校"));
        beijingSchool.addOffice(new AdminOffice("北京总校"));
        
        School hunanSchool = new School("湖南分校");
        hunanSchool.addOffice(new EduOffice("湖南分校"));
        hunanSchool.addOffice(new AdminOffice("湖南分校"));
        beijingSchool.addOffice(hunanSchool);
        
        School changshaSchool = new School("长沙教学点");
        changshaSchool.addOffice(new EduOffice("长沙教学点"));
        changshaSchool.addOffice(new AdminOffice("长沙教学点"));
        hunanSchool.addOffice(changshaSchool);
        
        School xiangtanSchool = new School("湘潭教学点");
        xiangtanSchool.addOffice(new EduOffice("湘潭教学点"));
        xiangtanSchool.addOffice(new AdminOffice("湘潭教学点"));
        hunanSchool.addOffice(xiangtanSchool);
        
        
        beijingSchool.sendDocument();
    }
}
