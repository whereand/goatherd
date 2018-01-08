package goatherd.dao;

import java.math.BigInteger;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author 薛宗艳
 *
 */
public interface UserDao {
    
	String selectById(@Param("id")BigInteger id);
}
