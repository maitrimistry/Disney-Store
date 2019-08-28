package d200063.backend;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import d200063.DAO.OrderDAO;
import d200063.model.Order;
import d200063.model.User;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppContext.class)

public class OrderTest {
	
	@Autowired
	OrderDAO orderDAO;
	
	@Before
	public void setup()	 throws Exception {
	}
	
	@After
	public void teardown() throws Exception{
	}
	@Test
	public void createOrder() {
		Order order = new Order();
		order.setOrderdesc("Your order contains 5 items");
		order.setOrderprice(5000); 
		order.setOrderstat("Dispatched");
        
		User u = new User();
		u.setUserId(1);
	order.setUserId(u);
		
		assertEquals(true,orderDAO.createOrder(order));
	}
	

}
