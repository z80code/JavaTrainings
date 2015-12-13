package com.annotation;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

public interface BlogDAO<T> {

    void setDataSource(DataSource ds);

    List<T> getAll();

}
