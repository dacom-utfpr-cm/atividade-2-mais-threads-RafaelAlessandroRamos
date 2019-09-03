/*
 * Faca um programa em Java com threads que exiba os numeros primos entre 0 e 100000.
 */
package Atividade3;

/**
 *
 * @author rafael
 */
public class Main {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Particao(0, 25000));
        Thread t2 = new Thread(new Particao(25001, 50000));
        Thread t3 = new Thread(new Particao(50001, 75000));
        Thread t4 = new Thread(new Particao(75001, 100000));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}






