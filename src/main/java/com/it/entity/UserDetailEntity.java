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
@Table(name = "user_detail")
@Data
public class UserDetailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_de_id")
	private Integer userDeId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "phone")
	private String phone;
	
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
