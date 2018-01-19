package utils;
/**
 * 生成验证码
 * @author 薛宗艳
 *
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerificationCode {
	
    //图片高度
	private static final int IMG_WIGHT = 100;
	//图片宽度
	private static final int IMG_HEIGHT = 32;
	//验证码长度
	private static final int CODE_LENGTH = 4;
	//
	private Random random = new Random();
	//定义有那些字体
	private String[] fontNames = {"宋体","黑体","微软雅黑"};
	//定义有那些随机字符
	private String codes = "0123456789abcdABCD";
	//生成背景色
	private Color bgColor = new Color(250,250,250);
	//用于gettext方法,获得生成的验证码
	private String text;
	
	//生成随机颜色
	private Color randomColor(){
		int red = random.nextInt(150);
		int bluee = random.nextInt(150);
		int green = random.nextInt(150);
		return new Color(red,bluee,green);
	}
	
	//生成随机字体
	private Font randomFont(){
		int index = random.nextInt(fontNames.length);
		String fontName = fontNames[index];
		int style = random.nextInt(4);
		int size = random.nextInt(5)+24;
		return new Font(fontName,style,size);//根据指定名称、样式和磅值大小，创建一个新 Font		
	}
	
	//画干扰线
	private void drawLine(BufferedImage image){
		int num = 3;
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		for(int i=0;i<num;i++){
			int x1 = random.nextInt(IMG_HEIGHT);
			int y1 = random.nextInt(IMG_WIGHT);
			int x2 = random.nextInt(IMG_HEIGHT);
			int y2 = random.nextInt(IMG_WIGHT);
			/**
			 * g2.setStroke(Stroke s);
			 * 为 Graphics2D 上下文设置 Stroke
			 * Stroke 接口允许 Graphics2D 对象获得一个 Shape，该 Shape 是指定 Shape 的装饰轮廓，或该轮廓的风格表示形式 
			 * 
			 * BasicStroke(float f)
			 * 构造一个具有指定线条宽度以及 cap 和 join 风格的默认值的实心 BasicStroke。
			 */
			g2.setStroke(new BasicStroke(1.5F));
			g2.setColor(Color.blue);
			//在此图形上下文的坐标系中，使用当前颜色在点 (x1, y1) 和 (x2, y2) 之间画一条线
			g2.drawLine(x1, y1, x2, y2);
			
		}
	}
	
	//得到codes长度内的随机数,并使用charAt区的随机数位置上的codes中的字符 
	private char randomChar(){
		int index = random.nextInt(codes.length());
		return codes.charAt(index);
	}
	
	//创建一张验证码的图片
	public BufferedImage creageImage(){
		/**
		 * BufferedImage(int width, int height, int imageType):
		 * 构造一个类型为预定义图像类型之一的 BufferedImage。
		 * TYPE_INT_RGB:
		 * 表示一个图像，它具有合成整数像素的 8 位 RGB 颜色分量。
		 */
		BufferedImage img = new BufferedImage(IMG_WIGHT,IMG_HEIGHT,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D) img.getGraphics();
		StringBuilder sb = new StringBuilder();
		//向图中画四个字符
		for(int i=0;i<4;i++){
			String s = randomChar()+"";
			sb.append(s);
			float x = i*1.0F*IMG_WIGHT/4;
			g2.setFont(randomFont());//字体
			g2.setColor(randomColor());//颜色
			g2.drawString(s, x, IMG_HEIGHT-5);
		}
		this.text=sb.toString();
		drawLine(img);//画干扰线
		return img;
	}
	
	//得到验证码的文本 后面是用来和用户输入的验证码检测用
	public String getText(){
		return text;
	}
	
	//定义输出的对象和输出的方向
//	public static void output(BufferedImage img,OutputStream out) throws IOException{
//		ImageIO.write(img, "JPEG", out);
//	}
}
