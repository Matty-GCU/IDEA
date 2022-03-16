package design.pattern.ch10.bridge.example2;

public class PNGImage extends Image {
    @Override
    public void display(String fileName) {
        //模拟解析JPG文件得到一个像素矩阵对象
        PixelMatrix pixelMatrix = new PixelMatrix();
        os.paint(pixelMatrix);
        System.out.println("\t" + fileName + "，格式为PNG");
    }
}
