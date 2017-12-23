package com.smj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smj.domain.Account;
import com.smj.mapper.AccountMapper;

import sun.security.pkcs11.Secmod.DbMode;

public class accountDao {

	public void save(Account account) throws SQLException {
		String sql = "insert into wuan(name,password) values (?,?)";
		Connection connection = DbUtil.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, account.getName());
		statement.setString(2, account.getPassword());
		statement.execute();
	} 
	
	
	public List<Account> findAll() throws SQLException {
		List<Account> list = new ArrayList<>();
		String sql = "select id, name, password from wuan";
		Connection connection = DbUtil.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		DbUtil.close(connection, statement, resultSet);
		return null;
	}
	

	public Account login(Account account) throws SQLException {
		System.out.println(account);
		String sql = "select name, password,id from wuan where name=?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement statement  = connection.prepareStatement(sql);
		statement.setString(1, account.getName());
//		statement.setString(2, account.getPassword());
		
		ResultSet rs = statement.executeQuery();
		
		
		Account a = null;
		if (rs.next()) {
			a = new Account();
			a.setName(rs.getString(1));
			a.setPassword(rs.getString(2));
			a.setId(rs.getInt(3));
		}
		return a;
	}
	
}
