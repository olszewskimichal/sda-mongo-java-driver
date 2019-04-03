package pl.michal.olszewski;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static pl.michal.olszewski.MongoClientSingleton.INSTANCE;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class SelectQuery {

  static List<Document> getAllDocumentsFromCollection(String collectionName) {
    return INSTANCE.getDatabase().getCollection(collectionName).find().into(new ArrayList<>());
  }

  static Document getPersonDocumentForName(String name) {
    return INSTANCE.getDatabase().getCollection("persons")
        .find(eq("name", name)).first();
  }

  static List<Document> getPersonsDocumentsForName(String name) {
    return INSTANCE.getDatabase().getCollection("persons")
        .find(eq("name", name)).into(new ArrayList<>());
  }

  static List<Document> getPersonsDocumentsForNameWithAgeGraterThan(String name, Long age) {
    return INSTANCE.getDatabase().getCollection("persons")
        .find(and(eq("name", name), gte("age", age))).into(new ArrayList<>());
  }

  public static void main(String[] args) {
    getAllDocumentsFromCollection("persons").forEach(System.out::println);
    System.out.println();
    System.out.println(getPersonDocumentForName("Imie"));
    System.out.println();
    getPersonsDocumentsForName("Imie").forEach(System.out::println);
    System.out.println();
    getPersonsDocumentsForNameWithAgeGraterThan("Imie",100L).forEach(System.out::println);
  }

}
