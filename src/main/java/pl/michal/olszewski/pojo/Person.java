package pl.michal.olszewski.pojo;

import org.bson.types.ObjectId;

public class Person {

  private ObjectId id;
  private String name;
  private String lastName;
  private Integer age;

  public Person() {
  }

  public Person( String name, String lastName, Integer age) {
    this.name = name;
    this.lastName = lastName;
    this.age = age;
  }

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", age=" + age +
            '}';
  }
}
