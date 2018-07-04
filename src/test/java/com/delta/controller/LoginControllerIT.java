package com.delta.controller;

import com.delta.BaseControllerIT;
import com.delta.dto.DeltaUserDTO;
import com.delta.form.LoginForm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginControllerIT extends BaseControllerIT {

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        super.setup();
    }

    @Test
    public void goodLogin() {
        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("udit");
        loginForm.setPassword("abcd");
        headers.set("Content-type", "Application/json");
        HttpEntity<LoginForm> httpEntity = new HttpEntity<>(loginForm, headers);
        ResponseEntity<DeltaUserDTO> response = template.postForEntity(base.toString() + "/login", httpEntity, DeltaUserDTO.class);
        DeltaUserDTO deltaUserDTO = response.getBody();
        assertEquals("udit", deltaUserDTO.getFirstName());
        assertEquals("shah", deltaUserDTO.getLastName());
        assertEquals("fake token", deltaUserDTO.getToken());
        assertEquals("udit", deltaUserDTO.getUsername());
    }

    @Test
    public void badLogin() {
        LoginForm loginForm = new LoginForm();
        loginForm.setPassword("no");
        loginForm.setUsername("no");
        headers.set("Content-type", "Application/json");
        HttpEntity<LoginForm> httpEntity = new HttpEntity<>(loginForm, headers);
        ResponseEntity<String> response = template.postForEntity(base.toString() + "/login", httpEntity, String.class);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("No User Found", response.getBody().toString());
    }
}
