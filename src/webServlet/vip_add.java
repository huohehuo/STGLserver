package webServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forvip;
import bean.HuoDong;
import bean.PUser;
import dao.WebDao;

/**
 * Servlet implementation class vip_add
 */
public class vip_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vip_add() {
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
		try {
			request.setCharacterEncoding("UTF-8");
			int rid = Integer.parseInt(request.getParameter("rid"));
			
			
			System.out.println("将要设置社长权限-----"+rid);
			WebDao us=new WebDao();
			Forvip bb = new Forvip();
			PUser jj=new PUser();
			jj.setVip("Y");
			jj.setRid(rid);
			us.add_vip(jj);
			System.out.println("-----生成一名社长成功");
			
			bb.setRid(rid);
			us.del_forvip(bb);
			request.getRequestDispatcher("y.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
