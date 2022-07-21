package api;

import static spark.Spark.*;

public class GetRequests {
    public static void setup() {
        System.out.println("Setting up GET requests...");
        // get("/hello", (req, res) -> "Hello world");
    }
}