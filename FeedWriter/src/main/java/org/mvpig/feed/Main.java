package org.mvpig.feed;
import org.mvpigs.jsonParser.JsonParser;
import org.mvpigs.jsonParser.Noticia;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class Main {

    public static void main (String[] args) throws IOException {


        // create the rss feed
        String copyright = "Copyright hold by Pinocho";
        String title = "Desinformación";
        String description = "Podra leer y de ahí en adelante hagase usted responsable";
        String language = "es";
        String link = "http://www.desinformacion.no";
        Calendar cal = new GregorianCalendar();
        Date creationDate = cal.getTime();
        SimpleDateFormat date_format = new SimpleDateFormat(
                "EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'Z", Locale.US);
        String pubdate = date_format.format(creationDate);
        Feed rssFeeder = new Feed(title, link, description, language,
                copyright, pubdate);

        for (int page=0;page<3;page++){
            for (int news=0;news<3;news++){
                System.out.println(String.valueOf(page)+" "+String.valueOf(news));
                Noticia noticia=JsonParser.getNoticia(String.valueOf(page),String.valueOf(news));
                FeedMessage feed = new FeedMessage();
                feed.setTitle(noticia.getTitle());
                feed.setDescription(noticia.getSummary());
                feed.setAuthor(noticia.getAuthor());
                feed.setGuid("http://www.desinformacion.no/?page="+page+"&news="+news);
                feed.setLink("http://www.desinformacion.no/?page="+page+"&news="+news);
                rssFeeder.getMessages().add(feed);}
        }

        System.out.println(JsonParser.getNoticia());
        // now add one example entry


        // now write the file
        RSSFeedWriter writer = new RSSFeedWriter(rssFeeder, "/home/ulises/Micarpeta/proyectos/web/TrabajoFinal-LLMM/js/articles.rss");
        try {
            writer.write();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

/*

public class WriteTest {

    public static void main(String[] args) {
        // create the rss feed
        String copyright = "Copyright hold by Lars Vogel";
        String title = "Eclipse and Java Information";
        String description = "Eclipse and Java Information";
        String language = "en";
        String link = "http://www.vogella.com";
        Calendar cal = new GregorianCalendar();
        Date creationDate = cal.getTime();
        SimpleDateFormat date_format = new SimpleDateFormat(
                "EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'Z", Locale.US);
        String pubdate = date_format.format(creationDate);
        Feed rssFeeder = new Feed(title, link, description, language,
                copyright, pubdate);

        // now add one example entry
        FeedMessage feed = new FeedMessage();
        feed.setTitle("RSSFeed");
        feed.setDescription("This is a description");
        feed.setAuthor("nonsense@somewhere.de (Lars Vogel)");
        feed.setGuid("http://www.vogella.com/tutorials/RSSFeed/article.html");
        feed.setLink("http://www.vogella.com/tutorials/RSSFeed/article.html");
        rssFeeder.getMessages().add(feed);

        // now write the file
        RSSFeedWriter writer = new RSSFeedWriter(rssFeeder, "articles.rss");
        try {
            writer.write();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}*/