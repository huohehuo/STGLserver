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
import bean.Nmchat;
import dao.PhoneDao;

/**
 * Servlet implementation class show_nmchat
 */
public class show_nmchat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show_nmchat() {
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
		PhoneDao dataus = new PhoneDao();
		//PingLun us = new PingLun();
		try {

			List<Nmchat> list = dataus.show_nmchat();
			
			JSONStringer js = new JSONStringer();
			js.object();
			js.key("data");
			js.array();
			
			for (int i = 0; i < list.size(); i++) {
				Nmchat rs = (Nmchat) list.get(i);
				js.object();
				js.key("group");
				js.object();
				js.key("nid");
				js.value(rs.getNid());
				js.key("name");
				js.value(rs.getName());
				js.key("sex");
				js.value(rs.getSex());
				js.key("clue");
				js.value(rs.getClue());
				js.key("school");
				js.value(rs.getSchool());
				js.key("saytext");
				js.value(rs.getSaytext());
				js.endObject();
				js.endObject();
			}
			js.endArray();
			js.endObject();
			
			System.out.println(js.toString());
			out.print(js.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
