package ssm.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ssm")
public class ViewControl {

	private int productId;

	@RequestMapping(value = "/home")
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/admin/login")
	public String adminLogin() {
		return "admin_login";
	}

	@RequestMapping(value = "/admin/home")
	public String admnin() {
		return "admin";
	}

	@RequestMapping(value = "/detail")
	public String detail(int id) {
		productId = id;
		System.out.println("set product id" + id);
		return "detail";
	}

	@ResponseBody
	@RequestMapping(value = "/getProId", method = RequestMethod.POST)
	public int getProId() {
		return productId;
	}
}
