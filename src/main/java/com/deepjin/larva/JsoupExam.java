package com.deepjin.larva;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupExam {
    public static void main(String[] args) throws IOException {
        try {
            String URL = "https://www.naver.com";
            Connection conn = Jsoup.connect(URL);

            Document html = conn.get();

            System.out.println("[Attribute 탐색]");

            Elements fileblocks = html.getElementsByClass("group_nav");
            for(Element fileblock : fileblocks)  {
                Elements files = fileblock.getElementsByTag("a");
                for(Element elm : files) {
                    String text = elm.text();
                    String href = elm.attr("href");

                    System.out.println(text + " > "+href);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
