package Models.employees;

import Models.syndicates.Syndicate;

import java.util.UUID;

public abstract class Employee {
    private UUID id;
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

    @Override
    public String toString(){
        return this.name + this.address + this.cpf;
    }
}
