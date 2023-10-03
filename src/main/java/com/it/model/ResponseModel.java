package com.it.model;

import lombok.Data;

@Data
public class ResponseModel {
	
	private Integer status;
	private Object data;
	private String statusCode;
	private String message;
}
