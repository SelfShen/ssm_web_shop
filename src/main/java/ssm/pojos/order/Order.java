package ssm.pojos.order;

public class Order {
	private int Id;
	private int order_no;
	private int shop_id;
	private int order_status;
	private int product_count;
	private double product_total;
	private double order_total;
	private String order_create_time;
	private String order_settle_time;

	public Order() {

	}

	public Order(int id, int order_no, int shop_id, int order_status, int product_count, Double product_total,
			Double order_total, String order_create_time, String order_settle_time) {
		super();
		Id = id;
		this.order_no = order_no;
		this.shop_id = shop_id;
		this.order_status = order_status;
		this.product_count = product_count;
		this.product_total = product_total;
		this.order_total = order_total;
		this.order_create_time = order_create_time;
		this.order_settle_time = order_settle_time;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public int getShop_id() {
		return shop_id;
	}

	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}

	public int getOrder_status() {
		return order_status;
	}

	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}

	public int getProduct_count() {
		return product_count;
	}

	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}

	public Double getProduct_total() {
		return product_total;
	}

	public void setProduct_total(Double product_total) {
		this.product_total = product_total;
	}

	public Double getOrder_total() {
		return order_total;
	}

	public void setOrder_total(Double order_total) {
		this.order_total = order_total;
	}

	public String getOrder_create_time() {
		return order_create_time;
	}

	public void setOrder_create_time(String order_create_time) {
		this.order_create_time = order_create_time;
	}

	public String getOrder_settle_time() {
		return order_settle_time;
	}

	public void setOrder_settle_time(String order_settle_time) {
		this.order_settle_time = order_settle_time;
	}

}
