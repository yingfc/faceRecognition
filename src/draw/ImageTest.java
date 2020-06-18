package draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageTest {

    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream("d:\\test.jpg");//图片路径
        BufferedImage image = ImageIO.read(new File("d:\\test.jpg"));
        Graphics g = image.getGraphics();
        g.setColor(Color.RED);//画笔颜色
        g.drawRect(100, 100, 100, 100);//矩形框(原点x坐标，原点y坐标，矩形的长，矩形的宽)
        //g.dispose();
        FileOutputStream out = new FileOutputStream("d:\\test2.jpg");//输出图片的地址
        ImageIO.write(image, "jpeg", out);
    }
}