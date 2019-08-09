package ssm.controller.product;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import ssm.dao.ProductDao;
import ssm.pojos.product.Product;

@Controller
@RequestMapping("/ssm")
public class ProductControl {

	@Autowired
	private ProductDao productDao;

	@ResponseBody
	@RequestMapping(value = "/source/addProduct", method = RequestMethod.POST)
	public String add(String name, Double price, Integer number, Integer sort, MultipartFile img) {
		// MultipartFile img;
		System.out.println("add product");

		System.out.println(img.getOriginalFilename());

		UUID uuid = UUID.randomUUID();
		String imgUUID = uuid.toString();
		imgUUID = imgUUID.replaceAll("-", "");
		int num = imgUUID.hashCode();
		num = num < 0 ? -num : num;
		imgUUID = String.valueOf(num);
		String imgName = null;
		try {
			String filePath = "F:\\Ps";
			imgName = imgUUID + ".jpg";
			File file = new File(filePath, imgName);
			img.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(name + "-" + price + "-" + number + "-" + sort + "-" + imgUUID);

		Product product = new Product(0, name, price, number, sort, imgUUID);

		productDao.add(product);
		return "success";
	}

	@ResponseBody
	@RequestMapping(value = "/source/queryProduct", method = RequestMethod.POST)
	public String query() {
		List<Product> products = productDao.query();
		for (Product pro : products) {
			File file = new File("F://Ps//" + pro.getImgUUID() + ".jpg");
			System.out.println(file.toURI());
			pro.setImg(file);
		}
		if (products.size() == 0) {
			System.out.println(
					"products--------<<<<>>>>>" + JSON.toJSONString(products) + "/" + JSON.toJSONString("false"));
			return "false";
		}
		return JSON.toJSONString(products);
	}

	@ResponseBody
	@RequestMapping(value = "/source/queryProductBySort", method = RequestMethod.POST)
	public String queryBySort(int sort) {
		List<Product> products = productDao.queryBySort(sort);
		if (products.size() == 0) {
			System.out.println(
					"products--------<<<<>>>>>" + JSON.toJSONString(products) + "/" + JSON.toJSONString("false"));
			return "false";
		}
		return JSON.toJSONString(products);
	}

	@ResponseBody
	@RequestMapping(value = "/source/queryProductById", method = RequestMethod.POST)
	public String queryById(int Id) {
		Product product = productDao.queryById(Id);
		if (Id == product.getID()) {
			System.out.println("success" + product.getName());
			return JSON.toJSONString(product);
		}
		return "false";
	}
}
