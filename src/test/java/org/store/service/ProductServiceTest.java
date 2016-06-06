package org.store.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.store.Application;
import org.store.domain.Product;
import org.store.repository.ProductRepository;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by hoyounglee on 2016. 6. 5..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class )
@WebAppConfiguration
@Transactional
public class ProductServiceTest {

    Product product;

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setUp(){
        String name = "Camera ABC";
        String price = "150000";
        String productType = "c";
        String imageUrl = "";
        product = new Product();
        product.setName(name);
    }

    @Test
    public void getProductList(){
        List<Product> products = (List<Product>) productRepository.findAll();
        assertNotNull(products);
    }
}
