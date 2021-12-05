package Models.employees;

public class Salaried extends Employee {
    private double salary;
    public Salaried(String _name, String _address, String _cpf){
        super(_name, _address, _cpf);
        salary = 1000;
    }

    public void salaryDefinition(double _salary){
        this.salary = _salary;
    }

    public void pay(){
        System.out.println("The employee " + this.getName() +" has been payed in: R$" + salary);
    }

    @Override
    public String toString(){
        return super.getName()+ " " + super.getAddress() + " " +super.getCpf();
    }
}
