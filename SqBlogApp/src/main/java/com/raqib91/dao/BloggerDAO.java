package com.raqib91.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.raqib91.entity.Blog;
import com.raqib91.entity.Blogger;

public class BloggerDAO {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public void CreateBlogger(Blogger b) {
		hibernateTemplate.save(b);
	}

	public Blogger getSingleBlogger(long bloggerId) {
		Blogger b = hibernateTemplate.get(Blogger.class, bloggerId);
		return b;
	}

	@Transactional
	public void createBlog(Blog blog, long bloggerId) {
		Blogger b = hibernateTemplate.get(Blogger.class, bloggerId);
		b.getBlogs().add(blog);
		blog.setBlogger(b);
		hibernateTemplate.saveOrUpdate(b);
		hibernateTemplate.save(blog);
	}

	public List<Blog> getPendingBlogs(long bloggerId) {
		String q = "from Blog b where b.blogStatus='Pending'";
		List<Blog> pb = (List<Blog>) hibernateTemplate.find(q);

		List<Blog> valid = new ArrayList<>();
		for (Blog b : pb) {
			if (b.getBlogger().getBloggerId() == bloggerId) {
				valid.add(b);
			}
		}
		return valid;
	}

	public List<Blog> getApprovedBlogs(long bloggerId) {
		String q = "from Blog b where b.blogStatus='Approved'";
		List<Blog> ab = (List<Blog>) hibernateTemplate.find(q);

		List<Blog> valid = new ArrayList<>();
		for (Blog b : ab) {
			if (b.getBlogger().getBloggerId() == bloggerId) {
				valid.add(b);
			}
		}
		return valid;
	}

}
