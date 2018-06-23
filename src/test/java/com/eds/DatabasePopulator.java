package com.eds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.io.IOException;

/**
 * Created by hrushikesh on 21/07/17.
 */

public class DatabasePopulator {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // Load all sql files
    public void createDatabase() {

        try {
            PathMatchingResourcePatternResolver loader = new PathMatchingResourcePatternResolver();
            Resource[] resources = loader.getResources("classpath:/sql/tests/*.sql");

            for (Resource resource : resources) {
                ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(new ClassPathResource("sql/tests/" + resource.getFilename()));
                databasePopulator.execute(jdbcTemplate.getDataSource());
            }
        } catch (IOException e){

        }
    }

    // Load selected sql files
    public void createDatabase(String[] sqlFiles) {

        for(String file: sqlFiles){
            Resource resource = new ClassPathResource(file);
            ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
            databasePopulator.execute(jdbcTemplate.getDataSource());
        }
    }
}
