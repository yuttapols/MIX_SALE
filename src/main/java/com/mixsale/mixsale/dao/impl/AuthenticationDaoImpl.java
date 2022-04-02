package com.mixsale.mixsale.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mixsale.mixsale.dao.AuthenticationDao;
import com.mixsale.mixsale.dto.UserDTO;

@Repository
public class AuthenticationDaoImpl implements AuthenticationDao{

	private final JdbcTemplate defaultJdbcTemplate;
	
	protected AuthenticationDaoImpl(JdbcTemplate defaultJdbcTemplate) {
        this.defaultJdbcTemplate = defaultJdbcTemplate;
    }
	@Override
	public UserDTO login(String userName, String password) throws Exception {
		
		StringBuilder sql = new StringBuilder();
		
		List<Object> param = new ArrayList<>();
		
		sql.append("select username, password, status from tbl_mix_sale_user user ");
		sql.append("where user.username = ? ");
		sql.append("and user.password = ? ");
		
		param.add(userName);
		param.add(password);
		
		Object[] paramArr = param.toArray();
		
		List<UserDTO> result = defaultJdbcTemplate.query(sql.toString(), paramArr, rowMapperUserDTO);
		
		if(null != result && !result.isEmpty()) {
			return result.get(0);
		}
		
		return null;
	}
	
	private final static RowMapper<UserDTO> rowMapperUserDTO = new RowMapper<UserDTO>() {
		
		@Override
		public UserDTO mapRow(ResultSet rs, int row) throws SQLException{
			UserDTO dto = new UserDTO();
			dto.setUserName(rs.getString("username"));
			dto.setPassword(rs.getString("password"));
			dto.setStatus(rs.getString("status"));
			return dto;
		}
	};

}
