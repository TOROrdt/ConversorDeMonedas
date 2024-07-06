package com.oraclenextgen.conversor.main;

import com.oraclenextgen.conversor.service.ConsultorDeDivisas;
import com.oraclenextgen.conversor.service.Divisa;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        boolean ciclo = true;

        while (ciclo) {

            boolean entradaValida = false;
            String menu = """
                
                ==========================================
                           Conversor de monedas
                    
                 1) Peso mexicano a dólar estadounidense 
                 2) Peso mexicano a dólar canadiense
                 3) Peso mexicano a euros
                 4) Dolar estadounidense a peso mexicano
                 5) Dolar canadiense a peso mexicano
                 6) Euro a peso mexicano
                 7) Salir del programa
                 
                ==========================================
                """;
            Scanner scanner = new Scanner(System.in);
            int opcion = 0;
            Divisa divisa = new Divisa();
            ConsultorDeDivisas consultarAPI = new ConsultorDeDivisas();
            float resultado;

            while (!entradaValida) {

                System.out.println(menu);
                System.out.print("Selecciona una opción: ");
                String entrada = scanner.nextLine();

                try {
                    opcion = Integer.parseInt(entrada);
                    entradaValida = true;

                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, introduce un número entero.");
                }
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n== Peso mexicano a dólar estadounidense ==");

                    divisa = consultarAPI.obtenerValorActual("MXN", "USD");
                    resultado = divisa.getValor();
                    divisa.calcularCambio(resultado, " pesos mexicanos", " dólares estadounidenses");
                    break;

                case 2:
                    System.out.println("\n== Peso mexicano a dólar canadiense ==");

                    divisa = consultarAPI.obtenerValorActual("MXN", "CAD");
                    resultado = divisa.getValor();
                    divisa.calcularCambio(resultado, " pesos mexicanos", " dólares canadienses");
                    break;

                case 3:
                    System.out.println("\n== Peso mexicano a euros ==");

                    divisa = consultarAPI.obtenerValorActual("MXN", "EUR");
                    resultado = divisa.getValor();
                    divisa.calcularCambio(resultado, " pesos mexicanos", " euros");
                    break;

                case 4:
                    System.out.println("\n== Dólar estadounidense a peso mexicano ==");

                    divisa = consultarAPI.obtenerValorActual("USD", "MXN");
                    resultado = divisa.getValor();
                    divisa.calcularCambio(resultado, " dólares estadounidenses", " pesos mexicanos");
                    break;

                case 5:
                    System.out.println("\n== Dólar canadiense a peso mexicano ==");

                    divisa = consultarAPI.obtenerValorActual("CAD", "MXN");
                    resultado = divisa.getValor();
                    divisa.calcularCambio(resultado, " dólares canadienses", " pesos mexicanos");
                    break;

                case 6:
                    System.out.println("\n== Euro a peso mexicano ==");

                    divisa = consultarAPI.obtenerValorActual("EUR", "MXN");
                    resultado = divisa.getValor();
                    divisa.calcularCambio(resultado, " euros", " pesos mexicanos");
                    break;

                case 7:
                    System.out.println("\nCerrando aplicación");
                    ciclo = false;
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}

