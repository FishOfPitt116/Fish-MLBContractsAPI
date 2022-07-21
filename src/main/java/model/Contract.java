package model;

import java.util.List;

public class Contract {
    private String contractID;
    private String playerID;
    private String teamID;
    private int startYear;
    private int endYear;
    private List<Integer> salaries;
    private int bonus;

    public Contract(String contractID, String playerID, String teamID, int startYear, int endYear, List<Integer> salaries, int bonus) {
        this.contractID = contractID;
        this.playerID = playerID;
        this.teamID = teamID;
        this.startYear = startYear;
        this.endYear = endYear;
        this.salaries = salaries;
        this.bonus = bonus;
    }

    public String getContractID() {
        return this.contractID;
    }

    public String getPlayerID() {
        return this.playerID;
    }

    public String getTeamID() {
        return this.teamID;
    }

    public int getStartYear() {
        return this.startYear;
    }

    public int getEndYear() {
        return this.endYear;
    }

    public List<Integer> getSalaries() {
        return this.salaries;
    }

    public int bonus() {
        return this.bonus;
    }
}
