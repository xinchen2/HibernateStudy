package service.impl;

import junit.framework.Assert;

import org.junit.Test;

import entity.Users;
import service.UsersDAO;

public class TestUsersDAOImpl {
	@Test
	public void testUsersLogin() {
		Users u = new Users(1,"zhangsan","123456");
		UsersDAO udao = new UsersDAOImpl();
		Assert.assertEquals(true, udao.usersLogin(u));
	}
}
