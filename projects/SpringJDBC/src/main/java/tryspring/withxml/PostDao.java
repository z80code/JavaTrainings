package tryspring.withxml;

import javax.sql.DataSource;
import java.util.List;

public interface PostDao {
    void setDataSource(DataSource ds);
    List<Post> getAll();
}
