package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.util.JSONStringer;
import bean.PUser;
import dao.PhoneDao;

/**
 * Servlet implementation class find_pwd
 */
public class find_pwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public find_pwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
	String name = request.getParameter("jname");
	String mishi = request.getParameter("jmishi");
    String pwd = request.getParameter("jpwd");
    
    System.out.println("确认需要改密的用户名-----"+name+mishi+pwd);
    PhoneDao dataus = new PhoneDao();
		PUser us = new PUser();
		//String a=us.getName();
		//String b=us.getPassword();
		
			try {
				if(dataus.chackmishi(name,mishi)==true)
				{
					System.out.println("确认需要改密的用户名-----"+name);
					us.setPassword(pwd);
					us.setName(name);
					dataus.update_pwd(us);
					
				
				}
				else
				{
					System.out.println("error");
					out.print("sorry");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
