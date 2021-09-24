package com.raqib91.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.raqib91.entity.Admin;
import com.raqib91.entity.Blog;
import com.raqib91.entity.Blogger;

public class AdminDAO {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public void createAdmin(Admin a) {
		hibernateTemplate.save(a);
	}

	public List<Admin> getAllAdmin() {
		List<Admin> a = (List<Admin>) hibernateTemplate.loadAll(Admin.class);
		return a;
	}

	public List<Blogger> getPendingBloggers() {
		String q = "from Blogger b where b.bloggerStatus='Pending'";
		List<Blogger> b = (List<Blogger>) hibernateTemplate.find(q);
		return b;
	}

	public List<Blogger> getApprovedBloggers() {
		String q = "from Blogger b where b.bloggerStatus='Approved'";
		List<Blogger> b = (List<Blogger>) hibernateTemplate.find(q);
		return b;
	}

	@Transactional
	public void approvePendingBlogger(long bloggerId) {
		Blogger b = hibernateTemplate.get(Blogger.class, bloggerId);
		b.setBloggerStatus("Approved");
		hibernateTemplate.saveOrUpdate(b);
	}

	@Transactional
	public void deactivateApprovedBlogger(long bloggerId) {
		Blogger b = hibernateTemplate.get(Blogger.class, bloggerId);
		b.setBloggerStatus("Pending");
		hibernateTemplate.saveOrUpdate(b);
	}

	@Transactional
	public void deleteBlogger(long bloggerId) {
		Blogger b = hibernateTemplate.get(Blogger.class, bloggerId);
		hibernateTemplate.delete(b);
	}

	public List<Blog> getPendingBlogs() {
		String q = "from Blog b where b.blogStatus='Pending'";
		List<Blog> b = (List<Blog>) hibernateTemplate.find(q);
		return b;
	}

	public List<Blog> getApprovedBlogs() {
		String q = "from Blog b where b.blogStatus='Approved'";
		List<Blog> b = (List<Blog>) hibernateTemplate.find(q);
		return b;
	}

	@Transactional
	public void approvePendingBlog(long blogId) {
		Blog b = hibernateTemplate.get(Blog.class, blogId);
		b.setBlogStatus("Approved");
		hibernateTemplate.saveOrUpdate(b);
	}

	@Transactional
	public void deleteBlog(long blogId) {
		Blog b = hibernateTemplate.get(Blog.class, blogId);
		hibernateTemplate.delete(b);
	}

}
