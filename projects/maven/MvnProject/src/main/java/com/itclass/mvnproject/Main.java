package com.itclass.mvnproject;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        //Elements newsHeadlines = doc.select("#mp-itn b a");
        System.out.println(doc);

    }

}
