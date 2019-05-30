package com.maciejg.School02.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="LoginAndPassword")
public class LoginAndPassword {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long username_id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "user_password")
	private String user_password;
	
	@OneToMany(mappedBy = "loginAndPassword", cascade = CascadeType.ALL)
	private List<GradeEntity> g;

	public Long getId() {
		return username_id;
	}

	public void setId(Long id) {
		this.username_id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public List<GradeEntity> getG() {
		return g;
	}

	public void setG(List<GradeEntity> g) {
		this.g = g;
	}
	
	
	
	
}
