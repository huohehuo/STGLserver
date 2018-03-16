package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Chatdata;
import bean.PingLun;
import dao.PhoneDao;

/**
 * Servlet implementation class reply
 */
public class reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reply() {
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
		
		String isname =request.getParameter("jisname");
		String istext =request.getParameter("jistext");
		String toname = request.getParameter("jtoname");
	    
	    
	    PhoneDao dataus = new PhoneDao();
		Chatdata us = new Chatdata();
		us.setIsname(isname);
		us.setIstext(istext);
		us.setToname(toname);
		
		
		
		dataus.forreply(us);
		
		
	}

}
