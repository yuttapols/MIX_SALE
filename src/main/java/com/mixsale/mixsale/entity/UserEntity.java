package com.mixsale.mixsale.entity;

import java.io.Serializable;
import java.sql.Timestamp;

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
	
	@Column(name="is_active")
    private String isActive;
	
	@Column(name="role")
    private String role;
	
	@Column(name="create_by")
    private String createBy;
	
	@Column(name="create_date")
    private Timestamp createDate;
	
	@Column(name="update_by")
    private String updateBy;
	
	@Column(name="update_date")
    private Timestamp updateDate;
}
