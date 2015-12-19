package tryspring.withxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Run {

    public static void main(String[] args) {

        ApplicationContext context =
                new FileSystemXmlApplicationContext
                        ("file:src/main/java/tryspring/withxml/beans.xml");

        PostDao dao = context.getBean(PostDao.class);
        //PostDao dao = (PostDao) context.getBean("postDao");
        System.out.println(dao.getAll());

    }
}
