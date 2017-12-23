package com.smj.mapper;

import org.apache.ibatis.annotations.Insert;

import com.smj.domain.Account;

public interface AccountMapper {

	/**
	 * 创建账号
	 * @param account
	 */
	@Insert("insert into wuan(name, password) values(#{name},#{password})")
	void create(Account account);
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	@Insert("select * from wuan where name = #{user}")
	Account login(String user);
	
	/**
	 * 检查用户名是否存在
	 * @param name
	 * @return
	 */
	@Insert("select password from wuan where name=#{name}")
	String CheckName(String name);
		
}
