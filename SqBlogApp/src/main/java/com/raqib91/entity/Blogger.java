package com.raqib91.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "blogger_tbl")
public class Blogger {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "blogger_id")
	private long bloggerId;
	@Column(name = "blogger_username")
	private String bloggerUsername;
	@Column(name = "blogger_password")
	private String bloggerPassword;
	@Column(name = "blogger_status")
	private String bloggerStatus;
	@OneToMany(mappedBy = "blogger", cascade = CascadeType.ALL)
	private List<Blog> blogs = new ArrayList<Blog>();

	public Blogger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Blogger(String bloggerUsername, String bloggerPassword, String bloggerStatus) {
		super();
		this.bloggerUsername = bloggerUsername;
		this.bloggerPassword = bloggerPassword;
		this.bloggerStatus = bloggerStatus;
	}

	public long getBloggerId() {
		return bloggerId;
	}

	public void setBloggerId(long bloggerId) {
		this.bloggerId = bloggerId;
	}

	public String getBloggerUsername() {
		return bloggerUsername;
	}

	public void setBloggerUsername(String bloggerUsername) {
		this.bloggerUsername = bloggerUsername;
	}

	public String getBloggerPassword() {
		return bloggerPassword;
	}

	public void setBloggerPassword(String bloggerPassword) {
		this.bloggerPassword = bloggerPassword;
	}

	public String getBloggerStatus() {
		return bloggerStatus;
	}

	public void setBloggerStatus(String bloggerStatus) {
		this.bloggerStatus = bloggerStatus;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	@Override
	public String toString() {
		return "Blogger [bloggerId=" + bloggerId + ", bloggerUsername=" + bloggerUsername + ", bloggerPassword="
				+ bloggerPassword + ", bloggerStatus=" + bloggerStatus + ", blogs=" + blogs + "]";
	}

}
