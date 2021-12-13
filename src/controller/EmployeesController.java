package controller;

import Models.employees.Commissioned;
import Models.employees.Employee;
import Models.employees.Hourly;
import Models.employees.Salaried;
import data.DataManager;

public class EmployeesController {

    public static void runTodaysPayroll(DataManager data){
        for (Employee employee : data.employees) {
            employee.pay();
        }
    }

    public static short updateEmployee(DataManager data, String cpf,String newCpf, String name, String address){
        cpf = validateAndFormatCpf(cpf);
        Employee selected = findEmployeeByCpf(data, cpf);
        if (selected == null){
            return 1;
        }
        else{
            if(!newCpf.equals("-1")){
                selected.setCpf(newCpf);
            }
            if(!name.equals("-1")){
                selected.setName(name);
            }
            if(!address.equals("-1")){
                selected.setAddress(address);
            }
        }
        return 0;
    }

    public static short postServiceTax(DataManager data, String cpf, double value){
        cpf = validateAndFormatCpf(cpf);
        Employee selected = findEmployeeByCpf(data, cpf);
        if (selected == null){
            return 1;
        }
        else{
            selected.setSindicalTax(value);
        }
        return 0;
    }

    public static short postSalesResult(DataManager data, String cpf, double value){
        cpf = validateAndFormatCpf(cpf);
        Employee selected = findEmployeeByCpf(data, cpf);
        if (selected == null){
            return 1;
        }
        else{
            if(selected instanceof Commissioned){
                ((Commissioned)selected).postSalesResult(value);
            }
            else {
                return 2;
            }
        }
        return 0;
    }

    public static short postTimeCard(DataManager data, String cpf, int time){
        cpf = validateAndFormatCpf(cpf);
        Employee selected = findEmployeeByCpf(data, cpf);
        if (selected == null){
            return 1;
        }
        else{
            if(selected instanceof Hourly){
                ((Hourly)selected).postTimeCard(time);
            }
            else {
                return 2;
            }
        }
        return 0;
    }

    public static short deleteEmployee(DataManager data, String cpf){
        final String treatedCpf = validateAndFormatCpf(cpf);
        if(findEmployeeByCpf(data, treatedCpf) == null){
            return 1;
        }
        else{
            data.employees.removeIf(employee -> employee.getCpf().equals(treatedCpf));
        }
        return 0;
    }

    public static short createEmployee(DataManager data, String name, String address, String cpf, short type){
        cpf = validateAndFormatCpf(cpf);
        if(findEmployeeByCpf(data, cpf)==null){
            switch (type){
                case 1:
                    data.employees.add(new Hourly(name, address, cpf));
                    break;
                case 2:
                    data.employees.add(new Salaried(name, address, cpf));
                    break;
                case 3:
                    data.employees.add(new Commissioned(name, address, cpf));
                    break;
                default:
                    return 2;
            }
        }
        else{
            return 1;
        }

        return 0;
    }

    public static String validateAndFormatCpf(String cpf){
        String newCpf = cpf.replaceAll(" ", "");
        newCpf = newCpf.replaceAll(".", "");
        return newCpf;
    }

    public static Employee findEmployeeByCpf(DataManager data, String cpf){
        cpf = validateAndFormatCpf(cpf);
        for (Employee employee : data.employees) {
            if (employee.getCpf().equals(cpf)) {
                return employee;
            }
        }
        return null;
    }
}
