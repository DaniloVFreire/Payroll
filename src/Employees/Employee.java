package Employees;

public class Employee {
    public String name;
    public String address;
    public String cpf;

    public Employee(String _name, String _address, String _cpf){
        this.name = _name;
        this.address = _address;
        this.cpf = _cpf;
    }

    public void printEmployee() {
        System.out.print("[ " + this.name + ", " + this.address + ", " + this.cpf + " ]");
    }
}
