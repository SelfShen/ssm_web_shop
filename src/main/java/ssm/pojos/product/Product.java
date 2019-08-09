package ssm.pojos.product;

import java.io.File;

public class Product {
	private int ID;
	private String name;
	private double price;
	private int number;
	private int sort;
	private File img;
	private String imgUUID;

	public Product() {

	}

	public Product(int iD, String name, double price, int number, int sort, String imgUUID) {
		super();
		ID = iD;
		this.name = name;
		this.price = price;
		this.number = number;
		this.sort = sort;
		this.imgUUID = imgUUID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImgUUID() {
		return imgUUID;
	}

	public void setImgUUID(String imgUUID) {
		this.imgUUID = imgUUID;
	}

}
