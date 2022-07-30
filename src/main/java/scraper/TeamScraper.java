package scraper;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
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

        Element payrollElement = super.getDocument().select("span")
            .stream().filter(spanEle -> spanEle.text().contains("Total Payroll:")).findFirst()
            .get();
        String payrollText = payrollElement.parent().selectFirst("strong").text();
        try {
            int payroll = NumberFormat.getNumberInstance(Locale.US).parse(payrollText.substring(1)).intValue();
            return new Team(
                this.teamID,
                city,
                name,
                payroll);
        } catch (ParseException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
}
