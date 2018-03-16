package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.HuoDong;
import bean.PingLun;
import dao.PhoneDao;

/**
 * Servlet implementation class wr_hd
 */
public class wr_hd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wr_hd() {
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
		
		int rid =Integer.parseInt(request.getParameter("jrid"));
		String hname = request.getParameter("jname");
		String htitle = request.getParameter("jtitle");
	    String htime = request.getParameter("jtime");
	    String hword = request.getParameter("jword");
	    String ofschool = request.getParameter("jschool");
	    String ofclue = request.getParameter("jclue");
	    PhoneDao dataus = new PhoneDao();
		HuoDong us = new HuoDong();
		us.setRid(rid);
		us.setHname(hname);
		us.setHtitle(htitle);
		us.setHtime(htime);
		us.setHword(hword);
		us.setOfschool(ofschool);
		us.setOfclue(ofclue);
		dataus.createhd(us);
	}

}
