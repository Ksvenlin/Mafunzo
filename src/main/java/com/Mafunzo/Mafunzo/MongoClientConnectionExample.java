package com.Mafunzo.Mafunzo;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Class that connects to MongoDB.
 *
 * @author Adam Mheisen, Kasper Svenlin, Kevin Nordkvist, Isak Hakola & William Starå
 */
public class MongoClientConnectionExample {
    public void connectMongo() {
        String connectionString = "mongodb+srv://mafunzo123:i2pFnieJAYeATgZk@mafunzo.b2ymue3.mongodb.net/?retryWrites=true&w=majority&appName=Mafunzo";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                MongoDatabase database = mongoClient.getDatabase("admin");
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. Mafunzo Web Application successfully connected to MongoDB!");
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
}