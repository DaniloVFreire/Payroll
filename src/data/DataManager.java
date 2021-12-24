package data;

import Models.employees.Commissioned;
import Models.employees.Employee;
import Models.employees.Hourly;
import Models.employees.Salaried;
import Models.payment.PaymentSchedule;

import java.io.Serializable;
import java.util.ArrayList;

public class DataManager implements Serializable {
    //simulating a "database"
    public ArrayList<Employee> employees;
    public ArrayList<String> paymentMethods;
    public ArrayList<PaymentSchedule> paymentSchedules;
    //public ArrayList<PaymentHistoric>

    public DataManager(){
        this.paymentMethods = new ArrayList<>();
        this.paymentMethods.add("the check by post");
        this.paymentMethods.add("the check in hands");
        this.paymentMethods.add("bank account deposit");

        this.paymentSchedules = new ArrayList<>();
        this.paymentSchedules.add(new PaymentSchedule(1, 5));
        this.paymentSchedules.add(new PaymentSchedule(0));
        this.paymentSchedules.add(new PaymentSchedule(2, 5));

        this.employees = new ArrayList<>();
        this.employees.add(new Hourly("Horista", "endereco", "1", paymentSchedules.get(0), ));
        this.employees.add(new Salaried("Assalariado", "endereco", "2"));
        this.employees.add(new Commissioned("Comissioned", "endereco", "3"));
    }
}
