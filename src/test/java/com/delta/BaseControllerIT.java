package com.delta;

import com.delta.form.LoginForm;
import org.json.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

@RunWith(SpringRunner.class)
public abstract class BaseControllerIT extends DatabasePopulator{

    @LocalServerPort
    protected int port;

    @Autowired
    private TestRestTemplate template;

    @Autowired
    JdbcTemplate jdbcTemplate;

    protected URL base;
    public static HttpHeaders headers;
    public static HttpEntity<?> request;

    public void setup() throws  Exception {
        this.base = new URL("http://localhost:" + port + "/");
        super.createDatabase();

        if(DataContainer.headers != null){
            headers = DataContainer.headers;
        }

        if(DataContainer.request != null){
            request = DataContainer.request;
        }

        if(headers != null && request != null){
            return;
        }

        LoginForm form = new LoginForm();
        form.setUsername("udit");
        form.setPassword("abcd");
        HttpEntity<LoginForm> httpEntity = new HttpEntity<LoginForm>(form);
        ResponseEntity<String> response = template.postForEntity(base.toString() + "login",
                httpEntity, String.class);

        JSONObject jsonObject = new JSONObject(response.getBody());
        headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        DataContainer.idToken = jsonObject.get("token").toString();
        headers.set("Authorization","Bearer "+DataContainer.idToken);

        request = new HttpEntity<Void>(headers);
        DataContainer.headers = headers;
        DataContainer.request = request;
    }
}
