package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.HuoDong;
import bean.Nmchat;
import dao.PhoneDao;

/**
 * Servlet implementation class wr_nmchat
 */
public class wr_nmchat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wr_nmchat() {
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
		
		//int nid =Integer.parseInt(request.getParameter("jnid"));
		String name = request.getParameter("jname");
		String sex = request.getParameter("jsex");
	    String clue = request.getParameter("jclue");
	    String school = request.getParameter("jschool");
	    String say = request.getParameter("jsaytext");
	 
	    PhoneDao dataus = new PhoneDao();
		Nmchat us = new Nmchat();
		//us.setNid(nid);
		us.setName(name);
		us.setSex(sex);
		us.setClue(clue);
		us.setSchool(school);
		us.setSaytext(say);
		
		dataus.createnm(us);
		
	}

}
