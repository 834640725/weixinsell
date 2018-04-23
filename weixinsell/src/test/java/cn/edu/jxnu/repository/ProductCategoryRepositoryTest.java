package cn.edu.jxnu.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.jxnu.dataobject.ProductCategory;
import cn.edu.jxnu.repository.ProductCategoryRepository;

import java.util.Arrays;
import java.util.List;


/**
 * 商品类目测试
 * @author 梦境迷离
 * @version V1.0
 * @time.	2018年4月13日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

	@Autowired
	private ProductCategoryRepository repository;

	@Test
	public void findOneTest() {
		ProductCategory productCategory = repository.findOne(1);
		System.out.println(productCategory.toString());
	}

	@Test
	@Transactional
	public void saveTest() {
		ProductCategory productCategory = new ProductCategory("男生最爱", 4);
		ProductCategory result = repository.save(productCategory);
		Assert.assertNotNull(result);
		// Assert.assertNotEquals(null, result);
	}

	@Test
	public void findByCategoryTypeInTest() {
		List<Integer> list = Arrays.asList(2, 3, 4);

		List<ProductCategory> result = repository.findByCategoryTypeIn(list);
		Assert.assertNotEquals(0, result.size());
	}

	@Test
	public void updateTest() {
		// ProductCategory productCategory = repository.findOne(4);
		// productCategory.setCategoryName("男生最爱1");
		ProductCategory productCategory = new ProductCategory("男生最爱", 4);
		ProductCategory result = repository.save(productCategory);
		Assert.assertEquals(productCategory, result);
	}
}