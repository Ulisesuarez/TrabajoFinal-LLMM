package org.mvpigs.jsonParser;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.mvpig.feed.FeedMessage;

import java.util.ArrayList;
import java.util.List;

public class Noticia {
    @JsonProperty("title")
    private String title;
    @JsonProperty("imgbig")
    private String imgbig;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("text")
    private String text;
    @JsonProperty("video")
    private String video;
    @JsonProperty("text2")
    private String text2;
    @JsonProperty("date")
    private String date;
    @JsonProperty("author")
    private String author;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgbig() {
        return imgbig;
    }

    public void setImgbig(String imgbig) {
        this.imgbig = imgbig;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSummary() {
        return summary.replaceAll("<br>","\n");
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public  String toString() {
        return "Noticia{" +
                "title='" + title + '\'' +
                ", \nimgbig='" + imgbig + '\'' +
                ", \nsubtitle='" + subtitle + '\'' +
                ", \nsummary='" + summary.replaceAll("<br>","\n") + '\'' +
                ", \ntext='" + text + '\'' +
                ", \nvideo='" + video + '\'' +
                ", \ntext2='" + text2 + '\'' +
                ", \ndate='" + date + '\'' +
                ", \nauthor='" + author + '\'' +
                '}';
    }

    public  Noticia(){};
    public Noticia(String title, String imgbig, String subtitle, String summary, String text, String video, String text2, String date, String author) {

        this.title = title;
        this.imgbig = imgbig;
        this.subtitle = subtitle;
        this.summary = summary;
        this.text = text;
        this.video = video;
        this.text2 = text2;
        this.date = date;
        this.author = author;
    }
}

/*"title": "El equilibrio del miedo",
    "imgmid": "img/0-1-small.jpg",
    "imgbig":"img/0-1-big.png",
    "subtitle": "¿Qué sucede en un juego en el que todos los jugadores saben cuál es la mejor estrategia de cada uno de ellos?",
    "summary":"Hablábamos la semana pasada de las elecciones que hay que hacer teniendo en cuenta cuáles pueden ser las elecciones de los demás, como en el caso del concurso de belleza de Keynes. Estas situaciones pueden considerarse como un juego en el que cada elección es una jugada. Y cuando en estos juegos cada jugador conoce las estrategias de los demás y todos buscan maximizar sus posibilidades de éxito, se tiende a un “equilibrio de Nash”.<br><br>El equilibrio de Nash se alcanza cuando la estrategia de cada jugador es la mejor en relación con las estrategias de los demás, por lo que a nadie le conviene cambiar de estrategia si los demás no lo hacen. A mediados del siglo pasado, el matemático estadounidense John Nash demostró que en todo juego en el que los jugadores pueden elegir entre un número finito de estrategias, siempre existirá al menos un equilibrio de este tipo, en el que, en principio, ningún jugador se atreve a cambiar de estrategia en función de lo que piensa que harán los demás; por eso el equilibrio de Nash se conoce también como “equilibrio del miedo”.<br><br>En 1994, Nash recibió el Premio Nobel de Economía por sus aportaciones a la teoría de juegos, y la galardonada película Una mente maravillosa se basa en su accidentada vida (sufría frecuentes alucinaciones y se le diagnosticó esquizofrenia paranoide). Su caso también contribuyó a fomentar las especulaciones sobre la relación entre genialidad y locura",
    "text":"Hablábamos la semana pasada de las elecciones que hay que hacer teniendo en cuenta cuáles pueden ser las elecciones de los demás, como en el caso del concurso de belleza de Keynes. Estas situaciones pueden considerarse como un juego en el que cada elección es una jugada. Y cuando en estos juegos cada jugador conoce las estrategias de los demás y todos buscan maximizar sus posibilidades de éxito, se tiende a un “equilibrio de Nash”.<br><br>El equilibrio de Nash se alcanza cuando la estrategia de cada jugador es la mejor en relación con las estrategias de los demás, por lo que a nadie le conviene cambiar de estrategia si los demás no lo hacen. A mediados del siglo pasado, el matemático estadounidense John Nash demostró que en todo juego en el que los jugadores pueden elegir entre un número finito de estrategias, siempre existirá al menos un equilibrio de este tipo, en el que, en principio, ningún jugador se atreve a cambiar de estrategia en función de lo que piensa que harán los demás; por eso el equilibrio de Nash se conoce también como “equilibrio del miedo”.<br><br>En 1994, Nash recibió el Premio Nobel de Economía por sus aportaciones a la teoría de juegos, y la galardonada película Una mente maravillosa se basa en su accidentada vida (sufría frecuentes alucinaciones y se le diagnosticó esquizofrenia paranoide). Su caso también contribuyó a fomentar las especulaciones sobre la relación entre genialidad y locura, y él mismo solía decir que no habría tenido tan buenas ideas si hubiera pensado de una forma “más normal”.",
    "video":"https://www.youtube.com/embed/HxGvzia2PcU",
    "text2":"El dilema del prisionero<br><br>Un ejemplo de situación que puede desembocar en un equilibrio de Nash es el famoso “dilema del prisionero”. Seguro que muchos ya lo conocen, pero es de obligada mención al hablar del “equilibrio del miedo”, y, por otra parte, no está de más someterlo a debate entre nuestras/os sagaces lectoras/es:<br><br>Dos prisioneros, A y B, han cometido un crimen. La policía los ha detenido, pero no tiene pruebas suficientes para mandarlos a la cárcel. Con objeto de hacerlos confesar, los encierran por separado y a cada uno le plantean lo siguiente:<br><br>Si tú confiesas y tu compañero no lo hace, a ti te dejaremos en libertad y a él le caerán diez años de cárcel.<br><br>Si confesáis ambos, os caerán cinco años de cárcel a cada uno.<br><br>Si no confesáis ninguno de los dos, os caerá un año de cárcel a cada uno.<br><br>¿Cuál sería en este caso el equilibrio de Nash? ¿Qué harías si fueras uno de los dos prisioneros?<br><br>Carlo Frabetti es escritor y matemático, miembro de la Academia de Ciencias de Nueva York. Ha publicado más de 50 obras de divulgación científica para adultos, niños y jóvenes, entre ellos Maldita física, Malditas matemáticas o El gran juego. Fue guionista de La bola de cristal.<br>",
    "date":"30 MAY 2018 - 11:12 ",
    "author":"Carlo Frabetti"
  },*/