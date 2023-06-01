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
		 admin.register(username,password,role); //����ģ�ͷ���
		return "adminLogin.jsp"; //��ת����¼ҳ�棬���µ�¼
	}
	
	@RequestMapping("/login.do")
	  public String login(String username,String password,String role,HttpSession session,Model model) throws ClassNotFoundException, SQLException{
		Admin admin=new Admin();
		//дһ��99�˷���
		System.out.print(username+"����AAAAAAAAAAAAAAAAAAAAAAAA");
		  if(admin.login(username,password,role)){
			  admin.setUsername(username);
			  admin.setPassword(password);
			  admin.setRole(role);
			  session.setAttribute("admin", admin); //����ǰ��¼�ɹ����û���session
			  return "sys_menu.jsp";
		  }else{
			  model.addAttribute("message","�û������������!"); //������ͼ�Ĵ�����Ϣ
			  return "adminLogin.jsp";
		  }

	}
	@RequestMapping("/logout.do")
	  public String logout(HttpSession session) throws ClassNotFoundException, SQLException{
		  session.invalidate(); //sessionʧЧ
		//
		  return "adminLogin.jsp";

	}

}
