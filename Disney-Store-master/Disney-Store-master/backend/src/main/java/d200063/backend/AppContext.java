package d200063.backend;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


	@Configuration
	@ComponentScan(basePackages = "d200063")
	@EnableTransactionManagement
	public class AppContext {
		 
		@Bean(name="dataSource")
		@Autowired
		public DataSource dataSource() {
		    System.out.println("Data Source created");
			DriverManagerDataSource dataSource=new DriverManagerDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/project");
			dataSource.setUsername("sa");
			dataSource.setPassword("1234");
			System.out.println("Data Source passed");
			return dataSource;
		
		}
		
public Properties getHibernateProperties() {
	    System.out.println("Properties created");
	    Properties properties=new Properties();
	    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    properties.setProperty("hibernate.show_sql","true");
	    properties.setProperty("hibernate.hbm2ddl.auto", "update");
	    System.out.println("Properties passed");
	         return properties;
	         
	    }
		@Bean(name="sessionFactory")
		@Autowired
		public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
			    System.out.println("Session created");
				LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
				sessionFactory.setDataSource(dataSource);
				sessionFactory.setHibernateProperties(getHibernateProperties());
				sessionFactory.setPackagesToScan("d200063");
				System.out.println("Session passed");
				
				return sessionFactory;
	}
	
	@Bean(name="transactionManager")
	@Autowired
	public HibernateTransactionManager getTransactionMnager(SessionFactory sessionFactory) {
		    System.out.println("Transaction Manager created");
			HibernateTransactionManager transactionManager=new HibernateTransactionManager();
			transactionManager.setSessionFactory(sessionFactory);
			System.out.println("Transaction Manager passed");
			
			 		return transactionManager;
	}
	}
