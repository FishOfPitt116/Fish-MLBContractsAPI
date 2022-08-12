package api;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test {
    public static void test() throws IOException {
        try {
            Document document = Jsoup.connect("https://www.spotrac.com/mlb/los-angeles-angels/mike-trout-8553/").get();
            Elements years = document.getElementsByClass("playerTable");
            Elements contract = document.getElementsByClass("salaryTable salaryInfo hidden-xs");
            Elements currentTable = document.getElementsByClass("salaryTable current");
            System.out.println(years.size());
            System.out.println(contract.size());
            System.out.println(currentTable.size());
        } catch (IOException e) {

        }
    }
}
