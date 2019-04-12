package project.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.dao.QuestionPaperDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class DeletePaperController
 */
@WebServlet("/DeletePaperController")
public class DeletePaperController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePaperController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename = request.getParameter("filename");
		QuestionPaperDao qpd = DaoFactory.getQuestionPaperDao();
	 boolean result=qpd.deleteQuestionPaper(filename);
	 if(result){
		 RequestDispatcher rd = request.getRequestDispatcher("admin_dashboard.jsp");
		 request.setAttribute("emessage","question paper successfully deleted");
		 rd.forward(request, response);
	 }
	}

}
