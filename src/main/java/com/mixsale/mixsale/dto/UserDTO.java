package com.mixsale.mixsale.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UserDTO {
	
	private String userName;
	private String password;
	private String isActive;
	private String role;
	private String createBy;
	private Timestamp createDate;
	private String updateBy;
	private Timestamp updateDate;
	
}
