package ssm.controller.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import ssm.controller.product.ProductControl;
import ssm.dao.OrderDao;
import ssm.dao.ProductDao;
import ssm.pojos.order.Order;

@Controller
@RequestMapping("/ssm")
public class OrderControl {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ProductControl proCtrl;

	@ResponseBody
	@RequestMapping(value = "/source/addOrder", method = RequestMethod.POST)
	public String addOrder(int order_no, int shop_id, int order_status, int product_count) {
		System.out.println("admin order" + order_no + "-" + shop_id + "-" + product_count);

		Date date = new Date();
		SimpleDateFormat simDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String order_create_time = simDate.format(date);
		String order_settle_time = simDate.format(date);

		String pro = proCtrl.queryById(order_no);
		JSONObject json = JSONObject.parseObject(pro);
		System.out.println("product:" + json.getByteValue("number"));

		int a = json.getByteValue("iD");
		int num = json.getByteValue("number") - product_count;
		System.out.println(num);

		if (productDao.changeNumByProId(a, num)) {
			System.out.println("success upedate mysql");
			double product_total = product_count;
			double order_total = product_count;

			Order order = new Order(0, order_no, shop_id, order_status, product_count, product_total, order_total,
					order_create_time, order_settle_time);
			System.out.println(order_no + "-" + shop_id + "-" + order_status + "-" + product_count + "-" + product_total
					+ "-" + order_total + "-" + order_create_time + "-" + order_settle_time);
			orderDao.add(order);
		}

		return "success";
	}

	@ResponseBody
	@RequestMapping(value = "/source/queryOrder", method = RequestMethod.POST)
	public String queryOrder() {
		System.out.println("admin query order");
		List<Order> orders = orderDao.query();
		System.out.println(JSON.toJSONString(orders));
		return JSON.toJSONString(orders);
	}
}
