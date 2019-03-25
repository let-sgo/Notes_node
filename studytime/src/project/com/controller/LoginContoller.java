package project.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.com.bo.User;
import project.com.dao.UserDao;
import project.com.dao.factory.DaoFactory;

/**
 * Servlet implementation class LoginContoller
 */
@WebServlet("/LoginContoller")
public class LoginContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UserDao us = DaoFactory.getUserDao();
	String id1 = request.getParameter("id");
	long id = Long.parseLong(id1);
	String sem = request.getParameter("semester");
	String password = request.getParameter("password");
	System.out.println("id "+id);
	System.out.println("sem "+sem);
	System.out.println("password "+password);
	boolean isUserValid = us.isValidUser(id, password);
	if(isUserValid){
		User user=us.getUser(id);
		HttpSession session=request.getSession(false);
		session.setAttribute("id",user.getId());
		session.setAttribute("username",user.getFname());
		session.setAttribute("sem",sem);
		response.sendRedirect("index_landing3.jsp");
	}else{
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		request.setAttribute("message","invalid id or password try again");
		rd.forward(request,response);
	}
	}

}
