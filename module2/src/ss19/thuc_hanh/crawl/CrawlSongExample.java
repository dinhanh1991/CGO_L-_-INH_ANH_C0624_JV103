package ss19.thuc_hanh.crawl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36");
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) { // Nếu mã phản hồi là 200 (OK)
                Scanner scanner = new Scanner(new InputStreamReader(connection.getInputStream()));
                scanner.useDelimiter("\\Z");
                String content = scanner.next();
                scanner.close();
                content = content.replaceAll("\n", "");

                Pattern pattern = Pattern.compile("name_song\">(.*?)</a>");
                Matcher matcher = pattern.matcher(content);
                while (matcher.find()) {
                    System.out.println(matcher.group(1));
                }
            } else {
                System.out.println("Lỗi: Mã phản hồi " + responseCode);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
