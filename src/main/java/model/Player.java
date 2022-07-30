package model;

public class Player implements ModelElement {
    private String playerID;
    private String lastName;
    private String firstName;
    private String position;
    private String teamID;
    private int age;
    private double serviceTime;
    private boolean active;

    public Player(String playerID, String lastName, String firstName, String position, String teamID, int age, double serviceTime, boolean active) {
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

    public String toString() {
        return String.format("Player Object: {\n\tID: %s,\n\tlastName: %s,\n\tfirstName: %s,\n\tposition: %s,\n\tteamID: %s,\n\tage: %s,\n\tserviceTime: %s,\n\tisActive: %s\n}",
            this.playerID,
            this.lastName,
            this.firstName,
            this.position,
            this.teamID,
            this.age,
            this.serviceTime,
            this.active);
    }
}
