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
@Table(name="tbl_mix_sale_qrcode")
public class QrCodeEntity implements Serializable{

	private static final long serialVersionUID = 8046445409623848330L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="qrcode")
    private String qrcode;
	
	@Column(name="period_type")
    private String periodType;
	
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
