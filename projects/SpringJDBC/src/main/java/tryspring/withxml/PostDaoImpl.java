package tryspring.withxml;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class PostDaoImpl implements PostDao {

    private JdbcTemplate jdbc;

    public void setDataSource(DataSource ds) {
        jdbc = new JdbcTemplate(ds);
    }

    public List<Post> getAll() {
        String sql = "select * from posts";
        return jdbc.query(sql,new PostMapper());
    }
}
