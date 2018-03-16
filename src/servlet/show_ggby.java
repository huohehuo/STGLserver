package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.util.JSONStringer;
import bean.Gonggao;
import bean.PUser;
import dao.PhoneDao;

/**
 * Servlet implementation class show_ggby
 */
public class show_ggby extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show_ggby() {
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
		
			try {
				
					System.out.println("需求数据----["+clue+"]----以获取");
					List<Gonggao> list = dataus.show_ggbyclueschool(clue,school);
					
					JSONStringer js = new JSONStringer();
					js.object();
					js.key("data");
					js.array();
					
					for (int i = 0; i < list.size(); i++) {
						Gonggao rs = (Gonggao) list.get(i);
						js.object();
						js.key("group");
						js.object();
						js.key("gid");
						js.value(rs.getGid());
						js.key("gname");
						js.value(rs.getGname());
						js.key("gclue");
						js.value(rs.getGclue());
						js.key("ofschool");
						js.value(rs.getOfschool());
						js.key("gonggao");
						js.value(rs.getGonggao());
						
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
