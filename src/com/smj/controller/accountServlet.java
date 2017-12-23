package com.smj.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smj.dao.accountDao;
import com.smj.domain.Account;

/**
 * Servlet implementation class accountServlet
 */
@WebServlet("/account")
public class accountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		String account1 = request.getParameter("account");
		String password = request.getParameter("password");
		
		Account account = new Account(account1,password);
		accountDao dao = new accountDao();
		try {
			dao.save(account);
			response.sendRedirect("register.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		switch (action) {
//		case "findAll":
//			doFindAll(request,response);
//			break;
//
//		case "search":
//			doSearch(request,response);
//			break;
//		}
	}


//	private void doSearch(
//			HttpServletRequest request, 
//			HttpServletResponse response) {
//		
//	}
//
//
//	private void doFindAll(
//			HttpServletRequest request, 
//			HttpServletResponse response) {
//		
//		String id = request.getParameter("id");
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//	}

}
