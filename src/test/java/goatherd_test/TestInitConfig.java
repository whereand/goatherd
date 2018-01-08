package goatherd_test;

import java.math.BigInteger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import goatherd.dao.UserDao;

public class TestInitConfig {
	
	private UserDao dao;
	
	@Before
    public void befores(){
    	String[] conf = {"config/spring-mvc.xml","config/spring-mybatis.xml"};  	
    	ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
    	dao = ac.getBean("userDao",UserDao.class);
    	System.out.println("==============开始=================");
    }
	@After
	public void afters(){
		System.out.println("==============结束=================");
	}
	@Test
	public void test01(){
		System.out.println("测试SSM");
	}
	@Test
    public void test02(){   	
    	String name = dao.selectById(BigInteger.valueOf(1L));
    	System.out.println("name:"+name);
    }
}
