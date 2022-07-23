package scraper;

import java.io.IOException;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import model.ModelElement;

public abstract class SpotracScraper {
    private String url;
    private Connection connection;
    private Document document;

    public SpotracScraper(String url) {
        this.url = url;
        this.connection = Jsoup.connect(url);
        try {
            this.document = this.connection.get();
        } catch (IOException e) {
            this.document = null;
        }
    }

    public String getUrl() {
        return this.url;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public Document getDocument() {
        return this.document;
    }

    public abstract List<SpotracScraper> scrapeTableForSubLinks();

    public abstract ModelElement getInfo();
}