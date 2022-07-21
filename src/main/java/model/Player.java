package model;

public class Player {
    private String playerID;
    private String lastName;
    private String firstName;
    private String position;
    private String teamID;
    private int age;
    private double serviceTime;
    private boolean active;

    public Player(String playerID, String lastName, String firstName, String position, String teamID, int age, double serviceTeam, boolean active) {
            this.playerID = playerID;
            this.lastName = lastName;
            this.firstName = firstName;
            this.position = position;
            this.teamID = teamID;
            this.age = age;
            this.serviceTime = serviceTime;
            this.active = active;
    }
    
    public String getPlayerID() {
        return this.playerID;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getPosition() {
        return this.position;
    }

    public String getTeamID() {
        return this.teamID;
    }

    public int getAge() {
        return this.age;
    }

    public double getServiceTime() {
        return this.serviceTime;
    }

    public boolean getActive() {
        return this.active;
    }
}
