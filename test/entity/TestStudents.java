package entity;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestStudents {
	@Test
	public void testSchemaExport() {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		SchemaExport export= new SchemaExport(config);
		
		export.create(true, true);
	}
    
	@Test
	public void testSaveStudents() {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		//getCurrentSession,无需显示关闭session对象
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Students s1 = new Students("s0000001","张三丰","男",new Date(),"武当山");
		Students s2 = new Students("s0000002","郭靖","男",new Date(),"桃花岛");
		Students s3 = new Students("s0000003","黄蓉","女",new Date(),"桃花岛");
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		tx.commit();
		sessionFactory.close();
	}
	
}
