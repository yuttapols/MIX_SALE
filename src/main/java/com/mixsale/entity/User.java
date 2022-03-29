package com.mixsale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tbl_mix_sale_user", schema="SALEDB")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name="username", length=50, nullable=false, unique=false)
	private String username;
	
	@Column(name="password", length=50, nullable=false, unique=false)
	private String password;
	
	@Column(name="phone", length=10)
	private String phone;
	
	@Column(name="status", length=1)
	private String status;
	
	
}
