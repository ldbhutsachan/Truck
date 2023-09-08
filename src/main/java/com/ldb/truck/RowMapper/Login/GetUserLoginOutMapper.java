package com.ldb.truck.RowMapper.Login;

import com.ldb.truck.Model.Login.Login.GetUserLoginOut;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetUserLoginOutMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        GetUserLoginOut data = new GetUserLoginOut ();
        try {
            data.setRole(rs.getString("ROLE"));
            data.setStaftId(rs.getString("STAFT_ID"));
            data.setStaftName(rs.getString("STAFT_NAME"));
        }catch (Exception e){
            e.printStackTrace();
            return data;
        }
        return data;
    }
}
