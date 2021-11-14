package Employees;

public class Hourly extends Employee {
    private double salary;
    private double paymentTax;
    public Hourly(String _name, String _address, String _cpf){
        super(_name, _address, _cpf);
        this.salary = 0;
        this.paymentTax = 100.00;
    }

    public void postTimeCard(int horasTrabalhadas){
        if(horasTrabalhadas>=0){
            if (horasTrabalhadas <= 8){
                this.salary += paymentTax * horasTrabalhadas;
            }
            else{
                this.salary += paymentTax * 8;
                this.salary += (paymentTax * 1.5) * (horasTrabalhadas - 8);
            }
        }
        else{
            System.out.println("Error, the time should be positive!");
        }
    }
    public void pay(){
        System.out.println("The employee " + this.name +" has been payed");
    }
}
