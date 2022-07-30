package model;

public class Team implements ModelElement {
    private String teamID;
    private String city;
    private String name;
    private int payroll;

    public Team(String teamID, String city, String name, int payroll) {
        this.teamID = teamID;
        this.city = city;
        this.name = name;
        this.payroll = payroll;
    }

    public String getTeamID() {
        return this.teamID;
    }

    public String getCity() {
        return this.city;
    }

    public String getName() {
        return this.name;
    }

    public int getPayroll() {
        return this.payroll;
    }

    public String toString() {
        return String.format("Team Object: {\n\tID: %s\n\tCity: %s\n\tName: %s\n\tPayroll: %s\n}",
            this.teamID,
            this.city,
            this.name,
            this.payroll);
    }
}
