package goatherd_test.java;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import goatherd.utils.map.MapConvertParam;


public class Test01 {
    @Test
    public void test() throws UnsupportedEncodingException{
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("语文", 99);
    	map.put("数学", 98);
    	map.put("英语", 97);
    	map.put("化学", 96);
    	map.put("地理", 95);
    	String str = MapConvertParam.convert(map);
    	String encode = MapConvertParam.converts(map, "utf-8");
    	System.out.println("str:"+str);
    	System.out.println("encode:"+encode);
    }
}
