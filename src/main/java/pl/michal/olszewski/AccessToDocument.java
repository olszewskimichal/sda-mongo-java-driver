package pl.michal.olszewski;

import static pl.michal.olszewski.AccessCollections.getSingleCollection;

import java.util.Arrays;
import java.util.List;
import org.bson.Document;

public class AccessToDocument {

  public static void main(String[] args) {
    /*System.out.println(countAllDocumentsInCollection());
    insertOneDocument(createSimpleDocument());
    System.out.println(countAllDocumentsInCollection());*/

    insertOneDocument(new Document("name","Imie")
            .append("lastName","Nazwisko")
            .append("age",125),"persons");

    Document person1 = new Document("name", "Imie2")
            .append("lastName", "Nazwisko2")
            .append("age", 225);
    Document person2 = new Document("name", "Imie3")
            .append("lastName", "Nazwisko3")
            .append("age", 325);
    insertMultipleDocuments(Arrays.asList(person1,person2));


  }

  static Document createSimpleDocument() {
    return new Document("name", "MongoDB")
        .append("type", "database")
        .append("count", 1)
        .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
        .append("info", new Document("x", 203).append("y", 102));
  }

  static void insertOneDocument(Document document,String collectionName) {
    getSingleCollection(collectionName)
        .insertOne(document);
  }

  static void insertMultipleDocuments(List<Document> documentList) {
    getSingleCollection("persons")
        .insertMany(documentList);
  }

  static long countAllDocumentsInCollection() {
    return getSingleCollection("sample").countDocuments();
  }
}
