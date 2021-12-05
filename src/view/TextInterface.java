package view;

import Models.employees.Commissioned;
import Models.employees.Employee;
import Models.employees.Hourly;
import Models.employees.Salaried;

import java.util.Scanner;
import java.util.Stack;

import controller.EmployeesController;
import data.DataManager;

public class TextInterface {
    Stack<String> undo = new Stack<>();
    Stack<String> redo = new Stack<>();

    public static void logicMenu(DataManager data) {
        welcome();
        Scanner scanner = new Scanner(System.in);
        String input;
        int intInput;
        double doubleInput;
        while (true) {
            showFunctionalities();
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Enter the employee's name");
                    String nome = scanner.next();

                    System.out.println("Enter the employee's address:");
                    String address = scanner.next();
                    while (true) {
                        System.out.print("""
                                Enter the employee's category :
                                Hourly 1
                                Salaried 2
                                Commissioned 3
                                """);
                        int category = scanner.nextInt();

                        System.out.println("Enter the employee's cpf(id) :");
                        String cpf = scanner.next();
                        int flag=0;
                        for (Employee employee : data.employees) {
                            if (employee.getCpf().equals(cpf)){
                                System.out.println("The system already has these id");
                                flag = -1;
                                break;
                            }
                        }
                        if(flag==-1){
                            break;
                        }
                        else if (category == 1) {
                            data.employees.add(new Hourly(nome, address, cpf));
                            System.out.println("The employee was successfully added, it data is: " + data.employees.get(data.employees.size()-1).toString());
                            break;
                        } else if (category == 2) {
                            data.employees.add(new Salaried(nome, address, cpf));
                            System.out.println("The employee was successfully added, it data is: " + data.employees.get(data.employees.size()-1).toString());
                            break;
                        } else if (category == 3) {
                            data.employees.add(new Commissioned(nome, address, cpf));
                            System.out.println("The employee was successfully added, it data is: " + data.employees.get(data.employees.size()-1).toString());
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter the employee cpf:");
                    String id = scanner.next();
                    data.employees.removeIf(employee -> employee.getCpf().equals(id));

                    break;
                case 3:
                    System.out.println("Enter the employee cpf");
                    input = scanner.next();
                    for (Employee employee : data.employees) {
                        if (employee.getCpf().equals(input)  && employee instanceof Hourly){
                            System.out.println("Enter the worked hours");
                            intInput = scanner.nextInt();
                            ((Hourly)employee).postTimeCard(intInput);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter the employee cpf");
                    input = scanner.next();
                    for (Employee employee : data.employees) {
                        if (employee.getCpf().equals(input)  && employee instanceof Commissioned){
                            System.out.println("Enter the sales ");
                            doubleInput = scanner.nextDouble();
                            ((Commissioned) employee).postSalesResult(doubleInput);
                        }
                    }
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
                    System.out.println("   name   |   address   |   cpf   ");
                    for (Employee employee : data.employees) {
                        System.out.println(employee);
                    }
                    System.out.println();
                    break;
                case 13:
                    return;
            }
        }
    }

    public static void showFunctionalities(){
        System.out.print("""
                    Functionalities
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
                    12 See employees data
                    13 to exit
                    """);
    }

    public static void welcome(){
        System.out.println("""
                __          __  _                            _                      \s
                     \\ \\        / / | |                          | |                     \s
                      \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___  | |_ ___                \s
                       \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\               \s
                        \\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) |              \s
                         \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/               \s
                      _____                      _ _    _____           _                \s
                     |  __ \\                    | | |  / ____|         | |               \s
                     | |__) |_ _ _   _ _ __ ___ | | | | (___  _   _ ___| |_ ___ _ __ ___ \s
                     |  ___/ _` | | | | '__/ _ \\| | |  \\___ \\| | | / __| __/ _ \\ '_ ` _ \\\s
                     | |  | (_| | |_| | | | (_) | | |  ____) | |_| \\__ \\ ||  __/ | | | | |
                     |_|   \\__,_|\\__, |_|  \\___/|_|_| |_____/ \\__, |___/\\__\\___|_| |_| |_|
                                  __/ |                        __/ |                     \s
                                 |___/                        |___/                      \s""");
    }
}
