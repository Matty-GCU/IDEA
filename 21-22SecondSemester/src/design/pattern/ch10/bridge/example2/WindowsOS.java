package design.pattern.ch10.bridge.example2;

public class WindowsOS implements OS {
    @Override
    public void paint(PixelMatrix pixelMatrix) {
        System.out.print("使用Win10操作系统打开图片：" + pixelMatrix);
    }
}
