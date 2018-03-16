package webServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.PUser;
import dao.WebDao;

/**
 * Servlet implementation class weblogin
 */
public class weblogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public weblogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String username = new String(request.getParameter("admin"));
		String password = new String(request.getParameter("pwd"));
		System.err.println(" ¡ª¡ª¡ª¡ª¡ª¡ªµÇÂ½³É¹¦");
		Admin user = new Admin();
		user.setName(username);
		user.setPwd(password);
		WebDao dao = new WebDao();
		boolean isLogin;
		try {
			isLogin = dao.login(user);
			if (isLogin) {
				response.sendRedirect("index.jsp");
			} else {
				response.sendRedirect("login_error.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
