package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import bean.PUser;
import dao.PhoneDao;
import dao.WebDao;

/**
 * Servlet implementation class register
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
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
		response.setContentType("text/plain; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		String clue = request.getParameter("clue");
		String sch	=request.getParameter("school");
		
		System.out.println("user"+name+",age"+age);
		
		
		PhoneDao dataus = new PhoneDao();
		PUser us = new PUser();
		try {
			if(dataus.chackname(name) ==true)
			{
			
				out.print("error");
				System.err.println(" 错误！["+name+"]已经被注册");
			}
			else
			{
				us.setName(name);
				us.setPassword(pwd);
				us.setSex(sex);
				us.setAge(age);
				us.setClue(clue);
				us.setSchool(sch);
				dataus.create(us);
				
				System.out.println("——————信息录入成功");
				out.print("success");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
}
