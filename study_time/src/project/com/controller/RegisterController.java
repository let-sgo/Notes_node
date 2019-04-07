package project.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.dao.UserDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao us = DaoFactory.getUserDao();
		long roll_no = Long.parseLong(request.getParameter("id"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
	boolean isRollNoExist=us.isRollNoExist(roll_no);
	RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
	if(isRollNoExist==false){
		request.setAttribute("message1","not a valid roll no of IT Department");
		rd.forward(request,response);
	}
	boolean isUserExist=us.userExist(roll_no);
	if(isUserExist){
		request.setAttribute("message2","user with the roll no already exist try other");
		rd.forward(request,response);
	}
	boolean isRegister = us.register(roll_no, fname, lname, email);
	if(isRegister){
		response.sendRedirect("registered.jsp");
	}else{
		request.setAttribute("message3","may be invalid email address issue in registration contact admin");
		rd.forward(request,response);
	}
	}

}
