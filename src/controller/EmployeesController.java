package controller;

import Models.employees.Commissioned;
import Models.employees.Employee;
import Models.employees.Hourly;
import data.DataManager;

public class EmployeesController {

    public void runTodaysPayroll(){

    }
    public static Employee foundEmployeeByCpf(String cpf, DataManager data){
        for (Employee employee : data.employees) {
            if (employee.getCpf().equals(cpf)) {
                return employee;
            }
        }
        return null;
    }
}
