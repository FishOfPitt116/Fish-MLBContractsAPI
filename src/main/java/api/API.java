package api;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import scraper.SpotracUrls;

public class API {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        Connection connection = connectSQL();
        PostRequests postRequests = new PostRequests(SpotracUrls.rootUrl, connection);
        if (args.length > 0 && args[0].equals("init")) {
            postRequests.request();
        }
        // GetRequests.setup();
    }

    public static Connection connectSQL() throws ClassNotFoundException, SQLException {
        System.out.println("Initializing SQL tables...");
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://castor.db.elephantsql.com:5432/ipilvxrl";

        // Admin Postgres Credentials must be set via environment variables
        Properties properties = new Properties();
        properties.setProperty("user", System.getenv("USER"));
        properties.setProperty("password", System.getenv("PASSWORD"));

        Connection connection = DriverManager.getConnection(url, properties);
        System.out.println("Successfully connected to JDBC");

        return connection;
    }
}