/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * Juego de rol.
 *
 * @author Cristian Alonso Sanchez Segura
 * @version 1.0
 */
public class Jugar {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        Random r = new Random();
        int opcion;
        int personaje;
        String nombre;
        boolean salir = false;
        int computadora;

        System.out.println("Bienvenido al juego de rol LeagueBuzz");
        while (!salir) {

            System.out.println("\n1. Jugar" + "\n2. Instrucciones"
                    + "\n3. Personajes" + "\n0. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        Personaje usuario = new Personaje(" ");
                        System.out.println("Comienza el juego.\nSelecciona tu personaje"
                                + " favorito.\n1. Guerrero\n2. Mago\n3. Asesino\n4. Tirador");
                        try {
                            personaje = sn.nextInt();
                            switch (personaje) {
                                case 1:
                                    System.out.println("Seleccionaste Guerrero.\nAsignale un nombre");
                                    nombre = sn.next();
                                    usuario = new Guerrero(nombre);
                                    break;
                                case 2:
                                    System.out.println("Seleccionaste Mago.\nAsignale un nombre");
                                    nombre = sn.next();
                                    usuario = new Mago(nombre);
                                    break;
                                case 3:
                                    System.out.println("Seleccionaste Asesino.\nAsignale un nombre");
                                    nombre = sn.next();
                                    usuario = new Asesino(nombre);
                                    break;
                                case 4:
                                    System.out.println("Seleccionaste Tirador.\nAsignale un nombre");
                                    nombre = sn.next();
                                    usuario = new Tirador(nombre);
                                    break;
                                default:
                                    System.out.println("Solo números entre 1 y 4");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Debes insertar un número");
                            sn.next();
                        }
                        Personaje cpu = new Personaje(" ");
                        computadora = r.nextInt(3);
                        switch (computadora) {
                            case 0:
                                cpu = new Guerrero("Camille");
                                break;
                            case 1:
                                cpu = new Mago("Veigar");
                                break;
                            case 2:
                                cpu = new Asesino("Zed");
                                break;
                            case 3:
                                cpu = new Tirador("Kaisa");
                                break;

                        }
                        System.out.println("\nTe enfrentaras contra:\n" + cpu);
                        for (int i = 0; i < 200; i++) {
                            cpu.setVida(usuario.atacar());
                            usuario.recuperar();
                            if (usuario.getVida() <= 0) {
                                System.out.println("\nPerdiste, el ganador es: " + cpu);
                                break;
                            } else if (cpu.getVida() <= 0) {
                                System.out.println("\n¡Ganaste! :)\n" + usuario);
                                break;
                            } else {
                                usuario.setVida(cpu.atacar());
                                cpu.recuperar();
                            }
                        }

                        break;
                    case 2:
                        System.out.println("Instrucciones:\nEl juego se desarrolla"
                                + " humano-maquina, escoge tu personaje favorito,"
                                + " enfrentate contra otro personaje aleatorio por parte"
                                + " de la computadora y vence.\nLos ataques son automaticos,"
                                + " todos los personajes inician con 100 pts de vida,"
                                + " pierde el primero en llegar a 0 puntos de vida.");
                        break;
                    case 3:
                        System.out.println("Personajes:\n*Guerrero: Ideal para enfrentamientos prolongados,"
                                + " recupera vida entre mas peleas.\n*Mago: Elimina a tus enemigos"
                                + " con poderosos hechizos.\n*Asesino: Se implacable, acaba con ellos"
                                + " antes de que puedan verte.\n*Tirador: Manten la distancia y extermina "
                                + " a tus enemigos con rafagas a distancia.");
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 0 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
}
