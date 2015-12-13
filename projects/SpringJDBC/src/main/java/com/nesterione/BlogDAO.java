package com.nesterione;

import javax.sql.DataSource;
import java.util.List;

public interface BlogDAO<T> {

    void setDataSource(DataSource ds);

    List<T> getAll();

}
