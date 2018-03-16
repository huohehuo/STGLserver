package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.util.JSONStringer;
import bean.Forvip;
import bean.PingLun;
import dao.PhoneDao;

/**
 * Servlet implementation class forvip
 */
public class forvip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forvip() {
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
		
		int rid = Integer.parseInt(request.getParameter("juserid"));
		String name=request.getParameter("jusername");
		String forvip=request.getParameter("jforvip");
	    PhoneDao dataus = new PhoneDao();
		Forvip us=new Forvip();	
	    try {
			if(dataus.chackforvip(name) ==true)
			{
			
				out.print("error");
				System.err.println(" ——————已申请过vip");
			}
			else
			{
				us.setRid(rid);
				us.setName(name);
				us.setReason(forvip);
				
				dataus.createforvip(us);
				
				System.out.println("——————申请信息录入成功");
				out.print("success");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
}
