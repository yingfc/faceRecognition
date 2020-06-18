package draw;

import com.baidu.ai.aip.utils.GsonUtils;
import com.bejson.pojo.Face_list;
import com.bejson.pojo.JsonRootBean;
import test.FaceDetect;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

public class drawFace {
    public static void main(String[] args) throws IOException {
        String url = "/Users/yingfc/Desktop/证件信息/IMG_3185.JPG";
        String url2 = "/Users/yingfc/Desktop/new.jpg";
        // 调用百度API获取参数
        String resultjson = FaceDetect.faceDetect(url);
        System.out.println(resultjson);
        JsonRootBean rootBean = GsonUtils.fromJson(resultjson, JsonRootBean.class);
        List<Face_list> list = rootBean.result.face_list;

        int top = (int)list.get(0).getLocation().getTop();
        int left = (int)list.get(0).getLocation().getLeft();
        int width = list.get(0).getLocation().getWidth();
        int height = list.get(0).getLocation().getHeight();

        System.out.println("人脸位置: Top: " + top);
        System.out.println("人脸位置: Left: " + left);
        System.out.println("人脸位置: Width: " + width);
        System.out.println("人脸位置: Height: " + height);

        // 将数据通过绘制图形框的方式，画在图片的人脸上
        InputStream in = new FileInputStream(url);//图片路径
        BufferedImage image = ImageIO.read(new File(url));
        Graphics g = image.getGraphics();
        g.setColor(Color.BLACK);
        g.setFont(new Font("隶书", Font.BOLD, 25));
        g.drawString("年龄: " + list.get(0).getAge(),left,top);
        g.drawString("颜值: " + list.get(0).getBeauty(),left,top + height + 25);

        g.setColor(Color.GREEN);//画笔颜色
        g.drawRect(left, top, width, height);//矩形框(原点x坐标，原点y坐标，矩形的长，矩形的宽)
        FileOutputStream out = new FileOutputStream(url2);//输出图片的地址
        ImageIO.write(image, "jpeg", out);

        // 创建窗口并显示标注好的人脸照片
        JFrame f = new JFrame("FaceDetect");
        f.setSize(image.getWidth(),image.getHeight());
        f.setLocation(0,0);
        f.setLayout(null);
        JLabel label = new JLabel();
        ImageIcon i = new ImageIcon(url2);
        label.setIcon(i);
        label.setBounds(0,0,i.getIconWidth(),i.getIconHeight());
        f.add(label);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        System.out.println("绘制成功！");
    }
}
