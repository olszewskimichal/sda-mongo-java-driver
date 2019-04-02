package pl.michal.olszewski.connect;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoConnection {

  public static void main(String[] args) {
    MongoClient mongoClient = new MongoClient("localhost", 27017);
    for (Document document : mongoClient.listDatabases()) {
      System.out.println(document);
    }

    MongoDatabase database = mongoClient.getDatabase("test");
    for (String name : database.listCollectionNames()) {
      System.out.println(name);
    }

    mongoClient.close();
  }

}
