package design.pattern.ch10.bridge.example2;

import design.pattern.XMLUtil2;

public class BridgePatternTest {
    public static void main(String[] args) {
//        Image image = new JPGImage();
        Image image = (Image) XMLUtil2.getBean("imageFormat");
        
//        OS windows = new WindowsOS();
        OS windows = (OS) XMLUtil2.getBean("os");
        image.setOs(windows);
        image.display("1.jpg");
    }
}
