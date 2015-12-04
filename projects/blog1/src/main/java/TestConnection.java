import java.sql.SQLException;
import java.util.List;

import com.itclass.dao.AbstractDAO;
import com.itclass.dao.PostDAO;
import com.itclass.model.Post;

public class TestConnection {

	public static void main(String[] args) throws SQLException {
	
		AbstractDAO<Integer, Post> dao = new PostDAO();
		List<Post> posts = dao.getAll();
		
		for(Post post: posts) {
			System.out.println(post);
		}

	}

}
















