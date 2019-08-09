package ssm.dao;

import java.util.List;

import ssm.pojos.admin.Admin;
import ssm.pojos.product.Product;
import ssm.pojos.user.User;

public interface AdminDao {
	public Admin login(int Id);

	public void sign(Admin admin);

	public List<User> getUser();

	public List<Product> getProduct();
}
