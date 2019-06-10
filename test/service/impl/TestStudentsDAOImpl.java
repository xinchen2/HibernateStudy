package service.impl;

import junit.framework.Assert;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import entity.Students;
import entity.Users;
import service.StudentsDAO;
import service.UsersDAO;

public class TestStudentsDAOImpl {
	@Test
	public void testUsersLogin() {
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void testGetNewSid() {
		System.out.println("before getId");
		StudentsDAOImpl sdao = new StudentsDAOImpl();
		System.out.println("sid:"+sdao.getNewSid());
	}
	
	@Test
	public void TestAddStudents() {
		Students s = new Students();
		s.setSname("济公");
		s.setGender("男");
		s.setBirthday(new Date());
		s.setAddress("灵隐寺");
		System.out.println("add Student");
		StudentsDAO sdao = new StudentsDAOImpl();
		Assert.assertEquals(true, sdao.addStudents(s));
	}
}
