package com.data;

import com.data.domain.Category;
import com.data.domain.Product;
import com.data.integration.RabbitMessagePublisher;
import com.data.repository.ProductRepository;
import com.data.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class DataApplicationTests {

	@MockBean
	private RabbitMessagePublisher rabbitMessagePublisher;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
		Mockito.doNothing().when(rabbitMessagePublisher).sendMessageToSearch(any());
		Product product=new Product();
		product.setData("test");
		Category category=new Category();
		product.setCategory(category);
		productService.saveProduct(product);
		assertNotNull(productRepository.findById(1l).get());
	}

}
