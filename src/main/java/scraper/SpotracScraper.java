package scraper;

import java.util.List;

import model.ModelElement;

public abstract class SpotracScraper {
    private String url;

    public SpotracScraper(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public abstract List<SpotracScraper> scrapeTableForSubLinks();

    public abstract ModelElement getInfo();
}