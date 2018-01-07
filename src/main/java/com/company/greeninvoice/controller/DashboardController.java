/**
 * 
 */
package com.company.greeninvoice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.company.greeninvoice.entity.User;

/**
 * @author Venkatraman
 *
 */
@Controller
public class DashboardController {

    @RequestMapping("/dashboard/index")
	public ModelAndView home(){
	    User user = new User();
	    user.setName("VenkatRaman");
	    user.setId(2154);
	    user.setProfileImage("avatar.png");
	    ModelAndView index=new ModelAndView();
	    index.setViewName("index");
	    index.addObject(user);
	    return index;
		
	}
}
