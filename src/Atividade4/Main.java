/*
 * Faca um programa em Java que realize uma busca paralela em um vetor de 
 * inteiros. Informe para o metodo: valor procurado, vetor de inteiros e o 
 * numero de threads.
 */
package Atividade4;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael
 */
public class Main {

    public static int[] subArray(int[] array, int inicio, int fim) {
        int[] a = new int[fim - inicio];
        int cont = 0;
        for (int i = inicio; i < fim; i++, cont++) {
            a[cont] = array[i];
        }
        return a;

    }

    public static void setupBusca(int vp, int vetor[], int nt) {
        int n = (int) (vetor.length / nt);
        int inicio = 0;
        int fim = n;
        for (int i = 0; i < nt; i++) {
            Thread t = new Thread(new Busca(subArray(vetor, inicio, fim), vp));
            t.start();
            inicio = fim;
            fim += fim -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("Start main...");

        int n = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho do vetor"));
        int vetor[] = new int[n];

        for (int i = 0; i < n; i++) {
            vetor[i] = (int) (Math.random() * 100);
            System.out.println(vetor[i]);
        }

        int vp = Integer.parseInt(JOptionPane.showInputDialog("valor procurado: "));
        int nt = Integer.parseInt(JOptionPane.showInputDialog("numero de threads: "));

        setupBusca(vp, vetor, nt);
        
        

        System.out.println("Stop main.");
    }
}
