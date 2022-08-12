package model;

public class Contract implements ModelElement {
    private String contractID;
    private String playerID;
    private String teamID;
    private int startYear;
    private int endYear;
    private int avgSalary;
    private int signingBonus;

    public Contract(String contractID, String playerID, String teamID, int startYear, int endYear, int avgSalary, int signingBonus) {
        this.contractID = contractID;
        this.playerID = playerID;
        this.teamID = teamID;
        this.startYear = startYear;
        this.endYear = endYear;
        this.avgSalary = avgSalary;
        this.signingBonus = signingBonus;
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

    public int getAvgSalary() {
        return this.avgSalary;
    }

    public int getSigningBonus() {
        return this.signingBonus;
    }
}
