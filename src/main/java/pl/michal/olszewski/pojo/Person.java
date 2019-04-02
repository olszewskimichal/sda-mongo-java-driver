package pl.michal.olszewski.pojo;

public class Person {

  private String id;
  private String name;
  private String lastName;
  private Long age;

  public Person() {
  }

  public Person(String id, String name, String lastName, Long age) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.age = age;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  public Long getAge() {
    return age;
  }

  public void setAge(Long age) {
    this.age = age;
  }
}
