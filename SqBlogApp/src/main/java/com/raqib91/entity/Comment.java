package com.raqib91.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "comment_tbl")
public class Comment {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "comment_id")
	private int commentId;
	@Column(name = "commentator_id")
	private long commentatorId;
	@Column(name = "comment_content")
	private String commentContent;
	@ManyToOne
	private Blog blog;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(long commentatorId, String commentContent) {
		super();
		this.commentatorId = commentatorId;
		this.commentContent = commentContent;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public long getCommentatorId() {
		return commentatorId;
	}

	public void setCommentatorId(long commentatorId) {
		this.commentatorId = commentatorId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentatorId=" + commentatorId + ", commentContent="
				+ commentContent + ", blog=" + blog + "]";
	}

}
