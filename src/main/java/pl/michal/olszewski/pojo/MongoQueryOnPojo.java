package pl.michal.olszewski.pojo;

import static com.mongodb.client.model.Filters.eq;
import static pl.michal.olszewski.pojo.MongoPojoClientSingleton.INSTANCE;

import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class MongoQueryOnPojo {

  static MongoCollection<Person> getPersonCollection() {
    return INSTANCE.getDatabase().getCollection("persons", Person.class);
  }

  static void insertPerson(Person person) {
    getPersonCollection().insertOne(person);
  }

  static void insertManyPersons(List<Person> personList) {
    getPersonCollection().insertMany(personList);
  }

  static List<Person> getAllPersons() {
    return getPersonCollection().find().into(new ArrayList<>());
  }

  static Person getPersonById(String id) {
    return getPersonCollection().find(eq("_id", new ObjectId(id))).first();
  }


  public static void main(String[] args) {
    //insertPerson(new Person("abc","cde",125));
    getAllPersons().forEach(System.out::println);
  }
}
