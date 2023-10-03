package com.it.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UserDetailModel {

	private Integer userDeId;
	private String name;
	private String lastName;
	private Integer age;
	private String phone;
	private String createBy;
	
	@JsonFormat(pattern="yyyy-MM-dd", locale = "en")
	private Date createDate;
	private String updateBy;
	
	@JsonFormat(pattern="yyyy-MM-dd", locale = "en")
	private Date updateDate;
}
