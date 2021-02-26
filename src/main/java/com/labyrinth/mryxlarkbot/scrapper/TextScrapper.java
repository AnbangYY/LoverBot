package com.labyrinth.mryxlarkbot.scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;

public class TextScrapper {

    static String text;
    final String html = "https://www.goodreads.com/quotes/tag/romance?page=";


    void getTextOnPage(int i) {
        String currentPage = html + String.valueOf(i);
        try {
            Document doc = Jsoup.connect(currentPage).timeout(50000).get();
            Elements e = doc.getElementsByClass("quoteText");
            int size = e.size();
            for (Element element : e
            ) {
                FileWriter fileWriter = new FileWriter("/Users/mac/IdeaProjects/loverbot/src/main/resources/quote2.txt", true);
                fileWriter.write(element.text() + "\n");
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        TextScrapper textScrapper = new TextScrapper();
//        for(int i=1; i<80; i++) textScrapper.getTextOnPage(i);
//    }
}