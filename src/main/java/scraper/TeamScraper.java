package scraper;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.ModelElement;
import model.Team;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

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
        try {
            Document document = Jsoup.connect(super.getUrl()).get();

            String redirectUrl = document.location();
            String[] redirectUrlArgs = redirectUrl.split("/");
            String teamID = redirectUrlArgs[redirectUrlArgs.length-2];

            Optional<Element> keywords = document.select("meta")
                .stream().filter(metaEle -> metaEle.attr("name").equals("keywords")).findFirst();
            if (!keywords.isPresent()) {
                return null;
            }
            String[] content = keywords.get().attr("content").split(", ");
            String city = content[2];
            String name = content[3];

            int payroll = 0; // implement
            return new Team(
                teamID,
                city,
                name,
                payroll);
        } catch (IOException e) {
            return null;
        }
    }
}
