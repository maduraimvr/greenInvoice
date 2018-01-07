/**
 * 
 */
package com.company.greeninvoice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.company.greeninvoice.entity.Product;
import com.company.greeninvoice.entity.User;

/**
 * @author Venkatraman
 *
 */
@Controller
public class ProductController {

    @RequestMapping("/products/add")
    public ModelAndView addProducts(){
	    ModelAndView modelAndView=new ModelAndView();
	    User user = new User();
	    user.setName("VenkatRaman");
	    user.setId(2154);
	    user.setProfileImage("avatar.png");
	    modelAndView.addObject(user);
	    modelAndView.setViewName("add_product");
	    return modelAndView;
    }
    
    @RequestMapping(value="/products/add/input", method=RequestMethod.POST,
            produces="application/json")
    public @ResponseBody Map<String,Object> getData(@RequestBody Product product){
	Map<String,Object> businessMap=new HashMap<>();
	businessMap.put("isSuccessful", true);
	businessMap.put("product", product);
	return businessMap;
    }
}
