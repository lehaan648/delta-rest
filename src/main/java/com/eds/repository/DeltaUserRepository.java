package com.eds.repository;

import com.eds.domain.DeltaUser;
import com.eds.resultsetExtractor.DeltaUserResultSetExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeltaUserRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public List<DeltaUser> getAllusers() {
        String query = "SELECT * FROM deltaUser";
        MapSqlParameterSource params = new MapSqlParameterSource();
        List<DeltaUser> usersList = (List<DeltaUser>) jdbcTemplate.query(query, params, new DeltaUserResultSetExtractor());
        return usersList;
    }
}
