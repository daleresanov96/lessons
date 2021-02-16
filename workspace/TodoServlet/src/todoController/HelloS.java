package todoController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloS
 */
public class HelloS extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloS() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String name = (String) request.getAttribute("userName");
//		if (name == null || "".equals(name)) {
//		request.setAttribute("userName", "Guest");
//		}
//		String view = "/WEB-INF/view/index.jsp";
//		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
//		dispatcher.forward(request, response);
		response.sendRedirect("リダイレクト先");
		// リダイレクト先はURLで指定しても良いし、同サーバー内であればファイル構成に従ったパスでも可
		// 例えば:
		response.sendRedirect("http://www.hogehoge.com");
		response.sendRedirect("/サーブレット名");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		request.setAttribute("userName", name);
		doGet(request, response);
	}

}
