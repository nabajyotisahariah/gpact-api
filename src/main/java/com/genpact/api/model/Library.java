package com.genpact.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tm_library")
//@Data
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class Library implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;		
	
	private String name;
	
	//https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
	@OneToMany(
	        mappedBy = "library",
	        cascade = CascadeType.PERSIST,
	        fetch = FetchType.LAZY)
	@JsonIgnoreProperties("library")
	private List<Book> books;
	
	@CreationTimestamp
	private java.sql.Timestamp created_on;
	
	@UpdateTimestamp
	private java.sql.Timestamp modified_on;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public java.sql.Timestamp getCreated_on() {
		return created_on;
	}

	public void setCreated_on(java.sql.Timestamp created_on) {
		this.created_on = created_on;
	}

	public java.sql.Timestamp getModified_on() {
		return modified_on;
	}

	public void setModified_on(java.sql.Timestamp modified_on) {
		this.modified_on = modified_on;
	}
	
	
	
	
}
