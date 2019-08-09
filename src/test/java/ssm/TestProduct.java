package ssm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ssm.controller.product.ProductControl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "/spring-mybatis.xml")
public class TestProduct {

	@Autowired
	private ProductControl proCtrl;

	// @Test
	public void add() {
		String result = proCtrl.add("jeans", 200.2, 10, 2, null);
		System.out.println(result);
	}

	// @Test
	public void query() {
		String result = proCtrl.query();
		System.out.println(result);
	}

	// @Test
	public void queryBySort() {
		String result = proCtrl.queryBySort(0);
		System.out.println(result);
	}

	@Test
	public void queryById() {
		String result = proCtrl.queryById(8);
		System.out.println(result);
	}

}
