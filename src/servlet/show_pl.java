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
import bean.PingLun;
import dao.PhoneDao;

/**
 * Servlet implementation class show_pl
 */
public class show_pl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show_pl() {
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
		
		int hid = Integer.parseInt(request.getParameter("jhid"));
	    PhoneDao dataus = new PhoneDao();
			//PUser us = new PUser();
			//String a=us.getName();
			//String b=us.getPassword();
			try {
					System.out.println("------评论提取成功"+hid);
					List<PingLun> list = dataus.findpl(hid);
					
					JSONStringer js = new JSONStringer();
					js.object();
					js.key("data");
					js.array();
					
					for (int i = 0; i < list.size(); i++) {
						PingLun rs = (PingLun) list.get(i);
						js.object();
						js.key("group");
						js.object();
						js.key("pid");
						js.value(rs.getPid());
						js.key("hid");
						js.value(rs.getHid());
						js.key("rid");
						js.value(rs.getRid());
						js.key("pname");
						js.value(rs.getPname());
						js.key("pword");
						js.value(rs.getPword());
						js.endObject();
						js.endObject();
					}
					js.endArray();
					js.endObject();
					
					
					
					out.print(js.toString());
					System.out.println("------评论提取成功"+js.toString());
					out.flush();
					out.close();
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}


}
