package Models.employees;

import Models.salesResults.SaleResult;

import java.util.ArrayList;

public class Commissioned extends Salaried {
    private double commissionTax;
    private ArrayList<SaleResult> salesResult = new ArrayList<SaleResult>();
    public Commissioned(String _name, String _address, String _cpf){
        super(_name, _address, _cpf);
    }
    public void pay(){
        System.out.println("The employee " + this.getName() +" has been payed");
    }
    public void postSalesResult(double saleValue){
        salesResult.add(new SaleResult(saleValue));
    }
    @Override
    public String toString(){
        return super.getName()+ " " + super.getAddress() + " " +super.getCpf();
    }
}
