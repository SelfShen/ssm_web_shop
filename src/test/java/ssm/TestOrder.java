package ssm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ssm.controller.order.OrderControl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "/spring-mybatis.xml")
public class TestOrder {

	@Autowired
	private OrderControl order;

	@Autowired
	MockHttpSession session;

	@Test
	public void add() {
		String result = order.addOrder(8, 1002, 1, 1);
		System.out.println(result);
	}

	// @Test
	public void query() {
		String result = order.queryOrder();
		System.out.println(result);
	}

}
