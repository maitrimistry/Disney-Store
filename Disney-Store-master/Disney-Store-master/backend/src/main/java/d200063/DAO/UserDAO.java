package d200063.DAO;

import java.util.List;

import d200063.model.User;


public interface UserDAO {
	
	public List<User> getUserList();
	
	public boolean createUser(User user);
		
    public User getUserById(String userId);
	
	public boolean updateUser(User user);
		
	public boolean deleteUser(User user);
		
	public List<User> getUserListByName(String username);
		
	public User authUser(String userId,String password);
}
