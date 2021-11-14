package Employees;

public class Commissioned extends Employee {
    private double comission;
    private double salary;

    public Commissioned(String _name, String _address, String _cpf){
        super(_name, _address, _cpf);
    }
    public void pay(){
        System.out.println("The employee " + this.name +" has been payed");
    }
}
