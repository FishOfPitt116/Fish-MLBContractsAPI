package scraper;

import java.util.List;
import java.util.stream.Collectors;

import model.ModelElement;

public class RootScraper extends SpotracScraper {

    public RootScraper(String url) {
        super(url);
    }

    @Override
    public List<SpotracScraper> scrapeTableForSubLinks() {
        return super.getDocument()
            .selectFirst(".teams")
            .selectFirst("tbody")
            .select("tr")
            .select("a")
            .stream().map(teamLinkElement -> {
                return new TeamScraper(teamLinkElement.attr("href"));
            }).collect(Collectors.toList());
    }

    @Override
    public ModelElement getInfo() {
        return null;
    }
}
