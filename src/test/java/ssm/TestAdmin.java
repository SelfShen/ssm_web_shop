package ssm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ssm.controller.admin.AdminControl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "/spring-mybatis.xml")
public class TestAdmin {

	@Autowired
	private AdminControl adminCtrl;

	@Test
	public void login() {
		System.out.println("admnin login");
		String result = adminCtrl.login(0, "00000");
		System.out.println(result);
	}

	// @Test
	public void sign() {
		System.out.println("admnin sign");
		String result = adminCtrl.sign("1", "11111");
		System.out.println(result);
	}

}
