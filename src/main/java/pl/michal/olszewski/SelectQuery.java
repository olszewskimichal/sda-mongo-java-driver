package pl.michal.olszewski;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class SelectQuery {

  List<Document> getAllDocumentsFromCollection(String collectionName) {
    return MongoClientSingleton.INSTANCE.getDatabase().getCollection(collectionName).find().into(new ArrayList<>());
  }

  Document getPersonDocumentForName(String name) {
    return MongoClientSingleton.INSTANCE.getDatabase().getCollection("persons")
        .find(eq("name", name)).first();
  }

  List<Document> getPersonsDocumentsForName(String name) {
    return MongoClientSingleton.INSTANCE.getDatabase().getCollection("persons")
        .find(eq("name", name)).into(new ArrayList<>());
  }

  List<Document> getPersonsDocumentsForNameWithAgeGraterThan(String name, Long age) {
    return MongoClientSingleton.INSTANCE.getDatabase().getCollection("persons")
        .find(and(eq("name", name), gte("age", age))).into(new ArrayList<>());
  }


}
