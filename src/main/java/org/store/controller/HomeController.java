package org.store.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.store.domain.Product;
import org.store.service.ProductService;

/**
 * Simple little @Controller that invokes Facebook and renders the result.
 * The injected {@link Facebook} reference is configured with the required authorization credentials for the current user behind the scenes.
 * @author Keith Donald
 */
@Controller
@RequestMapping("/home")
public class HomeController {

	private Facebook facebook;
	private ConnectionRepository connectionRepository;
	
	@Autowired
	private ProductService productService;

    @Inject
    public HomeController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
		this.connectionRepository = connectionRepository;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String helloFacebook(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/loginPage";
        }

        model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
        String email = facebook.userOperations().getUserProfile().getEmail();
        String firstName = facebook.userOperations().getUserProfile().getFirstName();
        String id = facebook.userOperations().getUserProfile().getId();
        
        System.out.println("email : " + email + ", firstName :" + firstName + ", id: " + id);
        PagedList<Post> feed = facebook.feedOperations().getFeed();
        model.addAttribute("feed", feed);
        
        List<Product> productList = productService.getProductList();
        model.addAttribute("products", productList);
        return "home";
    }

}
