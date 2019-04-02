package pl.michal.olszewski;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class AccessCollections {

  public static MongoCollection<Document> getSingleCollection(String collectionName) {
    return MongoClientSingleton.INSTANCE.getDatabase().getCollection(collectionName);
  }

  public static void createCollection(String collectionName) {
    MongoClientSingleton.INSTANCE.getDatabase().createCollection(collectionName);
  }

  public static void dropCollection(String collectionName) {
    MongoClientSingleton.INSTANCE.getDatabase().getCollection(collectionName).drop();
  }

  public static void listCollections() {
    for (String collectionName : MongoClientSingleton.INSTANCE.getDatabase().listCollectionNames()) {
      System.out.println(collectionName);
    }
  }


}
