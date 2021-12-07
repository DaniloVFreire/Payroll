package Models.employees;

import Models.syndicates.Syndicate;

import java.util.UUID;

public abstract class Employee {
    private final UUID id;
    private String name;
    private String address;
    private String cpf;

    private Syndicate sindicate;
    protected String paymentMethod;
    protected double sindicalTax;

    public Employee(String _name, String _address, String _cpf){
        this.id = UUID.randomUUID();
        this.name = _name;
        this.address = _address;
        this.cpf = _cpf;
    }

    public String getCpf() {
        return cpf;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public UUID getId() {
        return id;
    }

    public void setSindicalTax(double sindicalTax) {
        if (sindicalTax >= 0){
            this.sindicalTax = sindicalTax;
        }
        else{
            System.out.println("The tax should be a positive number");
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString(){
        return this.name + this.address + this.cpf;
    }
}
