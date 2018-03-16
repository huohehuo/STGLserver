package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.util.JSONStringer;
import bean.Chatdata;
import bean.PingLun;
import dao.PhoneDao;

/**
 * Servlet implementation class show_chat
 */
public class show_chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show_chat() {
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
		
		//String name = request.getParameter("jisname");
		//String text = request.getParameter("jistext");
		String toname = request.getParameter("jisname");
		//int hid = Integer.parseInt(request.getParameter("jhid"));
		
		System.out.println("------提取成功"+toname);
		
		PhoneDao pd = new PhoneDao();
		
		Chatdata chat=new Chatdata();
		
		try {
			//List<Chatdata> list = pd.show_chatby(name, toname);
			
			List<Chatdata> list2 = pd.show_chatby(toname);
			JSONStringer js = new JSONStringer();
			js.object();
			js.key("data");
			js.array();
			
			
			for(int j=0;j<list2.size();j++)
			{
				Chatdata rs2 = (Chatdata) list2.get(j);
				js.object();
				js.key("group");
				js.object();
				js.key("jfcid");
				js.value(rs2.getCid());
				js.key("jfromname");
				js.value(rs2.getIsname());
				js.key("jfromtext");
				js.value(rs2.getIstext());
				js.key("jfromtoname");
				js.value(rs2.getToname());
				js.endObject();
				js.endObject();
				
			}
			
			
			
			js.endArray();
			js.endObject();
			
			
			
			out.print(js.toString());
			System.out.println("------传出的数据为：：："+js.toString());
			out.flush();
			out.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
