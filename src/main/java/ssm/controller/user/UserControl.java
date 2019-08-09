package ssm.controller.user;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.dao.UserDao;
import ssm.pojos.user.User;

@Controller
@RequestMapping("/ssm")
public class UserControl {
	private static Logger log = LoggerFactory.getLogger(UserControl.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private HttpSession session;

	@ResponseBody
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public String login(String Id, String password) {
		log.debug("login sign:" + Id + password);
		System.out.println("user login");
		Integer ID = Integer.parseInt(Id);
		User user = userDao.login(ID);
		if (user.getID() == ID && user.getPassword().equals(password)) {
			session.getServletContext().setAttribute("user", user);
			System.out.println(user.toString());
			return "success";
		}
		return "false";
	}

	@ResponseBody
	@RequestMapping(value = "/user/sign", method = RequestMethod.POST)
	public String sign(String Id, String name, String password) {
		log.debug("sign:" + Id + name + password);
		System.out.println("controller sign");
		Integer ID = Integer.parseInt(Id);
		User user = new User();
		user.setID(ID);
		user.setName(name);
		user.setPassword(password);
		// insert to mysql
		userDao.sign(user);

		return "succ";
	}

	@ResponseBody
	@RequestMapping(value = "/user/logout", method = RequestMethod.POST)
	public String logout() {
		System.out.println("logout");
		session.getServletContext().removeAttribute("user");
		return "succ";
	}
}
