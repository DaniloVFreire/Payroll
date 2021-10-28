package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //ArrayList <String> users = new ArrayList<>() ;
        //System.out.println(users);
        boolean run = true;
        while(run){
        System.out.println("foi");
        System.out.print("Sistema folha de pagamento, para:\n Adcionar um emprego" +
                "Adicionar um empregado digite 1;\n" +
                "Para remover um empregado digite 2;\n" +
                "Para lançar um cartão de ponto digite 3;\n" +
                "Para lançar um resultado de venda digiter 4;\n" +
                "Para lançar uma taxa de serviço, digite 5;\n" +
                "Para alterar detalhes de um empregado, digite 6;\n" +
                "Para rodar folha de pagamento para hoje 7;\n" +
                "Para dar 'undo' digite 8;\n" +
                "Para dar 'redo' digite 9;\n" +
                "Para mudar agenda de pagamento digite 10;\n" +
                "Para criar nova agenda de pagamento digite 11;\n" +
                "para sair digite 12;\n");
        Scanner scanner = new Scanner(System.in);

        int entrada = scanner.nextInt();
        System.out.println(entrada);

        switch (entrada) {
            case 1:
                System.out.println("você escolhei a opção 1");
                break;
            case 2:

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
