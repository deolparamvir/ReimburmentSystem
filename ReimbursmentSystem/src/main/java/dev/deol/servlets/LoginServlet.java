package dev.deol.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.deol.daos.EmployeeDAO;
import dev.deol.daos.EmployeeDAOmariadb;
import dev.deol.entities.Employee;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public EmployeeDAO edao = new EmployeeDAOmariadb();

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String uri = request.getRequestURI();
//		System.out.println(uri);
//		HttpSession sess = request.getSession();
//		if(uri.equals("/ /ReimbursementSystem/login/user?username=JATT&password=PASSWORD")) {
//			String username = request.getParameter("username");
//			String password = request.getParameter("password");
//			System.out.println("here");
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
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
