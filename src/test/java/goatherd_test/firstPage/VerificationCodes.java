package goatherd_test.firstPage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import utils.VerificationCode;

public class VerificationCodes {
	@Before
    public void befores(){
    	String[] conf = {"config/spring-mvc.xml","config/spring-mybatis.xml"};  	
    	ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
    	System.out.println("==============开始=================");
    }
	
	@Test
	public void test01() throws IOException{
		VerificationCode code = new VerificationCode();
		//BufferedImage image = code.creageImage();
		BufferedImage image = code.creageImage();
		ImageIO.write(image, "jpeg", new File("F:/image.jpg"));
	}
}
