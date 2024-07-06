package com.oraclenextgen.conversor.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Divisa {

    private String nombre;
    private float valor;

    public Divisa() {}

    public Divisa(String nombre, float valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public Divisa(Conversor conversor) {
        this.nombre = conversor.targetCode();
        this.valor = conversor.conversionRate();
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void calcularCambio(float valor, String conversion1, String conversion2) {

        boolean entradaValida = false;
        float cantidad = 0;
        float resultado = 0;
        Scanner scanner = new Scanner(System.in);

        while(!entradaValida) {

            System.out.print("\nIngresa la cantidad de la conversión a solicitar: ");
            String entrada = scanner.nextLine();

            try {
                cantidad = Float.parseFloat(entrada);
                entradaValida = true;

            }catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, introduce un número entero o decimal.");
            }
        }

        resultado = cantidad * valor;
        System.out.println( cantidad + conversion1 + " equivale a " + resultado + conversion2);
    }

}
