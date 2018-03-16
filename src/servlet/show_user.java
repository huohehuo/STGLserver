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
import dao.WebDao;

/**
 * Servlet implementation class show_user
 */
public class show_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show_user() {
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
		WebDao dataus = new WebDao();
		
		try {
			List<PUser> list = dataus.show_user();
			JSONStringer js = new JSONStringer();
			js.object();
			js.key("data");
			js.array();
			
			for (int i = 0; i < list.size(); i++) {
				PUser rs = (PUser) list.get(i);
				js.object();
				js.key("group");
				js.object();
				js.key("name");
				js.value(rs.getName());
				js.key("pwd");
				js.value(rs.getPassword());
				js.key("sex");
				js.value(rs.getSex());
				js.key("age");
				js.value(rs.getAge());
				js.endObject();
				js.endObject();
			}
			js.endArray();
			js.endObject();
			
			
			out.print(js.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
