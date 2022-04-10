package com.mixsale.mixsale.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mixsale.mixsale.dao.GenarateQRCodeDao;

@Repository
public class GenarateQRCodeDaoImpl implements GenarateQRCodeDao{

	
private final JdbcTemplate defaultJdbcTemplate;
	
	protected GenarateQRCodeDaoImpl(JdbcTemplate defaultJdbcTemplate) {
        this.defaultJdbcTemplate = defaultJdbcTemplate;
    }
	
	@Override
	public void saveLogQrCode() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
