package com.it.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "role")
@Data
public class RoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_de_id")
	private Integer roleId;
	
	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "role_desc")
	private String roleDesc;
	
	@Column(name = "role_status")
	private String roleStatus;
}
