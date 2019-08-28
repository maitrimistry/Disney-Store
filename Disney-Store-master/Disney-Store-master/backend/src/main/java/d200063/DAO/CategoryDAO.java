package d200063.DAO;

import java.util.List;

import d200063.model.Category;

public interface CategoryDAO {

	public  List<Category>getCategoryByList();
	
	public boolean createCategory(Category category);
	
	public boolean updateCategory(Category category);
	
	public boolean deleteCategory(Category category);
	
	public Category getCategoryById(int CategoryId);
	
	public Category getCategoryByName(String Categoryname);
	
}
