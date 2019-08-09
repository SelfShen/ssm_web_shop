package ssm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ssm.controller.user.UserControl;
import ssm.pojos.user.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "/spring-mybatis.xml")
public class TestUser {

	@Autowired
	private UserControl userControl;

	@Autowired
	private MockHttpSession session;

	@Test
	public void login() {
		System.out.println("login test");
		String result = userControl.login("1", "111111");
		User user = (User) session.getServletContext().getAttribute("user");
		System.out.println(user.getPassword());
		System.out.println(result);
	}

	// @Test
	public void sign() {
		System.out.println("sign test");
		String result = userControl.sign("2", "2", "222222");
		System.out.println(result);
	}

}
