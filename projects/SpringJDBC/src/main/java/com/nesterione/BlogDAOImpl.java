package com.nesterione;


import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.StringTokenizer;

public class BlogDAOImpl implements BlogDAO<Post> {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public List<Post> getAll() {
        String query = "SELECT * FROM posts";
        return jdbcTemplate.query(query, new PostMapper());
    }
}
