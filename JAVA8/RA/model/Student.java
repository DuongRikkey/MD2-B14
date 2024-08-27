package JAVA8.RA.model;

import JAVA8.RA.inf.IOFILE;

public class Student implements IOFILE {
    private int studentid;
    private String name;
    private int age;

    public Student() {
    }

    public Student(int studentid, String name, int age) {
        this.studentid = studentid;
        this.name = name;
        this.age = age;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
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

    @Override
    public void inputData() {

    }

    @Override
    public void displayData() {

    }

    @Override
    public int sum(int a, int b) {
         return a*a + b;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
