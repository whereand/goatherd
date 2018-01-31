package goatherd_test.java;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class TestPost {
	@Test
    public void test01(){
    	try {
    		String urls = "http://gw-api.pinduoduo.com/api/router";
			URL url = new URL(urls);//通过解析给定的字符串构造一个 URI.
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
}
