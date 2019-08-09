package ssm.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import ssm.dao.AdminDao;
import ssm.pojos.product.Product;
import ssm.pojos.user.User;

@Controller
@RequestMapping("/ssm")
public class AdminCtrl {

	@Autowired
	private AdminDao adminDao;

	@ResponseBody
	@RequestMapping(value = "/admin/adminUser", method = RequestMethod.POST)
	public String adminUser() {
		System.out.println("admin user");
		List<User> users = adminDao.getUser();
		if (users.size() == 0) {
			System.out
					.println("products--------<<<<>>>>>" + JSON.toJSONString(users) + "/" + JSON.toJSONString("false"));
			return "false";
		}
		return JSON.toJSONString(users);
	}

	@ResponseBody
	@RequestMapping(value = "/admin/adminProduct", method = RequestMethod.POST)
	public String admnProduct() {
		List<Product> products = adminDao.getProduct();
		if (products.size() == 0) {
			System.out.println(
					"products--------<<<<>>>>>" + JSON.toJSONString(products) + "/" + JSON.toJSONString("false"));
			return "false";
		}
		return JSON.toJSONString(products);
	}
}
