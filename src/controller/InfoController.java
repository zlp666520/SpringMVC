package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Info;

@Controller
public class InfoController {
  
  @RequestMapping("/list.do")
  public String list(Model model) throws ClassNotFoundException, SQLException{
	 //����ģ��
	 Info info=new Info();
	 ArrayList<Info> list=(ArrayList<Info>) info.list(); 
	 //���ݸ���ͼ
	 model.addAttribute("list",list);
	 return "infoList.jsp";
  }
  
  @RequestMapping("/add.do")
  public String add(Info info) throws ClassNotFoundException, SQLException{
	  try {
		  //�������봦��
		  info.setName(new String(info.getName().getBytes("ISO8859_1"),"UTF-8"));
		  info.setSex(new String(info.getSex().getBytes("ISO8859_1"),"UTF-8"));
		  //����ģ��
			 info.addInfo(info);
     } catch (Exception e) {
         e.printStackTrace();
     }
	
	 //ˢ��
	 return "forward:list.do";
  }
  
  @RequestMapping("/del.do")
  public String del(Info info) throws ClassNotFoundException, SQLException{
	 //����ģ��
	 info.deleteByNo(info.getNo());
	 //ˢ��
	 return "forward:list.do";
  }
  @RequestMapping("/update.do")
  public String update(Info info) throws ClassNotFoundException, SQLException{
	//����ģ��
	  try {
		  //�������봦��
		  info.setName(new String(info.getName().getBytes("ISO8859_1"),"UTF-8"));
		  info.setSex(new String(info.getSex().getBytes("ISO8859_1"),"UTF-8"));
         info.update(info);
     } catch (Exception e) {
         e.printStackTrace();
     }
	 //ˢ��
	 return "forward:infoUpdate.do";
  }
  @RequestMapping("/listByPage.do")
  public String listByPage( int pageNo,Model model) throws ClassNotFoundException, SQLException{
	  int totalRow=Info.getTotalRow();
	  int pageSize=2;
	  int totalPage=totalRow%pageSize==0?totalRow/pageSize:totalRow/pageSize+1;
	  ArrayList<Info> list=Info.listByPage(pageNo, pageSize); //��ȡĳһҳ������
		 //���ݸ���ͼ
		 model.addAttribute("list",list);
	 //��ʾ��ҳ��
	 int begin=1; //��ʼҳ��
	 if(pageNo%pageSize==0) { begin=(pageNo);}
		 model.addAttribute("begin",begin);
		 model.addAttribute("pageSize",pageSize);
		 model.addAttribute("totalRow",totalRow);
		 model.addAttribute("totalPage",totalPage);
		 System.out.print(begin+"begin"+pageSize+"pageSize"+totalRow+"totalRow"+totalPage+"totalPage");
	return "infoListpage.jsp";
  }
  @RequestMapping("/listByPage2.do")
  public String listByPage2(@RequestParam (defaultValue="1") int pageNo,Model model) throws ClassNotFoundException, SQLException{
	return "infoListpage2.jsp";
  }
  @RequestMapping("/connectDB.do")
  public String connectDB(Model model) throws ClassNotFoundException, SQLException{
	 //����ģ��
	 Info info=new Info();
	 ArrayList<Info> list=(ArrayList<Info>) info.list(); 
	 //���ݸ���ͼ
	 model.addAttribute("list",list);
	 return "infoList.jsp";
  }
  
  @RequestMapping("/queryByNoName.do")
  public String queryByNoName(String no,String name,Model model) throws ClassNotFoundException, SQLException{
	 //����ģ��
	 Info info=new Info();
	 ArrayList<Info> list=(ArrayList<Info>) info.queryByNoNameList(no,name); 
	 //���ݸ���ͼ
	 model.addAttribute("list",list);
	 return "info_query_noName.jsp";
  }
  
  @RequestMapping("/querySex.do")
  public String querySex(String sex,Model model) throws ClassNotFoundException, SQLException{
	 //����ģ��
	 Info info=new Info();
	 ArrayList<Info> list=(ArrayList<Info>) info.queryBySexList(sex); 
	 //���ݸ���ͼ
	 model.addAttribute("list",list);
	 return "info_query_sex.jsp";
  }
  @RequestMapping("/queryStatisGroup.do")
  public String queryStatisGroup(String sex,Model model) throws ClassNotFoundException, SQLException{
	 //����ģ��
	 Info info=new Info();
	 ArrayList<Info> list=(ArrayList<Info>) info.queryByStaticList(); 
	 //���ݸ���ͼ
	 model.addAttribute("list",list);
	 return "info_query_statisGroup.jsp";
  }
  
  @RequestMapping("/infoUpdate.do")
  public String infoShow(String no,Model model) throws ClassNotFoundException, SQLException{
	 //����ģ��
	 Info info=new Info();
	 Info infoShow=(Info) info.findById(no);
	 //���ݸ���ͼ
	 model.addAttribute("info",infoShow);
	 return "infoUpdate.jsp";
  }
}

