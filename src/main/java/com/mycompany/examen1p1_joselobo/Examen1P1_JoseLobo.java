package com.mycompany.examen1p1_joselobo;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author JoseLobo
 */
public class Examen1P1_JoseLobo {

    static Scanner leer = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("Menu");
            System.out.println("1<--Divisores primos");
            System.out.println("2<--Contorno de Pirámide");
            System.out.println("3<--Vecinos");
            System.out.println("4<--Triangulo de Pascal");
            System.out.println("5<--Salir");
            System.out.println("Ingrese su opcion: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese un numero: ");
                    int num = leer.nextInt();
                    System.out.print("Los numeros primos que dividen el numero " + num + " son: ");
                    for (int i = 1; i <= num; i++) {
                        boolean test = primo(i);
                        if (test == true) {
                            int test2 = num % i;
                            if (test2 == 0) {
                                System.out.print("[" + i + "]");
                            }
                        }//test
                    }//for
                    System.out.println();
                }//case 1
                case 2 -> {
                    System.out.println("Ingrese el tamano de la Piradime(impar): ");
                    int n = leer.nextInt();
                    boolean validar = validarImpar(n);
                    while (validar == false) {
                        System.out.println("Dato Erroneo");
                        System.out.println("Ingrese otro numero impar");
                        n = leer.nextInt();
                        validar = validarImpar(n);
                    }
                    contorno(n);

                }//case 2
                case 3 -> {
                    System.out.println("Ingrese su cadena: ");
                    String palabra = leer.next();
                    int gen = random.nextInt(2);
                    System.out.println("Numero Generado: " + gen);
                    String Resultado = modificar(palabra, gen);
                    System.out.println("Cadena Resultante: " + Resultado);
                }//case3
                case 4 -> {
                    System.out.println("Ingrese el tamano del traingulo: ");
                    int tamano = leer.nextInt();
                    triagulopascal(tamano);
                    
                }//case 4
                case 5 -> {
                    System.out.println("Saliendo...");
                }//case 5
                default -> {
                    System.out.println("Opcion Invalida");
                }//default
            }//switch
        } while (opcion != 5);
    }//main

    public static boolean primo(int n) {
        boolean respuesta = true;
        for (int i = 2; i < n; i++) {
            int test = n % i;
            if (test == 0) {
                respuesta = false;
            }//if
        }//for
        return respuesta;
    }//primo test

    public static void contorno(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }//for inicial
        System.out.println();

        for (int i = 0; i < (n / 2) - 1; i++) {
            for (int h = n / 2; h > 0 + i; h--) {
                System.out.print("*");
            }//pared

            if (i != (n / 2) - 1) {
                System.out.print("+");
            } //if borde

            for (int h = 0; h < i; h += 1) {
                System.out.print(" ");
            }//espacio
            for (int h = 0; h < i - 1; h += 1) {
                System.out.print(" ");
            }//espacio2
            if (i != 0) {
                System.out.print("+");
            }//borde 2
            for (int h = n / 2; h > 0 + i; h--) {
                System.out.print("*");
            }//pared2

            System.out.println();
        }//triangulo interno

        System.out.print("*");
        for (int i = 0; i < n - 2; i++) {
            System.out.print("+");
        } //Aqui va la parte de abajo
        System.out.println("*");
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }//for final

        System.out.println();
    }//triangulo

    public static boolean validarImpar(int num) {
        boolean respuesta = false;
        int test = num % 2;
        if (test == 1) {
            respuesta = true;
        }//if
        return respuesta;
    }//validar impar

    public static String modificar(String base, int ver) {
        String acum = "";
        if (ver == 1) {
            for (int i = 0; i < base.length(); i++) {
                int letra = (int) base.charAt(i) + 1;
                acum += (char) letra;
            }//for 1
        } else {//if 1
            for (int i = 0; i < base.length(); i++) {
                int letra = (int) base.charAt(i) - 1;
                acum += (char) letra;
            }//for 1
        }//else 0
        return acum;
    }//modificar

    public static int facto(int num) {
        int resultado = 1;
        for (int i = num; i > 0; i--) {
            resultado = resultado * i;
        }//for
        return resultado;
    }//factorial

    public static double permu(int n, int r) {
        double resultado = facto(n) / facto(n - r);
        return resultado;
    }//permu

    public static double comb(int n, int r) {
        double resultado = permu(n, r) / facto(r);
        return resultado;
    }//combinacion

    public static void triagulopascal(int num) {
        num=num-1;
        for (int i = 0; i <= num; i++) {
            for (int j = 0; j <= i; j++) {
                int resp = (int)comb(i,j);
                System.out.print("["+resp+"]");
            }
            System.out.println();
        }//for base
    }//triangulopascal
}//class
