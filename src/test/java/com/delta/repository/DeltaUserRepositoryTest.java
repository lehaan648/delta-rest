package com.delta.repository;

import com.delta.DatabasePopulator;
import com.delta.domain.DeltaUser;
import com.delta.form.LoginForm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lakshit on 24-08-2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class DeltaUserRepositoryTest extends DatabasePopulator {

    @Autowired
    DeltaUserRepository deltaUserRepository;

    @Before
    public void setup() {
        List<String> sqlFiles = new ArrayList<>();
        sqlFiles.add("sql/deltaUser.sql");
        super.createDatabase(sqlFiles);
    }

    @Test
    public void getUserByUsernameAndPassword() {
        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("udit");
        loginForm.setPassword("abcd");
        DeltaUser deltaUser = deltaUserRepository.getUserByUsernameAndPassword(loginForm);
        assertEquals(deltaUser.getFirstName(), "udit");
        assertEquals(deltaUser.getLastName(), "shah");
        assertEquals(deltaUser.getDefaultScriptId(), new Integer(1));
    }
}
