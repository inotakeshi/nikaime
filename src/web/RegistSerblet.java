package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RegistBean;
import servise.KaiinServise;

/**
 * Servlet implementation class RegistSerblet
 */
@WebServlet("/RegistSerblet")
public class RegistSerblet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistSerblet() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		RegistBean rb;
		String registIdStr=request.getParameter("Id");
		String registName=request.getParameter("Name");
		String registSex=request.getParameter("sex");
		
		int registId=Integer.parseInt(registIdStr);

		KaiinServise ks=new KaiinServise();

		rb=ks.setKaiin(registId, registName, registSex);

		request.setAttribute("bean", rb);

		RequestDispatcher disp=request.getRequestDispatcher("/Regist.jsp");
		disp.forward(request, response);

	}

}
