package com.sergio.examenmaven;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.div;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import static org.jsoup.nodes.Document.OutputSettings.Syntax.html;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/SPXX0084:1:SP").get();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
          String title = doc.title();
          Element headerDiv = doc.select("div.today_nowcard-temp").first();
          
          String temp = "<div class=\"today_nowcard-temp\"></div>";
          Document doc1 = Jsoup.parseBodyFragment(temp);
          String frase = "<div class=\"today_nowcard-phrase\"></div>";
          Document doc2 = Jsoup.parseBodyFragment(frase);
          

          System.out.printf("Datos extraidos de: %s%n", title);
          System.out.printf("Temperatura: %n", doc1.html(temp));
          System.out.printf("Estado del Cielto: %n", doc1.html(frase));
          
          
//          System.out.printf("Body: %s", body);
    }
    
}
