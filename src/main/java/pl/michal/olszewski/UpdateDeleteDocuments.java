package pl.michal.olszewski;

import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

public class UpdateDeleteDocuments {

  void updateOne(String id) {
    MongoClientSingleton.INSTANCE.getDatabase().getCollection("persons")
        .updateOne(eq("id", id), new Document("$set", new Document("name", "newName")));
  }

  void deleteOne(String id) {
    DeleteResult deleteResult = MongoClientSingleton.INSTANCE.getDatabase().getCollection("persons")
        .deleteOne(eq("id", id));
    System.out.println(deleteResult.getDeletedCount());
  }

  void deleteAllByName(String name) {
    DeleteResult deleteResult = MongoClientSingleton.INSTANCE.getDatabase().getCollection("persons")
        .deleteMany(eq("name", name));
    System.out.println(deleteResult.getDeletedCount());
  }
}
