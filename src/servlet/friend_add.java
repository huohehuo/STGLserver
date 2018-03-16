package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Friends;
import bean.HuoDong;
import dao.PhoneDao;

/**
 * Servlet implementation class friend_add
 */
public class friend_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public friend_add() {
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

		int rid = Integer.parseInt(request.getParameter("jrid"));
		int fid = Integer.parseInt(request.getParameter("jfriendid"));
		String fname = request.getParameter("jfriendname");
		System.out.println("传入" + fname);

		PhoneDao dataus = new PhoneDao();
		Friends us = new Friends();

		try {
			if(rid==fid)
			{
				out.print("error2");
				System.err.println(" 不能添加自己为好友 ！");
			}
			else if(dataus.chackfriend(rid, fid) == true)
			{
				out.print("error");
				System.err.println(" 错误！["+fname+"]已经添加过好友");
				
			}else
			{
				us.setRid(rid);
				us.setFriendid(fid);
				us.setFriendname(fname);
				dataus.add_friend(us);
				System.out.println("——————好友添加成功");
				out.print("success");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
