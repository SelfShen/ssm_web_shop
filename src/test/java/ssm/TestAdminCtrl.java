package ssm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ssm.controller.admin.AdminCtrl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "/spring-mybatis.xml")
public class TestAdminCtrl {

	@Autowired
	private AdminCtrl admin;

	@Test
	public void getUser() {
		String result = admin.adminUser();
		System.out.println("admin user");
		System.out.println(result);
	}

	// @Test
	public void getProduct() {
		String result = admin.admnProduct();
		System.out.println(result);
	}

}
