package Employees;

public class Employee {
    String name;
    String address;
    int id;

    public Employee(String name, String address, int id){
        this.name = name;
        this.address = address;
        this.id = id;
    }

    public void printEmployee() {
        System.out.print("[ " + this.name + ", " + this.address + ", " + this.id + " ]");
    }
}
