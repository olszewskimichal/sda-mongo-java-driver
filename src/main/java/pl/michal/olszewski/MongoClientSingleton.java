package pl.michal.olszewski;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public enum MongoClientSingleton {
  INSTANCE;
  private MongoClient mongoClient;

  MongoClientSingleton() {
    this.mongoClient = new MongoClient("localhost", 27017);
  }

  private MongoClient getMongoClient() {
    return mongoClient;
  }

  public MongoDatabase getDatabase(){
    return getMongoClient().getDatabase("test");
  }
}
