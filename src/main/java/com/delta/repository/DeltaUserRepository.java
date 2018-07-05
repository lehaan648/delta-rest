package com.delta.repository;

import com.delta.resultsetExtractor.DeltaUserResultSetExtractor;
import com.delta.domain.DeltaUser;
import com.delta.form.LoginForm;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeltaUserRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public DeltaUser getUserByUsernameAndPassword(LoginForm loginForm) {
        loginForm.setPassword(DigestUtils.sha1Hex(loginForm.getPassword()));
        String query = "SELECT * FROM deltaUser WHERE username = :username AND password = :password";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("username", loginForm.getUsername());
        params.addValue("password", loginForm.getPassword());
        List<DeltaUser> usersList = (List<DeltaUser>) jdbcTemplate.query(query, params, new DeltaUserResultSetExtractor());
        if (usersList.size() > 0){
            return usersList.get(0);
        }
        return null;
    }
}
