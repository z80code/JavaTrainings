package com.annotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class BlogDAOImpl implements BlogDAO<Post> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public List<Post> getAll() {
        String query = "SELECT * FROM posts";
        return jdbcTemplate.query(query, new PostMapper());
    }
}
