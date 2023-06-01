package controller;

import model.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class AdminController {
	
	@RequestMapping("/register.do")
	  public String register(String username,String password,String role) throws ClassNotFoundException, SQLException{
		Admin admin=new Admin();
		 admin.register(username,password,role); //调用模型方法
		return "adminLogin.jsp"; //跳转到登录页面，重新登录
	}
	
	@RequestMapping("/login.do")
	  public String login(String username,String password,String role,HttpSession session,Model model) throws ClassNotFoundException, SQLException{
		Admin admin=new Admin();
		//写一个99乘法表
		System.out.print(username+"密码AAAAAAAAAAAAAAAAAAAAAAAA");
		  if(admin.login(username,password,role)){
			  admin.setUsername(username);
			  admin.setPassword(password);
			  admin.setRole(role);
			  session.setAttribute("admin", admin); //将当前登录成功的用户放session
			  return "sys_menu.jsp";
		  }else{
			  model.addAttribute("message","用户名或密码错误!"); //返回视图的错误信息
			  return "adminLogin.jsp";
		  }

	}
	@RequestMapping("/logout.do")
	  public String logout(HttpSession session) throws ClassNotFoundException, SQLException{
		  session.invalidate(); //session失效
		//
		  return "adminLogin.jsp";

	}

}
