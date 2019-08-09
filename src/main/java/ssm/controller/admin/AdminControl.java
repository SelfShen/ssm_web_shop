package ssm.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.dao.AdminDao;
import ssm.pojos.admin.Admin;

@Controller
@RequestMapping("/ssm")
public class AdminControl {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private HttpSession session;

	@ResponseBody
	@RequestMapping(value = "/admin/adminLogin", method = RequestMethod.POST)
	public String login(int id, String password) {
		System.out.println("admin login:" + id + "-" + password);
		Admin admin = adminDao.login(id);
		if (admin.getId() == id && admin.getPassword().equals(password)) {
			session.getServletContext().setAttribute("admin", admin);
			return "success";
		}
		return "false";
	}

	@ResponseBody
	@RequestMapping(value = "/admin/adminSign", method = RequestMethod.POST)
	public String sign(String name, String password) {
		System.out.println("admin sign:" + name + "-" + password);
		int id = 1;
		Admin admin = new Admin(id, name, password);
		adminDao.sign(admin);
		return "success";
	}

	@ResponseBody
	@RequestMapping(value = "/admin/admin_out", method = RequestMethod.POST)
	public String logout() {
		System.out.println("admin out");
		session.getServletContext().removeAttribute("admin");
		return "success";
	}
}
