package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servise.KaiinServise;

/**
 * Servlet implementation class SerchSerblet
 */
@WebServlet("/SerchSerblet")
public class SerchSerblet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerchSerblet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HTMLから入力されたＩＤの受け取り
		String serchIdStr=request.getParameter("Id");
		//int型に型変換
		int serchId=Integer.parseInt(serchIdStr);
		//会員サービスのインスタンスの生成
		KaiinServise ks=new KaiinServise();
		//kaiinServiseのgetSerchを実行し戻り値としてSerchBeanを受け取る
		request.setAttribute("bean", ks.getSerch(serchId));
		//次に移動する先jspを設定
		RequestDispatcher disp=request.getRequestDispatcher("/Serch.jsp");
		//移動
		disp.forward(request, response);
	}

}
