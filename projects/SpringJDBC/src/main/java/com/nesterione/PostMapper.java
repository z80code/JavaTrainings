package com.nesterione;

import org.springframework.jdbc.core.RowMapper;

import java.sql.*;

public class PostMapper implements RowMapper<Post> {

    public Post mapRow(ResultSet resultSet, int i) throws SQLException {

        Integer id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        Timestamp created = resultSet.getTimestamp("created");
        Timestamp lastChanged = resultSet.getTimestamp("lastChanged");
        Clob content = resultSet.getClob("content");
        String tags = resultSet.getString("tags");

        Post post = new Post(id, title, new Date(created.getTime()), new Date(lastChanged.getTime()),
                content.getSubString(1L, (int) content.length()), tags);

        return post;
    }

}
