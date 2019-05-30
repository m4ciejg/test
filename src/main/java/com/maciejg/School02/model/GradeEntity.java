package com.maciejg.School02.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grades")
public class GradeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "grade")
	private String grade;
	
	@Column(name = "comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name= "username_id")
	private LoginAndPassword loginAndPassword;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LoginAndPassword getLoginAndPassword() {
		return loginAndPassword;
	}

	public void setLoginAndPassword(LoginAndPassword loginAndPassword) {
		this.loginAndPassword = loginAndPassword;
	}

	

}
