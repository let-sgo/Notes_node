package project.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.dao.NotesDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class DeleteNotesController
 */
@WebServlet("/DeleteNotesController")
public class DeleteNotesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNotesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sn = request.getParameter("sno");
		long sno = Long.parseLong(sn);
		NotesDao nd = DaoFactory.getNotesDao();
		boolean isDeleted = nd.delete(sno);
		if(isDeleted){
			RequestDispatcher rd = request.getRequestDispatcher("admin_dashboard.jsp");
			request.setAttribute("emessage","notes successfully deleted");
			rd.forward(request,response);
		}
	}

}
