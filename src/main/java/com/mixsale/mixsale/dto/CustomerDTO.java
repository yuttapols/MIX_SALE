package com.mixsale.mixsale.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CustomerDTO {

	private String empId;
	private String csName;
	private String csLastname;
	private String csIdcard;
	private String csPhone;
	private String csIdLine;
	private String csBranch;
	private String isActive;
	private String createBy;
	private Timestamp createDate;
	private String updateBy;
	private Timestamp updateDate;
}
