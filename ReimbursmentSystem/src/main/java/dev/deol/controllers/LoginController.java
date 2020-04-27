package dev.deol.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.deol.daos.EmployeeDAO;
import dev.deol.daos.EmployeeDAOmariadb;
import dev.deol.daos.ManagerDAO;
import dev.deol.daos.ManagerDAOmariadb;
import dev.deol.entities.Employee;
import dev.deol.entities.Manager;

public class LoginController {
	
	public EmployeeDAO edao = new EmployeeDAOmariadb();
	public ManagerDAO mdao = new ManagerDAOmariadb();
	
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String uri = request.getRequestURI();   
		System.out.println(uri);
		HttpSession sess = request.getSession();
		
		if(uri.equals("/ReimbursementSystem/login/manager")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			Manager m = mdao.loginManager(username, password); 
			System.out.println(m);
			if(m!=null) {
				int mid = m.getmId();
				sess.setAttribute("mid", mid);
				response.sendRedirect("http://localhost:8080/ReimbursmentSystem/manager.html");
				System.out.println(sess.getAttribute("mid")+" "+sess.getAttribute("eid"));
			}

		}else if(uri.equals("/ReimbursementSystem/login/user")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Employee e = edao.login(username, password);
			if(e!=null) {
				int eid = e.geteId();
				sess.setAttribute("eid", eid);
				response.sendRedirect("http://localhost:8080/ReimbursmentSystem/employee.html");
			}
			System.out.println(sess.getAttribute("mid")+" "+sess.getAttribute("eid"));
		}

//		public void loginManager(HttpServletRequest request, HttpServletResponse response) throws IOException {
//			
//			String username = request.getParameter("username");
//			String password = request.getParameter("password");
//			Manager login = mdao.loginManager(username, password);
//			if(login == null) {
//				response.sendRedirect("http://localhost:8080/ReimbursmentSystem/index.html");
//			} else if(login.getUsername()==username ) {
//				HttpSession session = request.getSession();
//				session.setAttribute("username", login);
//				response.sendRedirect("http://localhost:8080/ReimbursmentSystem/manager.html");
//			}
//			/*else if(login.getUser_type().compareToIgnoreCase("Manager") == 0) {
//				HttpSession session = req.getSession();
//				session.setAttribute("manager", login);
//				resp.sendRedirect("/FrontController/static/managerHomepage.html");
//			}*/
//		}

		
		//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		Employee login = edao.login(username, password);
//		if(login == null) {
//			response.sendRedirect("http://localhost:8080/ReimbursmentSystem/index.html");
//		} else if(login.getUsername()==username ) {
//			HttpSession session = request.getSession();
//			session.setAttribute("username", login);
//			response.sendRedirect("http://localhost:8080/ReimbursmentSystem/employee.html");
//		}
//		/*else if(login.getUser_type().compareToIgnoreCase("Manager") == 0) {
//			HttpSession session = req.getSession();
//			session.setAttribute("manager", login);
//			resp.sendRedirect("/FrontController/static/managerHomepage.html");
//		}*/
	}
	
	public void getPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("username")==null) {
			request.getRequestDispatcher("employee.html").forward(request,response);
		} else {
			response.sendRedirect("index.html");
		}
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		//resp.sendRedirect("/FrontController/static/managerHomepage.html");
	}
	
	
	
	public void getPageManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("username")==null) {
			request.getRequestDispatcher("manager.html").forward(request,response);
		} else {
			response.sendRedirect("index.html");
		}
	}
	
	

}
