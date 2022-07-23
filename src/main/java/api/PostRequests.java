package api;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import model.Team;
import scraper.RootScraper;
import scraper.SpotracScraper;

public class PostRequests {
    private SpotracScraper rootScraper;
    private Connection connection;

    public PostRequests(String rootUrl, Connection connection) {
        System.out.println("Setting up POST requests...");
        this.rootScraper = new RootScraper(rootUrl);
        this.connection = connection; // will be used for storing info to postgres
    }

    public void request() {
        // getTeamUrls
        System.out.println("Getting Team URLs");
        List<SpotracScraper> teamScrapers = this.rootScraper.scrapeTableForSubLinks();

        // getTeamInfo
        System.out.println("Getting Team Info");
        List<Team> teamInfo = new ArrayList<>();
        teamScrapers.forEach(teamScraper -> teamInfo.add((Team) teamScraper.getInfo()));

        // getPlayerUrls
        System.out.println("Getting Player URLs");
        List<SpotracScraper> playerScrapers = new ArrayList<>();
        teamScrapers.forEach(teamScraper -> playerScrapers.addAll(teamScraper.scrapeTableForSubLinks()));

        // getPlayerInfo

        // getContractInfo

        // storeTeamInfo

        // storePlayerInfo

        // storeContractInfo


    }

    // public static void scrapeForData(Connection connection) throws IOException {
    //     List<String> teamUrls = SpotracScraper.getTeamLinks();

    //     Map<String, Integer> teamIds = teamUrls.stream().collect(Collectors.toMap(
    //         teamUrl -> teamUrl, teamUrl -> {
    //             String[] urlArgs = teamUrl.split("/");
    //             return Integer.parseInt(urlArgs[urlArgs.length-2]);
    //         }));

    //     Map<Integer, List<String>> playerUrls = teamUrls.stream().collect(Collectors.toMap(
    //         teamUrl -> teamIds.get(teamUrl), teamUrl -> {
    //             try {
    //                 return SpotracScraper.getPlayerLinks(teamUrl);
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //                 return null;
    //             }
    //         }));
    // }

    
}