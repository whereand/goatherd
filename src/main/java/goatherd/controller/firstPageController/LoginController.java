package goatherd.controller.firstPageController;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import goatherd.service.firstPageService.LoginService;
import goatherd.utils.VerificationCode;

@Controller("loginController")
@RequestMapping("/login")
public class LoginController {
	
	@Resource
	LoginService service;
	
	/**
	 * 验证码
	 * @param response
	 * @param session
	 */
	@RequestMapping("createImg.do")
	public void verificationCode(HttpServletResponse response,HttpSession session){
		VerificationCode code = new VerificationCode();
		BufferedImage image = code.creageImage();
		String text = code.getText();
		//将验证码存入session
		session.setAttribute("image", image);
		//将验证码的字符串存入session
		session.setAttribute("verificationCode", text);
		//将图片输出给浏览器
		response.setContentType("image/jpeg");
		OutputStream out = null;
		try {
			//获取输出流
		    out = response.getOutputStream();
		    ImageIO.write(image, "jpeg", out);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(out != null){
					out.close();
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 登录按钮
	 * @param account
	 * @param password
	 * @param verificationCode
	 * @param session
	 * @return
	 */
	@RequestMapping("/loginButton.do")
	@ResponseBody
	public String login(String account,String password,String verificationCode,HttpSession session){
		String text = (String) session.getAttribute("verificationCode");
		String state = service.login(account, password, verificationCode, text);		
		if("0".equals(state)){
			//验证通过,进入到主页面
			return "";
		}else{
			System.out.println("state:"+state);
			//验证不通过,将验证信息返回
			return state;
		}
	}
}