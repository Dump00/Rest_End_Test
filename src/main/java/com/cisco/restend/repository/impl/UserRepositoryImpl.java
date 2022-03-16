package com.cisco.restend.repository.impl;

import com.cisco.restend.model.UserDTO;
import com.cisco.restend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private  JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer saveUser(UserDTO userDTO) {
        String sql = "insert into account_detail (\n" +
                "first_name, \n" +
                "last_name, \n" +
                "nic, \n" +
                "mobile_no) \n" +
                "values (\n" +
                ":first_name, \n" +
                ":last_name, \n" +
                ":nic, \n" +
                ":mobile_no\n" +
                ")";
        Map<String, String> params = new HashMap<>();
        params.put("first_name", userDTO.getFirstName());
        params.put("last_name", userDTO.getLastName());
        params.put("nic", userDTO.getNic());
        params.put("mobile_no", userDTO.getMobileNo());

        return namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public List<String> getUser(String nic) {
        String sql = "select * from account_detail where nic=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            ArrayList<String> list = new ArrayList<>();
            list.add(0, rs.getString("first_name"));
            list.add(1, rs.getString("last_name"));
            list.add(2, rs.getString("nic"));
            list.add(3, rs.getString("mobile_no"));
            return list;
        }, nic);
    }

    @Override
    public Integer updateUser(UserDTO userDTO, String nic) {
        String sql = "UPDATE account_detail \n" +
                "SET \n" +
                "first_name=:first_name, \n" +
                "last_name=:last_name,\n" +
                "nic=:nic,\n" +
                "mobile_no=:mobile_no\n" +
                "WHERE \n" +
                "nic=:oldnic";

        Map<String, Object> params = new HashMap<>();
        params.put("first_name", userDTO.getFirstName());
        params.put("last_name", userDTO.getLastName());
        params.put("nic", userDTO.getNic());
        params.put("mobile_no", userDTO.getMobileNo());
        params.put("oldnic", nic);
        return namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public Integer deleteUser(String nic) {
        String sql = "DELETE FROM account_detail WHERE nic=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, nic);
    }
}
