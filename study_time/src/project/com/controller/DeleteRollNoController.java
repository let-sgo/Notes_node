package project.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.dao.RollListDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class DeleteRollNoController
 */
@WebServlet("/DeleteRollNoController")
public class DeleteRollNoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRollNoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String year = request.getParameter("year");
		
		int year1 = Integer.parseInt(year);
		RollListDao rld = DaoFactory.getRollListDao();
		
		boolean result=rld.deleteStudentByYear(year1);
		if(result){
			RequestDispatcher rd = request.getRequestDispatcher("admin_dashboard.jsp");
			request.setAttribute("emessage","deleted successfully");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("SecondForm.jsp");
			request.setAttribute("emessage","error in deleting");
			rd.forward(request, response);
		}
	}

}
