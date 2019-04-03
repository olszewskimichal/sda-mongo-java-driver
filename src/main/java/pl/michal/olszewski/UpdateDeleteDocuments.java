package pl.michal.olszewski;

import static com.mongodb.client.model.Filters.eq;
import static pl.michal.olszewski.MongoClientSingleton.INSTANCE;

import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.types.ObjectId;

public class UpdateDeleteDocuments {

  static void updateOne(String id) {
    INSTANCE.getDatabase().getCollection("persons")
        .updateOne(eq("_id", new ObjectId(id)), new Document("$set", new Document("name", "newName")));
  }

  static void deleteOne(String id) {
    DeleteResult deleteResult = INSTANCE.getDatabase().getCollection("persons")
        .deleteOne(eq("_id", new ObjectId(id)));
    System.out.println(deleteResult.getDeletedCount());
  }

  static void deleteAllByName(String name) {
    DeleteResult deleteResult = INSTANCE.getDatabase().getCollection("persons")
        .deleteMany(eq("name", name));
    System.out.println(deleteResult.getDeletedCount());
  }

  public static void main(String[] args) {
    //deleteOne("5ca5038025f88a71e45a5717");
    updateOne("5ca5043c36c26a37d940a5f5");
  }
}
