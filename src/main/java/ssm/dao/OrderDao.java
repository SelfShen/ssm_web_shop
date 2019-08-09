package ssm.dao;

import java.util.List;

import ssm.pojos.order.Order;

public interface OrderDao {

	public void add(Order order);

	public List<Order> query();

	public void edit();
}
