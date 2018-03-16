package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import bean.PUser;
import dao.PhoneDao;

/**
 * Servlet implementation class changedata
 */
public class changedata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changedata() {
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
		/*
		StringBuffer json = new StringBuffer();
		String line = null;
		
		BufferedReader reader = request.getReader();
		while ((line = reader.readLine()) !=null)
		{
			json.append(line);
		}
		
		JSONObject jsonTemp = JSONObject.fromObject(json.toString());
		JSONObject jsonObj = jsonTemp.getJSONObject("json");

		String name = jsonObj.getString("name");
		String pwd = jsonObj.getString("pwd");
		String sex = jsonObj.getString("sex");
		int age = Integer.parseInt(jsonObj.getString("age"));*/
		String name = request.getParameter("name");
	    String pwd = request.getParameter("pwd");
	    String sex = request.getParameter("sex");
	    int age = Integer.parseInt(request.getParameter("age"));
	    String clue = request.getParameter("clue");
	    String mishi = request.getParameter("mishi");
		System.out.println("[ "+name+"] 用户数据已获取。。。。。");
		
		PhoneDao dataus = new PhoneDao();
		PUser us = new PUser();
		us.setName(name);
		us.setPassword(pwd);
		us.setSex(sex);
		us.setAge(age);
		us.setClue(clue);
		us.setMishi(mishi);
		dataus.update_user(us);
			
	       PrintWriter printWriter = response.getWriter();
	        printWriter.print("success");
	        printWriter.flush();
	        printWriter.close();
	        System.err.println("["+name+"] 的信息更改成功");
			
	}

	}


