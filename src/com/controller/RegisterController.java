package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.RegisterDao;
import com.model.Customer;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession(true);
		String msg=null;
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobno=request.getParameter("mobno");
		String balance=request.getParameter("balance");
		//String bal=String.valueOf(balance);
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Customer cust=new Customer(name,email,mobno,balance,username,password);
		RegisterDao rdao=new RegisterDao();
		int i=rdao.checkuser(cust);
		if(i>0){
			msg="Username & Password already Exist";
			session.setAttribute("reg2", msg);
			response.sendRedirect("Register.jsp");
		}else
		{
			int j=rdao.create(cust);
			if(j>0)
			{
				session.setAttribute("reg", username);
				response.sendRedirect("Login.jsp");
			}
			

		}	
	
	}

}
