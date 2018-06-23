package com.eds.repository;

import com.eds.DatabasePopulator;
import com.eds.domain.DeltaUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

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
        super.createDatabase();
    }

    @Test
    public void getTotalRecords(){
        List<DeltaUser> list = deltaUserRepository.getAllusers();
        assertEquals(list.size(), 4);
    }
}
