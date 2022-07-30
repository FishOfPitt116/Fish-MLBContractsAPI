package scraper;

import java.util.List;
import java.util.Optional;

import model.Contract;
import model.ModelElement;
import model.Player;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.jsoup.nodes.Element;

public class PlayerScraper extends SpotracScraper {
    private String teamID;
    private String playerID;
    
    public PlayerScraper(String url, String teamID) {
        super(url);
        this.teamID = teamID;
        this.playerID = super.getDocument().location().split("/")
            [super.getDocument().location().split("/").length-1];
    }

    @Override
    public List<SpotracScraper> scrapeTableForSubLinks() {
        return null;
    }

    @Override
    public ModelElement getInfo() {
        Optional<Element> keywords = super.getDocument().select("meta")
            .stream().filter(metaEle -> metaEle.attr("name").equals("keywords")).findFirst();
        if (!keywords.isPresent()) {
            return null;
        }
        String[] content = keywords.get().attr("content").split(", ");
        String[] names = content[0].split(" ");
        String lastName = names[1];
        String firstName = names[0];

        Elements playerItems = super.getDocument()
            .select("span.player-item");
        
        Optional<Element> ageElementHeader = playerItems
            .select("strong")
            .stream().filter(ele -> ele.text().contains("Age:")).findFirst();
        if (!ageElementHeader.isPresent()) {
            return null;
        }
        Element ageElement = ageElementHeader.get().nextElementSibling();
        String ageStr = ageElement.text().replaceAll("\\s+","").replace("-", ".");
        double ageDouble = Double.parseDouble(ageStr.substring(0, ageStr.length()-1));
        int age = (int) ageDouble;

        Optional<Element> serviceTimeElementHeader = playerItems
            .select("strong")
            .stream().filter(ele -> ele.text().contains("Exp:")).findFirst();
        if (!serviceTimeElementHeader.isPresent()) {
            return null;
        }
        Element serviceTimeElement = serviceTimeElementHeader.get().nextElementSibling();
        String serviceTimeText = serviceTimeElement.text().split(" ")[0];
        double serviceTime = 0;
        if (!serviceTimeText.contains("Years")) {
            serviceTime = Double.parseDouble(serviceTimeText);
        }

        return new Player(
            this.playerID, 
            lastName,
            firstName,
            null, // implement PositionScraper
            this.teamID,
            age,
            serviceTime,
            true);
    }

    public Contract getContractInfo() {
        return null; // add implementation
    }
}
