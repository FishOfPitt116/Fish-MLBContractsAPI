package scraper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.ModelElement;
import model.Team;

import org.jsoup.nodes.Element;

public class TeamScraper extends SpotracScraper {
    private String teamID;

    public TeamScraper(String url) {
        super(url);
        this.teamID = super.getDocument().location().split("/")
            [super.getDocument().location().split("/").length-2];
    }

    @Override
    public List<SpotracScraper> scrapeTableForSubLinks() {
        return super.getDocument()
            .selectFirst(".teams")
            .selectFirst("tbody")
            .select("tr")
            .select("a")
            .stream().map(teamLinkElement -> {
                return new PlayerScraper(teamLinkElement.attr("href"), this.teamID);
            }).collect(Collectors.toList());
    }

    @Override
    public ModelElement getInfo() {
        Optional<Element> keywords = super.getDocument().select("meta")
            .stream().filter(metaEle -> metaEle.attr("name").equals("keywords")).findFirst();
        if (!keywords.isPresent()) {
            return null;
        }
        String[] content = keywords.get().attr("content").split(", ");
        String city = content[2];
        String name = content[3];

        int payroll = 0; // implement
        return new Team(
            this.teamID,
            city,
            name,
            payroll);
    }
}
