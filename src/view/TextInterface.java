package view;

import Models.employees.Employee;
import data.DataManager;

import java.util.Scanner;
import java.util.Stack;

import static controller.EmployeesController.*;

public class TextInterface {
    Stack<String> undo = new Stack<>();
    Stack<String> redo = new Stack<>();

    public static void logicMenu(DataManager data) {
        welcome();
        Scanner scanner = new Scanner(System.in);
        String input, cpf, name, address;
        int intInput;
        double doubleInput;
        //short shortImput;
        showFunctionalities();
        while (true) {
            switch (scanner.nextInt()) {
                case 0:
                    showFunctionalities();
                    break;
                case 1:
                    System.out.println("Enter the employee's name");
                    name = scanner.next();

                    System.out.println("Enter the employee's address:");
                    address = scanner.next();

                    System.out.print("""
                                Enter the employee's category :
                                Hourly 1
                                Salaried 2
                                Commissioned 3
                                """);
                    short category = scanner.nextShort();

                    System.out.println("Enter the employee's cpf(id) :");
                    cpf = scanner.next();

                    switch (createEmployee(data, name, address, cpf, category)) {
                        case 1 -> System.out.println("This employee cpf is already in use");
                        case 2 -> System.out.println("The employee's category does not exist");
                        default -> System.out.println("Employee successfully added");
                    }
                    break;
                case 2:
                    System.out.println("Enter the employee cpf:");
                    input = scanner.next();

                    if (deleteEmployee(data, input) == 1) {
                        System.out.println("Don't exist any Employee with the described cpf");
                    } else {
                        System.out.println("Deletion Successfully executed");
                    }
                    break;
                case 3:
                    System.out.println("Enter the employee cpf");
                    input = scanner.next();

                    System.out.println("Enter the worked hours");
                    intInput = scanner.nextInt();

                    switch (postTimeCard(data, input, intInput)){
                        case 1-> System.out.println("Don't exist any Employee with the described cpf");
                        case 2-> System.out.println("The select Employee is not an Hourly");
                        default -> System.out.println("Time card successfully posted");
                    }
                    break;
                case 4:
                    System.out.println("Enter the employee cpf:");
                    input = scanner.next();

                    System.out.println("Enter the sales value:");
                    doubleInput = scanner.nextDouble();

                    switch (postSalesResult(data, input, doubleInput)){
                        case 1-> System.out.println("Don't exist any Employee with the described cpf");
                        case 2-> System.out.println("The select Employee is not an Commissioned");
                        default -> System.out.println("Time card successfully posted");
                    }
                    break;
                case 5:
                    System.out.println("enter the employee cpf");
                    input = scanner.next();

                    System.out.println("enter the sindical tax");
                    doubleInput = scanner.nextDouble();

                    postServiceTax(data, input, doubleInput);

                    if (postServiceTax(data, input, doubleInput) == 1) {
                        System.out.println("Don't exist any Employee with the described cpf");
                    } else {
                        System.out.println("Service tax successfully posted");
                    }
                    break;
                case 6:
                        System.out.println("enter the employee cpf");
                        input = scanner.next();

                        System.out.println("""
                                Do you want to change the employee's cpf?
                                1 for yes
                                0 for no""");
                        intInput = scanner.nextInt();

                        if (intInput==1){
                            System.out.println("enter the employee's new cpf");
                            cpf = scanner.next();
                        }
                        else{
                            cpf = "-1";
                        }
                        intInput=0;

                        System.out.println("""
                                Do you want to change the employee's name?
                                1 for yes
                                0 for no""");
                        intInput = scanner.nextInt();
                        if (intInput==1){
                            System.out.println("enter the employee's new name");
                            name = scanner.next();
                        }
                        else{
                            name ="-1";
                        }

                        System.out.println("""
                                Do you want to change the employee's address?
                                1 for yes
                                0 for no""");

                        intInput = scanner.nextInt();
                        if (intInput==1){
                            System.out.println("enter the employee's new address:");
                            address = scanner.next();
                        }
                        else{
                            address="-1";
                        }

                        if(updateEmployee(data, input, cpf, name, address) == 1){
                            System.out.println("Don't exist any Employee with the described cpf");
                        }
                        else{
                            System.out.println("Time card successfully posted");
                        }
                    break;
                case 7:
                    runTodaysPayroll(data);
                    break;
                case 8://undo
                    
                    break;
                case 9://redo

                    break;
                case 10://change payment method

                    break;
                case 11://to create a new payment

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
                    0 to see the options
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
