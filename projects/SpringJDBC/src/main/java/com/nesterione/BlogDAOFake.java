package com.nesterione;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class BlogDAOFake implements BlogDAO<Post> {
    public void setDataSource(DataSource ds) {

    }

    public List<Post> getAll() {
        return Arrays.asList(new Post(1,"sdfsdf",new Date(),new Date(),"cont","tags"));
    }
}
