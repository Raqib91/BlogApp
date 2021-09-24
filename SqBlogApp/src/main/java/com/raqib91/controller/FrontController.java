package com.raqib91.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.raqib91.dao.AdminDAO;
import com.raqib91.service.ApplicationContextService;

@RestController
public class FrontController {

	@Autowired
	ApplicationContextService context;

	@GetMapping("/")
	public ModelAndView callPD() {
		AdminDAO ad = context.getContext().getBean("adminDao", AdminDAO.class);
		ModelAndView mv = new ModelAndView();
		mv.addObject("b", ad.getApprovedBlogs());
		((AbstractApplicationContext) context.getContext()).close();
		mv.setViewName("publicDashboard");
		return mv;
	}

}
