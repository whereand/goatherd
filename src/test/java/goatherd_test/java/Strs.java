package goatherd_test.java;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Strs {
    @Before
    public void init(){
    	String[] conf = {"config/spring-mvc.xml","config/spring-mybatis.xml"};
    	ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
    }
    /**
     * 判断验证码是否相等
     */
    @Test
    public void test01(){
    	String s1 = "12Bc";
    	String s2 = "12bC";
    	System.out.println(s1.toLowerCase());
    	System.out.println(s2.toLowerCase());
    	if((s1.toLowerCase()).equals(s2.toLowerCase())){
    		System.out.println("相等的");
    	}
    }
}
