package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Gonggao;
import bean.PingLun;
import dao.PhoneDao;

/**
 * Servlet implementation class updata_ggao
 */
public class updata_ggao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updata_ggao() {
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

		response.setContentType("text/plain; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("jgname");
		String clue = request.getParameter("jgclue");
		String ggao = request.getParameter("jgonggao");
		String school = request.getParameter("jschool");
		System.out.println("需求数据----[" + name + clue + ggao + "]----以获取");
		PhoneDao dataus = new PhoneDao();
		Gonggao gg = new Gonggao();
		try {
			if (dataus.chackggname(name) == true) {
				gg.setGname(name);
				gg.setGclue(clue);
				gg.setGonggao(ggao);
				gg.setOfschool(school);
				dataus.updata_gg(gg);
				System.out.println("更新公告----[" + clue + ggao + "]----以获取");
			} else {
				gg.setGname(name);
				gg.setGclue(clue);
				gg.setGonggao(ggao);
				gg.setOfschool(school);
				dataus.addgg(gg);
				System.out.println("创建公告----[" + clue + ggao + "]----以获取");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// dataus.removegg(name);

	}

}
