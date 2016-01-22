package com.etandon.phonenumber.servelets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * Servlet implementation class AppPages
 */
public class AppPages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppPages() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();

		response.setContentType("text/html");
		if (user != null) {
			//response.getWriter().println("Welcome, " + user.getNickname());
			//response.getWriter().println(
			//	"<a href='"
			//		+ userService.createLogoutURL(request.getRequestURI())
			//		+ "'> LogOut </a>");
			String page="/WEB-INF/appPages/Home.html";
	        String prefix="/WEB-INF/appPages/";		
			
	        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			try {
				dispatcher.forward(request, response);
			} 
			catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        

		} else {

			response.getWriter().println(
				"Please <a href='"
					+ userService.createLoginURL(request.getRequestURI())
					+ "'> LogIn </a>");

		}
	}

}
