package lesson11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LessonWhile_7 {
    public static void main(String[] args) throws IOException {
//11


        int day = 1;
        while (day <= 31) {
            String strDay = day < 10 ? "0" + day : String.valueOf(day);
            String strPage = downloadWebPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY" +
                    "&start_date=2022-01-01&end_date=2022-01-" + strDay);
            int urlStart = strPage.lastIndexOf("url");
            int urlEnd = strPage.lastIndexOf("}");
            String urlImage = strPage.substring(urlStart + 6, urlEnd - 1);
            try (InputStream in = new URL(urlImage).openStream()) {
                Files.copy(in, Paths.get("nasa.jpg" + day));
            }
            System.out.println("Файлы сохранены!" + day);
            day++;
        }


    }


    private static String downloadWebPage(String url) throws IOException {

        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();


        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            while ((line = br.readLine()) != null) {
                result.append(line);
            }

        }

        return result.toString();

    }
}

