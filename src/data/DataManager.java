package data;

import Models.employees.Commissioned;
import Models.employees.Employee;
import Models.employees.Hourly;
import Models.employees.Salaried;

import java.util.ArrayList;

public class DataManager {
    //simulating a "database"
    public ArrayList<Employee> employees = new ArrayList<>();
    public DataManager(){
        this.employees.add(new Hourly("Horista", "endereco", "1"));
        this.employees.add(new Salaried("Assalariado", "endereco", "2"));
        this.employees.add(new Commissioned("Comissioned", "endereco", "3"));
    }
}
