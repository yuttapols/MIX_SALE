package com.mixsale.mixsale.entity;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="tbl_mix_sale_customer")
public class CustomerEntity implements Serializable{
	
	private static final long serialVersionUID = -4621699675966504633L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Column(name="emp_id")
    private String empId;
	
	@Column(name="cs_name")
    private String csName;
	
	@Column(name="cs_lastname")
    private String csLastname;
	
	@Column(name="cs_idcard")
    private String csIdcard;
	
	@Column(name="cs_id_line")
    private String csIdLine;
	
	@Column(name="cs_phone")
    private String csPhone;
	
	@Column(name="cs_branch")
    private String csBranch;
	
	@Column(name="is_active")
    private String isActive;
	
	@Column(name="create_by")
    private String createBy;
	
	@Column(name="create_date")
    private Timestamp createDate;
	
	@Column(name="update_by")
    private String updateBy;
	
	@Column(name="update_date")
    private Timestamp updateDate;
}
