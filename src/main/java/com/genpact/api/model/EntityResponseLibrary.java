package com.genpact.api.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties 
@JsonInclude(Include.NON_EMPTY)
//@Getter
//@Setter
public class EntityResponseLibrary implements Serializable {


	private static final long serialVersionUID = 2L;

	private Integer status=0;
	
	private String msg="fail";
	
	private List<Library> data;
	
	private String error;
	
	private String token;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Library> getData() {
		return data;
	}

	public void setData(List<Library> data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	
}