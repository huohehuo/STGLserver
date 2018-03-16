package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.util.JSONStringer;
import bean.HuoDong;
import bean.PUser;
import dao.PhoneDao;

/**
 * Servlet implementation class show_allst
 */
public class show_allst extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show_allst() {
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
		
		String clue = request.getParameter("jclue");
		String school = request.getParameter("jschool");
	    PhoneDao dataus = new PhoneDao();
			//PUser us = new PUser();
			//String a=us.getName();
			//String b=us.getPassword();
			try {
				
					System.out.println("需求数据----["+clue+"]----以获取");
					List<PUser> list = dataus.show_allmen(clue,school);
					
					JSONStringer js = new JSONStringer();
					js.object();
					js.key("data");
					js.array();
					
					for (int i = 0; i < list.size(); i++) {
						PUser rs = (PUser) list.get(i);
						js.object();
						js.key("group");
						js.object();
						js.key("rid");
						js.value(rs.getRid());
						js.key("name");
						js.value(rs.getName());
						
						js.key("sex");
						js.value(rs.getSex());
						js.key("age");
						js.value(rs.getAge());
						js.key("clue");
						js.value(rs.getClue());
						js.key("school");
						js.value(rs.getSchool());
						js.endObject();
						js.endObject();
					}
					js.endArray();
					js.endObject();
					
					
				
					out.print(js.toString());
					out.flush();
					out.close();
					System.out.println("需求数据-----已发送"+js.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}


}
