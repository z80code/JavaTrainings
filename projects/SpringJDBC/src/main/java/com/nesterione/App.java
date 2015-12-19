package com.nesterione;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
              ApplicationContext context =
                new FileSystemXmlApplicationContext
                        ("file:src/main/java/com/nesterione/beans.xml");

        BlogDAO dao = (BlogDAO) context.getBean("blogDAO");

        System.out.println(dao.getAll());

        Post post = (Post)context.getBean("post");

        System.out.println(post);
    }
}
