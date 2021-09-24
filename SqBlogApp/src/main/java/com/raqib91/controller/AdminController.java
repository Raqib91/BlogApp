package com.raqib91.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.raqib91.dao.AdminDAO;
import com.raqib91.entity.Admin;
import com.raqib91.entity.Login;
import com.raqib91.service.ApplicationContextService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ApplicationContextService context;

	@GetMapping("/Login")
	public ModelAndView callAL() {
		return new ModelAndView("adminLoginPage");
	}

	@GetMapping("/Dashboard")
	public ModelAndView callAD() {
		return new ModelAndView("adminDashboard");
	}

	@GetMapping("/create")
	public ModelAndView callACP() {
		return new ModelAndView("adminCreationPage");
	}

	@PostMapping("/adminLogin")
	public void loginA(@ModelAttribute Login l, HttpServletRequest req, HttpServletResponse res) throws IOException {
		Boolean isAllowed = false;
		if ((l.getUsername() != null) && (l.getPassword() != null)) {
			if ((l.getUsername().equals("super")) && (l.getPassword().equals("1234"))) {
				isAllowed = true;
			} else {
				AdminDAO ad = context.getContext().getBean("adminDao", AdminDAO.class);
				for (Admin a : ad.getAllAdmin()) {
					if ((l.getUsername().equals(a.getAdminUsername()))
							&& (l.getPassword().equals(a.getAdminPassword()))) {
						isAllowed = true;
						break;
					}
				}
			}
		}

		if (isAllowed == true) {
			HttpSession session = req.getSession();
			session.setAttribute("adminUsername", l.getUsername());
			res.sendRedirect("Dashboard");
		} else
			res.sendRedirect("Login");
	}

	@PostMapping("/adminLogout")
	public void logoutA(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("adminUsername");
		res.sendRedirect("Login");
	}

	@PostMapping("/createAdmin")
	public void createA(@ModelAttribute Admin a, HttpServletResponse res) throws IOException {
		AdminDAO ad = context.getContext().getBean("adminDao", AdminDAO.class);
		ad.createAdmin(a);
		((AbstractApplicationContext) context.getContext()).close();
		res.sendRedirect("all");
	}

	@GetMapping("/all")
	public ModelAndView showAA() {
		AdminDAO ad = context.getContext().getBean("adminDao", AdminDAO.class);
		ModelAndView mv = new ModelAndView();
		mv.addObject("a", ad.getAllAdmin());
		((AbstractApplicationContext) context.getContext()).close();
		mv.setViewName("showAdmin");
		return mv;
	}

	@GetMapping("/Pending_Bloggers")
	public ModelAndView showPB() {
		AdminDAO ad = context.getContext().getBean("adminDao", AdminDAO.class);
		ModelAndView mv = new ModelAndView();
		mv.addObject("b", ad.getPendingBloggers());
		((AbstractApplicationContext) context.getContext()).close();
		mv.setViewName("showPendingBloggers");
		return mv;
	}

	@GetMapping("/Approved_Bloggers")
	public ModelAndView showAB() {
		AdminDAO ad = context.getContext().getBean("adminDao", AdminDAO.class);
		ModelAndView mv = new ModelAndView();
		mv.addObject("b", ad.getApprovedBloggers());
		((AbstractApplicationContext) context.getContext()).close();
		mv.setViewName("showApprovedBloggers");
		return mv;
	}

	@PostMapping("/approveBlogger")
	public void approvePB(@RequestParam("bloggerId") long bloggerId, HttpServletResponse res) throws IOException {
		AdminDAO ad = context.getContext().getBean("adminDao", AdminDAO.class);
		ad.approvePendingBlogger(bloggerId);
		((AbstractApplicationContext) context.getContext()).close();
		res.sendRedirect("Pending_Bloggers");
	}

	@PostMapping("/deactivateBlogger")
	public void deactivateAB(@RequestParam("bloggerId") long bloggerId, HttpServletResponse res) throws IOException {
		AdminDAO ad = context.getContext().getBean("adminDao", AdminDAO.class);
		ad.deactivateApprovedBlogger(bloggerId);
		((AbstractApplicationContext) context.getContext()).close();
		res.sendRedirect("Approved_Bloggers");
	}

	@PostMapping("/deletePendingBlogger")
	public void deletePB(@RequestParam("bloggerId") long bloggerId, HttpServletResponse res) throws IOException {
		AdminDAO ad = context.getContext().getBean("adminDao", AdminDAO.class);
		ad.deleteBlogger(bloggerId);
		((AbstractApplicationContext) context.getContext()).close();
		res.sendRedirect("Pending_Bloggers");
	}

	@PostMapping("/deleteApprovedBlogger")
	public void deleteAB(@RequestParam("bloggerId") long bloggerId, HttpServletResponse res) throws IOException {
		AdminDAO ad = context.getContext().getBean("adminDao", AdminDAO.class);
		ad.deleteBlogger(bloggerId);
		((AbstractApplicationContext) context.getContext()).close();
		res.sendRedirect("Approved_Bloggers");
	}

	@GetMapping("/Pending_Blogs")
	public ModelAndView showPBlog() {
		AdminDAO ad = context.getContext().getBean("adminDao", AdminDAO.class);
		ModelAndView mv = new ModelAndView();
		mv.addObject("b", ad.getPendingBlogs());
		((AbstractApplicationContext) context.getContext()).close();
		mv.setViewName("showPendingBlogs");
		return mv;
	}

	@GetMapping("/Approved_Blogs")
	public ModelAndView showABlog() {
		AdminDAO ad = context.getContext().getBean("adminDao", AdminDAO.class);
		ModelAndView mv = new ModelAndView();
		mv.addObject("b", ad.getApprovedBlogs());
		((AbstractApplicationContext) context.getContext()).close();
		mv.setViewName("showApprovedBlogs");
		return mv;
	}

	@PostMapping("/approveBlog")
	public void approvePBlog(@RequestParam("blogId") long blogId, HttpServletResponse res) throws IOException {
		AdminDAO ad = context.getContext().getBean("adminDao", AdminDAO.class);
		ad.approvePendingBlog(blogId);
		((AbstractApplicationContext) context.getContext()).close();
		res.sendRedirect("Pending_Blogs");
	}

	@PostMapping("/deletePendingBlog")
	public void deletePBlog(@RequestParam("blogId") long blogId, HttpServletResponse res) throws IOException {
		AdminDAO ad = context.getContext().getBean("adminDao", AdminDAO.class);
		ad.deleteBlog(blogId);
		((AbstractApplicationContext) context.getContext()).close();
		res.sendRedirect("Pending_Blogs");
	}

	@PostMapping("/deleteApprovedBlog")
	public void deleteABlog(@RequestParam("blogId") long blogId, HttpServletResponse res) throws IOException {
		AdminDAO ad = context.getContext().getBean("adminDao", AdminDAO.class);
		ad.deleteBlog(blogId);
		((AbstractApplicationContext) context.getContext()).close();
		res.sendRedirect("Approved_Blogs");
	}

}
