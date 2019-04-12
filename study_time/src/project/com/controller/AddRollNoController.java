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
 * Servlet implementation class AddRollNoController
 */
@WebServlet("/AddRollNoController")
public class AddRollNoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRollNoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String startRollNo = request.getParameter("rollno");
		String year = request.getParameter("year");
		String total_student = request.getParameter("total_student");
		Long startRollNo1 = Long.parseLong(startRollNo);
		int total_student1 = Integer.parseInt(total_student);
		int year1 = Integer.parseInt(year);
		RollListDao rld = DaoFactory.getRollListDao();
		
		boolean result=rld.enterRollNo(startRollNo1, total_student1, year1);
		if(result){
			RequestDispatcher rd = request.getRequestDispatcher("admin_dashboard.jsp");
			request.setAttribute("emessage","roll no added successfully");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("FirstForm.jsp");
			request.setAttribute("emessage","error in adding");
			rd.forward(request, response);
		}
		
		
	}

}
