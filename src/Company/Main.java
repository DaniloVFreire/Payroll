package Company;

import Employees.Commissioned;
import Employees.Employee;
import Employees.Hourly;
import Employees.Salaried;

import Interface.TextMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList <Employee> employees = new ArrayList<>();

        employees.add(new Hourly("Horista", "endereco", "1"));
        employees.add(new Salaried("Assalariado", "endereco", "2"));
        employees.add(new Commissioned("Comissioned", "endereco", "3"));

        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while(run){
            System.out.print("""
                Payroll system:
                1 to add an Employee
                2 to remove an Employee
                3 to post a time card
                4 to post a sales result
                5 to post a service tax
                6 to change a Employee's details
                7 to run payroll for today
                8 to undo
                9 to redo
                10 To change the payment schedule
                11 To create a new payment schedule
                12 to exit
                """);

            for (Employee employee : employees) {
                employee.print();
            }
            System.out.println();

            int choiceInput = scanner.nextInt();
            System.out.println(choiceInput);

            switch (choiceInput) {
                case 1:
                    System.out.println("Enter the employee name\n");
                    String nome = scanner.next();

                    System.out.print("Enter the employee's:\n");
                    String address = scanner.next();
                    while(true) {
                        System.out.print("""
                            Enter the employee's category :
                            Hourly 1
                            Salaried 2
                            Commissioned 3
                            """);
                        int category = scanner.nextInt();

                        System.out.print("Enter the employee's cpf(id) :\n");
                        String cpf = scanner.next();

                        if (category == 1) {
                            employees.add(new Hourly(nome, address, cpf));
                            break;
                        } else if (category == 2) {
                            employees.add(new Salaried(nome, address, cpf));
                            break;
                        } else if (category == 3) {
                            employees.add(new Commissioned(nome, address, cpf));
                            break;
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Enter the employee cpf(id):");
                    String id = scanner.next();
                    employees.removeIf(employee -> employee.cpf.equals(id));

                    break;
                case 3:

                    break;
                case 4:


                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;
                case 12:
                    run = false;
                    break;
            }
        }
    }
}
