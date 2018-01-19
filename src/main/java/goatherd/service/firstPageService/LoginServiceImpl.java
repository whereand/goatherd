package goatherd.service.firstPageService;

import org.springframework.stereotype.Service;

/**
 * 登录页面
 * @author 薛宗艳
 *
 */
@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService{

	@Override
	public String login(String account, String password, String verificationCode, String text) {
		Boolean ok  = true;
		String state = "0";//0:验证通过  1:验证码错误  2:账号或密码错误
		//1.判断验证码是否正确
		String str = text.toLowerCase();
		String sts = verificationCode.toLowerCase();
		if(!(str.equals(sts))){
			ok = false;
			state = "1";
		}
		//2.判断账号是否正确
		if(ok){
			
		}
		//3.判断密码是否正确
		if(ok){
			
		}
		return state;
	}
}