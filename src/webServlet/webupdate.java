package webServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PUser;
import dao.WebDao;

/**
 * Servlet implementation class webupdate
 */
public class webupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public webupdate() {
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
			
			WebDao ss=new WebDao();
			PUser aa=new PUser();
			aa.setName(name);
			aa.setPassword(pwd);
			aa.setSex(sex);
			aa.setAge(age);
			ss.update(aa);
			if(ss.update(aa)!=0)
				{request.getRequestDispatcher("y.jsp").forward(request, response);}
			else
				{request.getRequestDispatcher("n.jsp").forward(request, response);}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
