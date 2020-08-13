package com.company.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.company.role.CustomerRole;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue
	private Long id;
		
	private String login;
	private String password;
	private String link;
	
	@Enumerated(EnumType.STRING)
	private CustomerRole role;
	
	public Customer(String login, String password, String link, CustomerRole role) {
		this.login = login;
		this.password = password;
		this.link = link;
		this.role = role;
	}
	
	
}
