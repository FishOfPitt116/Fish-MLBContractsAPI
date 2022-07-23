package scraper;

import java.util.List;
import java.util.Optional;

import model.Contract;
import model.ModelElement;

import org.jsoup.nodes.Element;

public class PlayerScraper extends SpotracScraper {
    private String teamID;
    private String playerID;
    
    public PlayerScraper(String url, String teamID) {
        super(url);
        this.teamID = teamID;
        System.out.println(super.getDocument().location());
        this.playerID = super.getDocument().location().split("/")
            [super.getDocument().location().split("/").length-1]
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
        return null; // add implementation
    }

    public Contract getContractInfo() {
        return null; // add implementation
    }
}
