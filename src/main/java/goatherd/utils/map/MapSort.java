package goatherd.utils.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
/**
 * 
 * @author 薛宗艳
 * @date 2018年1月31日
 */
public class MapSort {
	/**
	 * 将map按key(英文)进行升序排序,并将排序后的map拼成  "keyvaluekeyvalue" 形式的字符串
	 * @param map
	 * @return "keyvaluekeyvalue"形式的字符串
	 */
    public static String ascSortByKey(Map<String , Object> map){
    	if(map == null || map.isEmpty()){
    		return null;
    	}
    	Map<String,Object> maps = new TreeMap<String,Object>(new MapKeyComparator());
    	maps.putAll(map);
    	StringBuilder builder = new StringBuilder();
    	for(Entry<String,Object> put : maps.entrySet()){
    		builder.append(put.getKey()).append(put.getValue());
    	}
    	return builder.toString();
    }
}
class MapKeyComparator implements Comparator<String>{
    @Override
    public int compare(String str1, String str2) {       
        return str1.compareTo(str2);
    }
}