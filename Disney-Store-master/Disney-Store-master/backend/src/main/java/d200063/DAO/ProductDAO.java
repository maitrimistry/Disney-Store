package d200063.DAO;

import java.util.List;

import d200063.model.Product;


public interface ProductDAO {
	
	public List<Product> getProductList();
	
	public boolean createProduct(Product product);
		
    public Product getProductById(int productId);
	
	public boolean updateProduct(Product product);
		
	public boolean deleteProduct(Product product);
		
	public List<Product> getProductListByPrice(int price);
		
	public List<Product> getProductListByName(String productname);
	
	

}
