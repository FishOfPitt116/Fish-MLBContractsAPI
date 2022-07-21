package api;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import scraper.SpotracScraper;

public class PostRequests {
    public static void setup() {
        System.out.println("Setting up POST requests...");
    }

    public static void scrapeForData(Connection connection) throws IOException {
        List<String> teamUrls = SpotracScraper.getTeamLinks();

        Map<String, Integer> teamIds = teamUrls.stream().collect(Collectors.toMap(
            teamUrl -> teamUrl, teamUrl -> {
                String[] urlArgs = teamUrl.split("/");
                return Integer.parseInt(urlArgs[urlArgs.length-2]);
            }));

        Map<Integer, List<String>> playerUrls = teamUrls.stream().collect(Collectors.toMap(
            teamUrl -> teamIds.get(teamUrl), teamUrl -> {
                try {
                    return SpotracScraper.getPlayerLinks(teamUrl);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }));
    }

    
}