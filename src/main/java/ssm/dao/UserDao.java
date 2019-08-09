package ssm.dao;

import ssm.pojos.user.User;

public interface UserDao {
	public User login(Integer ID);

	public void sign(User user);
}
