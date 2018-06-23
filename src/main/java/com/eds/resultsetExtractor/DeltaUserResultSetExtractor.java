package com.eds.resultsetExtractor;

import com.eds.domain.DeltaUser;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeltaUserResultSetExtractor implements ResultSetExtractor {
    @Override
    public List<DeltaUser> extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        List<DeltaUser> returnList = new ArrayList<>();
        while(resultSet.next()) {
            DeltaUser deltaUser = new DeltaUser();
            deltaUser.setFirstName(resultSet.getString("firstName"));
            deltaUser.setLastName(resultSet.getString("lastName"));
            deltaUser.setUsername(resultSet.getString("username"));
            deltaUser.setDefaultScriptId(resultSet.getInt("defaultScriptId"));
            returnList.add(deltaUser);
        }
        return returnList;
    }
}
