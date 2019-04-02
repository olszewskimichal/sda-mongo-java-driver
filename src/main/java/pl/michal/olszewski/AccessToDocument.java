package pl.michal.olszewski;

import java.util.Arrays;
import java.util.List;
import org.bson.Document;

public class AccessToDocument {

  static Document createSimpleDocument() {
    return new Document("name", "MongoDB")
        .append("type", "database")
        .append("count", 1)
        .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
        .append("info", new Document("x", 203).append("y", 102));
  }

  static void insertOneDocument(Document document) {
    AccessCollections.getSingleCollection("persons")
        .insertOne(document);
  }

  static void insertMultipleDocuments(List<Document> documentList) {
    AccessCollections.getSingleCollection("persons")
        .insertMany(documentList);
  }

  static long countAllDocumentsInCollection() {
    return AccessCollections.getSingleCollection("persons").countDocuments();
  }
}
