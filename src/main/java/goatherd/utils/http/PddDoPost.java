package goatherd.utils.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
/**
 * 
 * @author 薛宗艳
 *
 */
public class PddDoPost {
	/*
     * post请求:
     * 1.状态行:
     * 2.请求头(header):
     *   Content-Type:规定请求中的消息主体是用何种方式编码(指定请求主体的类型)
     *     (1):"application/x-javascript text/xml;charset=utf-8"  ==>表示xml数据
     *     (2):"application/x-javascript;charset=utf-8"           ==>表示json对象
     *     (3):"application/x-www-form-urlencoded;charset=utf-8"  ==>表单数据;数据被编码成以'&'分隔的键-值对,同时以'='分隔键和值;非字母或数字的字符会被 percent encoded.
     *     (4):"application/json;charset=utf-8"                   ==>json数据
     * 3.消息主体(entity-body):
     *   提交的数据必须放在这里,但是并没有规定数据的编码方式
     */
	/**
	 * post请求,表单提交方式
	 * @param url
	 * @param params
	 * @param charset
	 * @return
	 */
	public static String doPost(String url,Map<String,Object> params,String charset){
		StringBuffer buffer = new StringBuffer();
		try {
			URL uri = new URL(url);//创建连接
			URLConnection urlconnection = uri.openConnection();//注入了URL;有setDoOutput(),setDoInput()
			HttpURLConnection conn = (HttpURLConnection)urlconnection;//HttpURLConnection extends URLConnection
			conn.setConnectTimeout(500);//设置连接主机超时(超时报异常)
			conn.setReadTimeout(500);//设置从主机读取数据超时(超时报异常)
			conn.setDoOutput(true);//发送数据,默认值为false.
			conn.setDoInput(true);//读取数据;默认值为true
			conn.setRequestMethod("POST");//设置请求方式,大写
			conn.setUseCaches(false);//使用缓存,默认值true
			conn.setRequestProperty("Connection", "close");//Keep-Alive:持久连接或连接重用;close:关闭持久连接
			//conn.setRequestProperty("Accept", "");//设置接收的文件类型
			//conn.setRequestProperty("Content-Length", "字节数据的长度(jsonParam.toString()).getBytes().length");//设置文件的长度
			conn.setRequestProperty("Accept-Charset", charset);//设置接收的字符编码
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");//设置请求头
			conn.connect();//开始连接请求
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(),charset);
			out.write("");//写入请求的字符串
			out.flush();//将流中的缓冲数据输出(清空流)
			out.close();//关闭流
			int code = conn.getResponseCode();//获得响应吗
			System.out.println("code:"+code);			
			if("200".equals(String.valueOf(code))){		
				InputStream is = conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader reader = new BufferedReader(isr);		
				String line = null;
				while((line = reader.readLine()) != null){
					buffer.append(line);
				}
				Map<String, List<String>> s = conn.getHeaderFields();
				for(Entry<String,List<String>> map : s.entrySet()){
					System.out.println(map.getKey()+":"+map.getValue());
				}
				reader.close();//关闭流
				conn.disconnect();//关闭连接
			}else{
				return String.valueOf(code);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}
}