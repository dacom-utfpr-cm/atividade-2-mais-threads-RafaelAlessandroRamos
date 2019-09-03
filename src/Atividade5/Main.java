/*
 *Faca um programa multithreaded em Java que ordene um vetor usando o Merge Sort 
 * recursivo. Faca com que a thread principal dispare duas threads para 
 * classificar cada metade do vetor.
 */
package Atividade5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public class Main {

    public static void main(String[] args) {

        int n = (int) (Math.random() * 100);
        int vetor[] = new int[n];

        for (int i = 0; i < n; i++) {
            vetor[i] = (int) Math.random() * 100;
        }

        Thread thread = new Thread(new Merge(vetor, 0, vetor.length - 1));
        thread.start();
    }
}
