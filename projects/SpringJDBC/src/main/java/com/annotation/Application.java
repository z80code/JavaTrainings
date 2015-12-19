package com.annotation;


import com.web.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class Application {

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUsername("igor");
        ds.setPassword("123");
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:~/blogdb");

        return ds;
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);


        BlogDAO dao = context.getBean(BlogDAO.class);

        /*
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUsername("igor");
        ds.setPassword("123");
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:~/blogdb");

        BlogDAO dao = new BlogDAOImpl();
        dao.setDataSource(ds);
        */

        System.out.println(dao.getAll());
    }

}
