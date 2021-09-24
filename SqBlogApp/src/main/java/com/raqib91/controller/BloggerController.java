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
import com.raqib91.dao.BloggerDAO;
import com.raqib91.entity.Blog;
import com.raqib91.entity.Blogger;
import com.raqib91.entity.Login;
import com.raqib91.service.ApplicationContextService;

@RestController
@RequestMapping("/blogger")
public class BloggerController {

	@Autowired
	ApplicationContextService context;

	@GetMapping("/Signup")
	public ModelAndView callBS() {
		return new ModelAndView("bloggerCreationPage");
	}

	@GetMapping("/Login")
	public ModelAndView callBL() {
		return new ModelAndView("bloggerLoginPage");
	}

	@GetMapping("/Dashboard")
	public ModelAndView callBD() {
		AdminDAO ad = context.getContext().getBean("adminDao", AdminDAO.class);
		ModelAndView mv = new ModelAndView();
		mv.addObject("b", ad.getApprovedBlogs());
		((AbstractApplicationContext) context.getContext()).close();
		mv.setViewName("bloggerDashboard");
		return mv;
	}

	@GetMapping("/blogCreation")
	public ModelAndView callBC() {
		return new ModelAndView("blogCreationPage");
	}

	@PostMapping("/createBlogger")
	public void createNewBlogger(@ModelAttribute Blogger b, HttpServletResponse res) throws IOException {
		BloggerDAO bd = context.getContext().getBean("bloggerDao", BloggerDAO.class);
		bd.CreateBlogger(b);
		((AbstractApplicationContext) context.getContext()).close();
		res.sendRedirect("Login");
	}

	@PostMapping("/bloggerLogin")
	public void loginA(@ModelAttribute Login l, HttpServletRequest req, HttpServletResponse res) throws IOException {
		Boolean isAllowed = false;
		long id = -1;
		if ((l.getUsername() != null) && (l.getPassword() != null)) {
			AdminDAO ad = context.getContext().getBean("adminDao", AdminDAO.class);
			for (Blogger b : ad.getApprovedBloggers()) {
				if ((l.getUsername().equals(b.getBloggerUsername()))
						&& (l.getPassword().equals(b.getBloggerPassword()))) {
					id = b.getBloggerId();
					isAllowed = true;
					break;
				}
			}
		}

		if (isAllowed == true && id != -1) {
			HttpSession session = req.getSession();
			session.setAttribute("bloggerUsername", l.getUsername());
			session.setAttribute("bloggerId", id);
			res.sendRedirect("Dashboard");
		} else
			res.sendRedirect("Login");
	}

	@PostMapping("/bloggerLogout")
	public void logoutA(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("bloggerUsername");
//		session.removeAttribute("bloggerId");
		res.sendRedirect("Login");
	}

	@PostMapping("/createBlog")
	public void createNewBlog(@RequestParam("blogTitle") String title, @RequestParam("blogContent") String content,
			@RequestParam("blogStatus") String status, @RequestParam("bloggerId") long id, HttpServletResponse res)
			throws IOException {
		Blog b = new Blog();
		b.setBlogTitle(title);
		b.setBlogContent(content);
		b.setBlogStatus(status);
		BloggerDAO bd = context.getContext().getBean("bloggerDao", BloggerDAO.class);
		bd.createBlog(b, id);
		((AbstractApplicationContext) context.getContext()).close();
		res.sendRedirect("Dashboard");
	}

	@GetMapping("/Pending_Blogs")
	public ModelAndView showPBlog(HttpServletRequest req) {
		BloggerDAO bd = context.getContext().getBean("bloggerDao", BloggerDAO.class);
		HttpSession session = req.getSession();
		long bloggerId = (long) session.getAttribute("bloggerId");
		ModelAndView mv = new ModelAndView();
		mv.addObject("b", bd.getPendingBlogs(bloggerId));
		((AbstractApplicationContext) context.getContext()).close();
		mv.setViewName("pendingBlogs");
		return mv;
	}

	@GetMapping("/Approved_Blogs")
	public ModelAndView showABlog(HttpServletRequest req) {
		BloggerDAO bd = context.getContext().getBean("bloggerDao", BloggerDAO.class);
		HttpSession session = req.getSession();
		long bloggerId = (long) session.getAttribute("bloggerId");
		ModelAndView mv = new ModelAndView();
		mv.addObject("b", bd.getApprovedBlogs(bloggerId));
		((AbstractApplicationContext) context.getContext()).close();
		mv.setViewName("approvedBlogs");
		return mv;
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
