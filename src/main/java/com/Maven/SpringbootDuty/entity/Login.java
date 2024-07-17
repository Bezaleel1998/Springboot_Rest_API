package com.Maven.SpringbootDuty.entity;

import java.util.*;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "user_tbl")
public class Login {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String username;
	private String password;
	private String code_user;
	private String role;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCodeUser() {
		return code_user;
	}
	public void setCodeUser(String codeUser) {
		this.code_user = codeUser;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
