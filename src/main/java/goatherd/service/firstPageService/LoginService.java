package goatherd.service.firstPageService;

/**
 * 登录页面
 * @author 薛宗艳
 *
 */
public interface LoginService {
	/**
	 * 
	 * @param account:账号
	 * @param password:密码
	 * @param varificationCode:用户输入的验证码
	 * @param text:系统生成的验证码
	 * @return  0:验证通过  1:验证码错误  2:账号或密码错误
	 */
    String login(String account,String password,String varificationCode,String text);
}
