package com.raqib91.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "blog_tbl")
public class Blog {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "blog_id")
	private long blogId;
	@Column(name = "blog_title")
	private String blogTitle;
	@Column(name = "blog_content")
	private String blogContent;
	@Column(name = "blog_status")
	private String blogStatus;
	@ManyToOne
	private Blogger blogger;
	@OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();

	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Blog(String blogTitle, String blogContent, String blogStatus) {
		super();
		this.blogTitle = blogTitle;
		this.blogContent = blogContent;
		this.blogStatus = blogStatus;
	}

	public long getBlogId() {
		return blogId;
	}

	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public String getBlogStatus() {
		return blogStatus;
	}

	public void setBlogStatus(String blogStatus) {
		this.blogStatus = blogStatus;
	}

	public Blogger getBlogger() {
		return blogger;
	}

	public void setBlogger(Blogger blogger) {
		this.blogger = blogger;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", blogTitle=" + blogTitle + ", blogContent=" + blogContent + ", blogStatus="
				+ blogStatus + ", blogger=" + blogger + ", comments=" + comments + "]";
	}

}
