package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Touroku2Dao;
import dto.Touroku;


/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/result2")
public class RS2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RS2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//formに入力された検索キーを取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String kin = request.getParameter("kin");
		String year = request.getParameter("year");
		String mon = request.getParameter("mon");
		String day = request.getParameter("day");
		int idN = Integer.parseInt(id);
		int kinN = Integer.parseInt(kin);
		int yearN = Integer.parseInt(year);
		int monN = Integer.parseInt(mon);
		int dayN = Integer.parseInt(day);

		//データベースから値を取得
		Touroku result = Touroku2Dao.setDao(idN,name,kinN,yearN,monN,dayN);

		//取得した値をリクエストスコープへ
		request.setAttribute("shunyu", result);

		//結果画面へフォワード
		String view = "/WEB-INF/view/result2.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}