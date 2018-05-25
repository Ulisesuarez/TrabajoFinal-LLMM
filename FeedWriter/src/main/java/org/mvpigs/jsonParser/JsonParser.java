package org.mvpigs.jsonParser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mvpig.feed.Feed;

import java.io.File;
import java.io.IOException;

public class JsonParser {
    private static final ObjectMapper objectMapper =
            new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static Noticia getNoticia() throws IOException {
        try {
            Noticia primera = objectMapper.readValue(new File("/home/ulises/Micarpeta/proyectos/java/FeedWriter/src/main/resources/2-2.json"), Noticia.class);
            return primera;
        } catch (Error e){
          System.out.println(e);
        }

   return null;}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static Noticia getNoticia(String page,String news ) throws IOException {
        try {
            Noticia primera = objectMapper.readValue(new File("/home/ulises/Micarpeta/proyectos/java/FeedWriter/src/main/resources/"+page+"-"+news+".json"), Noticia.class);
            return primera;
        } catch (Error e){
            System.out.println(e);
        }

        return null;}
}