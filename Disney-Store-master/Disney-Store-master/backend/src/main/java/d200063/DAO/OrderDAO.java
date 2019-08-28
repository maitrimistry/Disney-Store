package d200063.DAO;

import java.util.List;

import d200063.model.Order;

public interface OrderDAO {

	public List<Order>getOrderByList();
	
	public boolean createOrder(Order order);
	
	public boolean updateOrder(Order order);
	
	public boolean deleteOrder(Order order);
	
	public Order getOrderById(int orderId);

}
