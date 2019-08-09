package ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ssm.pojos.product.Product;

public interface ProductDao {
	public void add(Product product);

	public List<Product> query();

	public List<Product> queryBySort(int sort);

	public Product queryById(int id);

	public boolean changeNumByProId(@Param("proId") int proId, @Param("num") int num);
}
