package webServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PUser;


import dao.WebDao;

/**
 * Servlet implementation class webinsert
 */
public class webinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public webinsert() {
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
		try {
			request.setCharacterEncoding("UTF-8");
			String name=request.getParameter("name");
			String pwd=request.getParameter("pwd");
			String sex=request.getParameter("sex");
			int age=Integer.parseInt(request.getParameter("age"));
			String clue=request.getParameter("clue");
			String vip=request.getParameter("vip");
			PUser jj=new PUser();

			jj.setName(name);
			jj.setPassword(pwd);
			jj.setSex(sex);
			jj.setAge(age);
			jj.setClue(clue);
			jj.setVip(vip);
			WebDao ss=new WebDao();
			ss.create(jj);
			request.getRequestDispatcher("y.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}
