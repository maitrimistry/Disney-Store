package d200063.backend;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import d200063.DAO.CategoryDAO;
import d200063.model.Category;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=AppContext.class)

public class CategoryTest {


	
	@Autowired
	CategoryDAO categorydao;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		categorydao = null;	
	}

   
    @Test
    public void createCategory() {
    	Category category = new Category();
    	category.setCategoryname("Discount");
    	category.setCategorydesc("For New Customer");
   
  
    	
    	assertEquals(true, categorydao.createCategory(category));
    	
    }
    
    }