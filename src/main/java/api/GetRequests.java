package api;

import static spark.Spark.*;

import java.sql.Connection;

public class GetRequests {
    private Connection connection;

    public GetRequests(Connection connection) {
        this.connection = connection;
    }

    public void setup() {
        System.out.println("Setting up GET requests...");
        // get("/hello", (req, res) -> "Hello world");
    }

    public void end() {
        System.out.println("Shutting down GET requests...");
        stop();
        System.out.println("Requests stopped.");
    }
}