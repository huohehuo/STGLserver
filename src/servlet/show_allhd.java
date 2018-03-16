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
import dao.PhoneDao;

/**
 * Servlet implementation class show_allhd
 */
public class show_allhd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show_allhd() {
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
		
		String school=request.getParameter("school");
		System.out.println("需求数据----["+school+"]----以获取");
		PhoneDao dataus = new PhoneDao();
		//PingLun us = new PingLun();
		try {
			
				List<HuoDong> list = dataus.show_hdby(school);
				
				JSONStringer js = new JSONStringer();
				js.object();
				js.key("data");
				js.array();
				
				for (int i = 0; i < list.size(); i++) {
					HuoDong rs = (HuoDong) list.get(i);
					js.object();
					js.key("group");
					js.object();
					js.key("hid");
					js.value(rs.getHid());
					js.key("rid");
					js.value(rs.getRid());
					js.key("hname");
					js.value(rs.getHname());
					js.key("htitle");
					js.value(rs.getHtitle());
					js.key("htime");
					js.value(rs.getHtime());
					js.key("hword");
					js.value(rs.getHword());
					js.key("ofschool");
					js.value(rs.getOfschool());
					js.key("ofclue");
					js.value(rs.getOfclue());
					js.endObject();
					js.endObject();
				}
				js.endArray();
				js.endObject();
				
				//System.out.println("取出vip所属数据");
				out.print(js.toString());
				out.flush();
				out.close();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
