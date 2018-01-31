package goatherd.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author 薛宗艳
 * @date 2018年1月31日
 */
public class MD5 {
	public static String md5(String str){
    	if (null == str || "".equals(str)) {
            return str;
        }
    	MessageDigest msgDigest = null;
        try {
            msgDigest = MessageDigest.getInstance("MD5");
        }catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("System doesn't support MD5 algorithm.");
        }
        msgDigest.update(str.getBytes());
        byte[] bytes = msgDigest.digest();
        String md5Str = new String();
        byte tb;
        char low;
        char high;
        char tmpChar;
        for (int i = 0; i < bytes.length; i++) {
            tb = bytes[i];
            tmpChar = (char) ((tb >>> 4) & 0x000f);
            if (tmpChar >= 10) {
                high = (char) (('a' + tmpChar) - 10);
            }else {
                high = (char) ('0' + tmpChar);
            }
            md5Str += high;
            tmpChar = (char) (tb & 0x000f);
            if (tmpChar >= 10) {
                low = (char) (('a' + tmpChar) - 10);
            }else {
                low = (char) ('0' + tmpChar);
            }
            md5Str += low;
        }
    	return md5Str;
    }
}