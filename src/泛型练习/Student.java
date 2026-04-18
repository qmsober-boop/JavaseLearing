package 泛型练习;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private String address;

    Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    Student()
    {

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address);
    }



    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
