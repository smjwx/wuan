package com.smj.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.smj.dao.accountDao;
import com.smj.domain.Account;
import com.smj.mapper.AccountMapper;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		String Name = request.getParameter("account");
		String password = request.getParameter("password");
		
		
		accountDao dao = new accountDao();
		Account a = new Account(Name,password);
		
		try {
			Account account = dao.login(a);
			System.out.println(account);
			
			if (account != null && account.getPassword().equals(password)) {
				// 用户名 密码匹配
				request.setAttribute("user", account);
				response.sendRedirect("login.jsp");
			} else {
				// 不匹配
				request.setAttribute("errorMessage", "密码用户名不匹配");
				response.sendRedirect("fail.jsp");

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
