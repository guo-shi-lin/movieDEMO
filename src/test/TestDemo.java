package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.movie.dao.impl.UserDAOImpl;

public class TestDemo {
    private SessionFactory sessionFactory;
    private Session session;
    private UserDAOImpl userDAOImpl;
	@Before
	public void init(){
		Configuration cfg = new Configuration();
		cfg.configure("spring-*.xml");
		sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
	}
	@Test
	public void test1(){
		userDAOImpl = new UserDAOImpl();
		session = sessionFactory.openSession();
		
	}
	@After
	public void destory(){
		sessionFactory.close();
	}
}
