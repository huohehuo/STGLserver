package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONStringer;
import bean.PUser;
import bean.PingLun;
import dao.PhoneDao;

/**
 * Servlet implementation class chackdata
 */
public class chackdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chackdata() {
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
		
		String name = request.getParameter("name");
	    PhoneDao dataus = new PhoneDao();
			//PUser us = new PUser();
			//String a=us.getName();
			//String b=us.getPassword();
			try {
				if(dataus.chackname(name)==true)
				{
					System.out.println("请求数据：["+name+"]获取，验证成功");
					List<PUser> list = dataus.findupdate(name);
					
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
						js.key("pwd");
						js.value(rs.getPassword());
						js.key("sex");
						js.value(rs.getSex());
						js.key("age");
						js.value(rs.getAge());
						js.key("clue");
						js.value(rs.getClue());
						js.key("mishi");
						js.value(rs.getMishi());
						js.endObject();
						js.endObject();
					}
					js.endArray();
					js.endObject();
					
					
					
					out.print(js.toString());
					out.flush();
					out.close();
				}
				else
				{
					System.out.println("获取用户验证失败！ 返回数据失败");
					//out.print("sorry");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}


}
