package com.mixsale.mixsale.dto.request;

import lombok.Data;

@Data
public class CustomerRequestDTO {

	private String empId;
	private String csName;
	private String csLastname;
	private String csIdcard;
	private String csPhone;
	private String csIdLine;
	private String csBranch;
	private String isActive;
	private String role;
	private String attrId;
}
