package scraper;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;

public class SpotracScraper {

    public static List<String> getTeamLinks() throws IOException {
        return Jsoup.connect(SpotracUrls.rootUrl).get()
            .selectFirst(".teams")
            .selectFirst("tbody")
            .select("tr")
            .select("a")
            .stream().map(teamLinkElement -> {
                return teamLinkElement.attr("href");
            }).collect(Collectors.toList());
    }

    public static List<String> getPlayerLinks(String teamUrl) throws IOException {
        return Jsoup.connect(teamUrl).get()
            .select(".teams")
            .select("td.player")
            .select("a")
            .stream().map(playerLinkElement -> {
                return playerLinkElement.attr("href");
            }).collect(Collectors.toList());
    }
}