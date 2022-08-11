package com.film.cinema;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Crawling {
    public static void main(String[] args) {
        final String currentMovieUrl = "https://search.naver.com/search.naver?where=nexearch&query=%ED%98%84%EC%9E%AC%EC%83%81%EC%98%81%EC%98%81%ED%99%94%EC%88%9C%EC%9C%84&ie=utf8&sm=tab_she&qdt=0";
        Connection connect = Jsoup.connect(currentMovieUrl);
        int a = 1;

        try {
            Document document = connect.get();
            Elements elementsByClass = document.getElementsByClass("cm_tab_info_box").select("li").addClass("thumb").select("img[src]");
            Elements title_box = document.getElementsByClass("title_box").select(".name");

            for (Element element : elementsByClass) {
                if (a > 20) return;
                System.out.println("element = " + element.attr("abs:src"));
            }

            for (int i = 0; i < 20; i++) {
                String title = title_box.get(i).text();
                System.out.println("text = " + title);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
