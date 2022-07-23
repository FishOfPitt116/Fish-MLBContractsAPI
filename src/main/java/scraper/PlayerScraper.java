package scraper;

import java.util.List;

import model.ModelElement;

public class PlayerScraper extends SpotracScraper {
    public PlayerScraper(String url) {
        super(url);
    }

    @Override
    public List<SpotracScraper> scrapeTableForSubLinks() {
        return null;
    }

    @Override
    public ModelElement getInfo() {
        return null; // add implementation
    }
}
