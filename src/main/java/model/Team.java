package model;

public class Team {
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
}
