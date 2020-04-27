package dev.deol.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.deol.controllers.LoginController;
import dev.deol.controllers.TaskController;
import dev.deol.daos.EmployeeDAO;
import dev.deol.daos.EmployeeDAOmariadb;
import dev.deol.entities.Employee;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    LoginController lcontroller = new LoginController();
	TaskController tcontroller = new TaskController();
    public EmployeeDAO edao = new EmployeeDAOmariadb();

   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();    
//				.substring(request.getContextPath().length())
//				.startsWith("/static/")) ;
		System.out.println(uri);
		
		//String uri = request.getRequestURI();
		//System.out.println(uri);
//		HttpSession sess = request.getSession();
//		if(uri.equals("/ReimbursementSystem/login/user")) {
//			String username = request.getParameter("username");
//			String password = request.getParameter("password");
//			
//			Employee emp= edao.login(username, password);
//			//Manager m = mserv.managerLogin(user, pass);
//			System.out.println(emp);
//			if(emp!=null) {
//				int eId = emp.geteId();
//				sess.setAttribute("eId", eId);
//				response.sendRedirect("http://localhost:8080/ReimbursementSystem/employee.html");
//				System.out.println(sess.getAttribute("eId")+" ");
//			}
//		}
		
		switch(uri) {
		
		
		//API application program interface does not usually do not return HTML pages/css/js
		//they are end points that you can send and get information from(usaually
		//case "/ReimbursmentSystem/login/user" : lcontroller.login(request, response);break;
		//case "/ReimbursmentSystem/login/user" : tcontroller.getAllReimbursments(request, response); break;
		
		case "/ReimbursmentSystem/login/user" : lcontroller.login(request, response); break;
		//case "/ReimbursmentSystem/login/manager" : lcontroller.loginManager(request, response); break;
		case "/ReimbursmentSystem/api/reimbursments" : tcontroller.getAllReimbursments(request, response); break;
		case "/ReimbursmentSystem/api/addReimbursment" : tcontroller.addReimbursment(request, response); break;
		case "/ReimbursmentSystem/api/pendingReimbursments" : tcontroller.pendingReimbursments(request, response); break;
		case "/ReimbursmentSystem/api/completedReimbursments" : tcontroller.completedReimbursments(request, response); break;
		case "/ReimbursmentSystem/api/updateReimbursment" : tcontroller.updateReimbursment(request, response); break;
		case "/ReimbursmentSystem/api/reimbursmentsByEID" : tcontroller.getAllReimbursmentsByEID(request, response); break;
		case "/ReimbursmentSystem/api/reimbursmentsByMID" : tcontroller.getAllReimbursmentsByMID(request, response); break;

		
		default : response.getWriter().append("your request uri did not match with anything"); break;
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
