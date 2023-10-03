package com.it.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role_id")
	private Integer roleId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "create_by")
	private String createBy;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name = "update_by")
	private String updateBy;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "update_date")
	private Date updateDate;
}
