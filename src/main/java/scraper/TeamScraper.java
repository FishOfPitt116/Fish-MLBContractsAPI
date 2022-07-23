package scraper;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import model.ModelElement;

import org.jsoup.Jsoup;

public class TeamScraper extends SpotracScraper {
    public TeamScraper(String url) {
        super(url);
    }

    @Override
    public List<SpotracScraper> scrapeTableForSubLinks() {
        try {
            return Jsoup.connect(super.getUrl()).get()
                .selectFirst(".teams")
                .selectFirst("tbody")
                .select("tr")
                .select("a")
                .stream().map(teamLinkElement -> {
                    return new PlayerScraper(teamLinkElement.attr("href"));
                }).collect(Collectors.toList());
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public ModelElement getInfo() {
        return null; // add implementation
    }
}
