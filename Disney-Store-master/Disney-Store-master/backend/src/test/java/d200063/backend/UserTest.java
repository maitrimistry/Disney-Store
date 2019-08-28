package d200063.backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import d200063.DAO.UserDAO;
import d200063.model.User;
@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=AppContext.class)
public class UserTest {
	
	@Autowired
	UserDAO userdao;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		userdao = null;	
	}
	
	@Test
	public void userListTest() {
	
		List<User>getUserList = userdao.getUserList();
		assertEquals(2, getUserList.size());
	}
    @Ignore
    @Test
    public void addUser() {
    	User user = new User();
    	user.setUsername("jake");
    	user.setPassword("fhhytr");
    	user.setPhone_number("145267890");
    	
    	assertEquals(true, userdao.createUser(user));			
    }
   
    @Ignore
    @Test(expected=IndexOutOfBoundsException.class)
    public void updateUser() {
    	User user = userdao.getUserById("2");
    	user.setPassword("12365");
    	
    	assertEquals(true, userdao.updateUser(user));    	
    }
    @Ignore
    @Test
    public void deleteUser() {
    	User user = userdao.getUserById("3");
    	assertEquals(true,userdao.deleteUser(user));
    }
    
}
   
   

