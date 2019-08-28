package d200063.backend;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import d200063.DAO.ProductDAO;
import d200063.model.Product;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppContext.class)

public class ProductTest {
	
	
	@Autowired
	ProductDAO productDAO;
	
	@Before
	public void setup() throws Exception {
	}
	
	@After
	public void teardown() throws Exception{
	}
	
	@Test
	public void createProduct() {
		Product product = new Product();
		product.setProductname("Mickey");
		product.setPrice(1000);
		product.setProductdescription("Mickey is soft toy");
		product.setQuantity(100);
	
		assertEquals(true,productDAO.createProduct(product));
		
	}
	
	@Test
	public void updateProduct() {
		Product product = productDAO.getProductById(6);
		product.setPrice(100);
		product.setProductdescription("It is pure cotton T-shirt");
		product.setProductname("Mini Mouse");
		product.setQuantity(50);
		
	
		assertEquals(true, productDAO.updateProduct(product));
	}
	
	
	public void deleteProduct() {
		Product product = productDAO.getProductById(7);
		assertEquals(true,productDAO.deleteProduct(product));
		
	}

}
