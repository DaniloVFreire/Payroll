package data;

import Models.Commissioned;
import Models.Employee;
import Models.Hourly;
import Models.Salaried;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class DataManager {
    //simulating a "database"
    public ArrayList<Employee> employees = new ArrayList<>();
    public DataManager(){
        this.employees.add(new Hourly("Horista", "endereco", "1"));
        this.employees.add(new Salaried("Assalariado", "endereco", "2"));
        this.employees.add(new Commissioned("Comissioned", "endereco", "3"));
    }
    //coming soon
//    public void create(){
//        try {
//            FileWriter myWriter = new FileWriter("filename.txt");
//            myWriter.write("Files in Java might be tricky, but it is fun enough!");
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }
//
//    public void delete(){
//
//    }
//
//    public void update(){
//
//    }
//
//    public void read(){
//
//    }
}
