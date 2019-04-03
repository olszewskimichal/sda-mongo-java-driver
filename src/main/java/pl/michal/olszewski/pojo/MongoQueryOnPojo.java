package pl.michal.olszewski.pojo;

import static com.mongodb.client.model.Filters.eq;
import static pl.michal.olszewski.MongoClientSingleton.INSTANCE;

import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;

public class MongoQueryOnPojo {

  MongoCollection<Person> getPersonCollection() {
    return INSTANCE.getDatabase().getCollection("persons", Person.class);
  }

  void insertPerson(Person person) {
    getPersonCollection().insertOne(person);
  }

  void insertManyPersons(List<Person> personList) {
    getPersonCollection().insertMany(personList);
  }

  List<Person> getAllPersons() {
    return getPersonCollection().find().into(new ArrayList<>());
  }

  Person getPersonById(String id) {
    return getPersonCollection().find(eq("id", id)).first();
  }

}
