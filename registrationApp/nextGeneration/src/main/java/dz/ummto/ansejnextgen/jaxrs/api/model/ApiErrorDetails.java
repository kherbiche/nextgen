/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejnextgen.jaxrs.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The <code>ApiErrorDetails</code> class represents data transfer object that
 * holds details about an API error.
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiErrorDetails {

	private Integer status;
	private String title;
	private String msg;
	private String path;

	public ApiErrorDetails() {
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
