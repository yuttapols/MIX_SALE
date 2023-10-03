package com.it.model.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.it.model.UserDetailModel;

import lombok.Data;

@Data
public class UserModelResponse {

	private Integer userId;
	private String userName;
	private String password;
	private Integer roleId;
	private String status;
	private String createBy;
	@JsonFormat(pattern="yyyy-MM-dd", locale = "en")
	private Date createDate;
	private String updateBy;
	@JsonFormat(pattern="yyyy-MM-dd", locale = "en")
	private Date updateDate;
	
	private UserDetailModel userDetail;
}
