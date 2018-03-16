package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PingLun;
import dao.PhoneDao;

/**
 * Servlet implementation class wr_pl
 */
public class wr_pl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wr_pl() {
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
		
		int hid =Integer.parseInt(request.getParameter("jhid"));
		int rid =Integer.parseInt(request.getParameter("juserid"));
		String name = request.getParameter("jusername");
	    String plun = request.getParameter("jpword");
	    
	    PhoneDao dataus = new PhoneDao();
		PingLun us = new PingLun();
		us.setHid(hid);
		us.setRid(rid);
		us.setPname(name);
		us.setPword(plun);
		
		
		dataus.createpl(us);
		
		
	}

}
