package service.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;

import entity.Users;
import service.UsersDAO;

public class UsersDAOImpl implements UsersDAO{

	@Override
	public boolean usersLogin(Users u) {
		Transaction tx = null;
		String hql = "";
		
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Users where username=? and password=?";
			Query query = session.createQuery(hql);
			System.out.println("UserDAO中的login："+u.getUsername());
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list = query.list();
			tx.commit();
			if(list.size()>0) {
				System.out.println("UserDAO中的login：成功");
				return true;
			}else {
				System.out.println("UserDAO中的login：失败");
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if(tx!=null) {
				tx = null;
			}
		}
	}
	
}
