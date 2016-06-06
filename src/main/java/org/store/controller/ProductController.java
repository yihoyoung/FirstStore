package org.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.store.domain.Product;
import org.store.repository.ProductRepository;
import org.store.service.ProductService;

import java.util.List;

/**
 * Created by hoyounglee on 2016. 6. 5..
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("menu")
    public ModelAndView menuForm(){
        ModelAndView view = new ModelAndView();
        List<Product> productList = productService.getProductList();
        view.addObject("products", productList);
        view.setViewName("menu");
        return view;
    }
}
