package com.mixsale.mixsale.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_mix_slae_user")
public class UserEntity implements Serializable{

	private static final long serialVersionUID = -3395015592687626443L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Column(name="username")
    private String username;
	
	@Column(name="password")
    private String password;
	
	@Column(name="phone")
    private String phone;
	
	@Column(name="status")
    private String status;
}
