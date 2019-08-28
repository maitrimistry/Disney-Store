package d200063.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import d200063.DAO.CategoryDAO;
import d200063.model.Category;


@Repository
@Transactional

public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired(required = true)
	 SessionFactory sessionfactory;
	
	public List<Category>getCategoryByList() {
		
		@SuppressWarnings("unchecked")
		List<Category>getCategoryByList = sessionfactory.getCurrentSession().createQuery("from Category").list();
		return getCategoryByList;
	}
	public boolean createCategory(Category category) {
		sessionfactory.getCurrentSession().save(category);
		return true;
	}
	public boolean updateCategory(Category category) {
		sessionfactory.getCurrentSession().update(category);
		return true;
	}

      
	public Category getCategoryById(int categoryId) {
		Category category =(Category) sessionfactory.getCurrentSession().createQuery("from Category where categoryId" + categoryId).uniqueResult();
	    return category;
	}
	
	
	public boolean deleteCategory(Category category) {
        sessionfactory.getCurrentSession().delete(category);
		return true;
	}
	public Category getCategoryByName(String Categoryname) {
		return (Category)sessionfactory.getCurrentSession().createQuery("from Category where categoryname like"+ "'%'").list();
	}

}
