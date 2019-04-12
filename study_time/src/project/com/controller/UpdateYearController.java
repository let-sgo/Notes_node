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
 * Servlet implementation class UpdateYearController
 */
@WebServlet("/UpdateYearController")
public class UpdateYearController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateYearController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String year1 = request.getParameter("year1");
		String year2 = request.getParameter("year2");
		
		int year11 = Integer.parseInt(year1);
		int year12 = Integer.parseInt(year2);
		RollListDao rld = DaoFactory.getRollListDao();
		
		boolean result=rld.updateYear(year11,year12);
		if(result){
			RequestDispatcher rd = request.getRequestDispatcher("admin_dashboard.jsp");
			request.setAttribute("emessage","year updated successfully");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("FirstForm.jsp");
			request.setAttribute("emessage","error in updating");
			rd.forward(request, response);
		}
		
	}

}
