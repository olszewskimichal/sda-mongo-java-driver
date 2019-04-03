package pl.michal.olszewski;

import static pl.michal.olszewski.MongoClientSingleton.INSTANCE;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class AccessCollections {

  static MongoCollection<Document> getSingleCollection(String collectionName) {
    return INSTANCE.getDatabase().getCollection(collectionName);
  }

  public static void createCollection(String collectionName) {
    INSTANCE.getDatabase().createCollection(collectionName);
  }

  public static void dropCollection(String collectionName) {
    INSTANCE.getDatabase().getCollection(collectionName).drop();
  }

  public static void listCollections() {
    for (String collectionName : INSTANCE.getDatabase().listCollectionNames()) {
      System.out.println(collectionName);
    }
  }


}
