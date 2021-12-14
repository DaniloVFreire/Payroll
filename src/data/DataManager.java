package data;

import Models.employees.Commissioned;
import Models.employees.Employee;
import Models.employees.Hourly;
import Models.employees.Salaried;

import java.io.Serializable;
import java.util.ArrayList;

public class DataManager implements Serializable {
    //simulating a "database"
    public ArrayList<Employee> employees;
    public ArrayList<> paymentMethods;
    public DataManager(){
        this.employees = new ArrayList<>();
        this.employees.add(new Hourly("Horista", "endereco", "1"));
        this.employees.add(new Salaried("Assalariado", "endereco", "2"));
        this.employees.add(new Commissioned("Comissioned", "endereco", "3"));
    }
}
