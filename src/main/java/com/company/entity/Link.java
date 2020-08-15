package com.company.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor
public class Link {
	@Id
	@GeneratedValue
	private Long id;

	private String link;
	private int count;

	public Link(String link) {
		this.link = link;
	}
	
	
}
