package d200063.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import d200063.DAO.ProductDAO;
import d200063.model.Product;

@Repository
@Transactional

public class ProductDAOImpl implements ProductDAO
{
	@Autowired(required = true)
	SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<Product> getProductList() {
		List<Product> getProductList = sessionFactory.getCurrentSession().createQuery("from Product").list();
		return getProductList;
	}

	public boolean createProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
		return true;
	}

	public boolean updateProduct(Product product) {
		sessionFactory.getCurrentSession().update(product);
		return true;
	}

	public boolean deleteProduct(Product product) {
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductListByPrice(int price) {
		
		return (List<Product>) sessionFactory.getCurrentSession().createQuery("from Product where price =" + price).list();
	
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductListByName(String productname) {
		
		return (List<Product>) sessionFactory.getCurrentSession().createQuery("from Product where productname like"+ "'%"+ productname + "'%'").list();
	}
	
	
	public Product getProductById(int productId) {
		Product product = (Product) sessionFactory.getCurrentSession().createQuery("from Product where productId = " + productId).uniqueResult();
		return product;
	}



}
