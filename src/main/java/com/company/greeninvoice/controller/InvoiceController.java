/**
 * 
 */
package com.company.greeninvoice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.company.greeninvoice.service.InvoiceService;

/**
 * @author Venkatraman
 *
 */
@Controller
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;
	
	public void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService=invoiceService;
	}
	
	
    @RequestMapping("/invoice/add")
    public ModelAndView addInvoice(){
    	Map<String,Object> businessDataMap=new HashMap<>();
	    ModelAndView modelAndView=new ModelAndView();
	    String invoiceNumber = invoiceService.generateInvoiceNumber();
	    businessDataMap.put("invoiceNumber", invoiceNumber);
	    modelAndView.addAllObjects(businessDataMap);
	    modelAndView.setViewName("add_invoice");
	    return modelAndView;
    }
//    public ModelAndView addProducts(){
//	    ModelAndView modelAndView=new ModelAndView();
//	    User user = new User();
//	    user.setName("VenkatRaman");
//	    user.setId(2154);
//	    user.setProfileImage("avatar.png");
//	    modelAndView.addObject(user);
//	    modelAndView.setViewName("add_product");
//	    return modelAndView;
//    }
    
}
