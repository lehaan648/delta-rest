package com.delta.service;

import com.delta.DatabasePopulator;
import com.delta.dto.DeltaUserDTO;
import com.delta.form.LoginForm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserServiceTest extends DatabasePopulator{

    @Autowired
    UserService userService;

    @Test
    public void test() {
        System.out.println("hello world");
    }
    /*@Before
    public void setup() {
        super.createDatabase();
    }

    @Test
    public void validateLogin() {
        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("udit");
        loginForm.setPassword("abcd");
        DeltaUserDTO deltaUserDTO = userService.validateLogin(loginForm);
        assertEquals(deltaUserDTO.getFirstName(), "udit");
        assertEquals(deltaUserDTO.getLastName(), "shah");
        assertEquals(deltaUserDTO.getUsername(), "udit");
        assertEquals(deltaUserDTO.getToken(), "fake token");
    }*/
}
