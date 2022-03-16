package design.pattern.ch10.bridge.example2;

public class LinuxOS implements OS {
    @Override
    public void paint(PixelMatrix pixelMatrix) {
        System.out.print("使用Linux操作系统打开图片：" + pixelMatrix);
    }
}
