package goatherd.utils.map;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;
/**
 * 
 * @author 薛宗艳
 * @date 2018年1月31日
 */
public class MapConvertParam {
	/**
	 * 将map转换为请求参数,不加编码方式(eg:数学=98&语文=99)
	 * @param map
	 * @return
	 */
    public static String convert(Map<String,Object> map){
    	StringBuffer data = new StringBuffer();
    	Boolean flag = false;
    	for(Entry<String, Object> maps : map.entrySet()){
    		if(flag){
    			data.append("&");
    		}else{
    			flag = true;
    		}
    		data.append(maps.getKey()).append("=").append(maps.getValue());
    	}   	
    	return data.toString();
    }
    /**
     * 将map转换为请求参数,加编码方式(eg:%E6%95%B0%E5%AD%A6%3D98&%E8%AF%AD%E6%96%87%3D99)
     * @param map
     * @param charset
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String converts(Map<String,Object> map,String charset) throws UnsupportedEncodingException{
    	StringBuffer data = new StringBuffer();
    	Boolean flag = false;
    	for(Entry<String,Object> maps : map.entrySet()){
    		if(flag){
    			data.append("&");
    		}else{
    			flag = true;
    		}
    		data.append(URLEncoder.encode(maps.getKey(),charset)).append(URLEncoder.encode("=", charset)).append(URLEncoder.encode(maps.getValue().toString(), charset));
    	}
    	return data.toString();
    }
}