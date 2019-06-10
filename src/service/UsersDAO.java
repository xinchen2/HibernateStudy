package service;

import entity.Users;

//业务逻辑接口
public interface UsersDAO {
	
	//用户登录方法
	public boolean usersLogin(Users u);
	
}
