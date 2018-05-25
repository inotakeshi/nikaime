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
 * Servlet implementation class ListOutSerblet
 */
@WebServlet("/ListOutSerblet")
public class ListOutSerblet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOutSerblet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //会員サービスのインスタンスの生成
        KaiinServise ks=new KaiinServise();
        //kaiinServiseのgetSerchを実行し戻り値としてListOutBeanを受け取る
        request.setAttribute("bean",ks.getListKaiinD() );
        //次に移動する先jspを設定
        RequestDispatcher disp=request.getRequestDispatcher("/ListOut.jsp");
        //移動
        disp.forward(request, response);
    }

}
