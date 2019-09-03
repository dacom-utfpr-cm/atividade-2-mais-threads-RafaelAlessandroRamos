/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade4;

/**
 *
 * @author rafael
 */
public class Busca implements Runnable {

    int vetor[];
    int valor;

    public Busca(int vetor[], int valor) {
        this.vetor = vetor;
        this.valor = valor;
    }

    @Override
    public void run() {
        System.out.println("Start Thread...");
        try {
            for (int i = 0; i < this.vetor.length; i++) {
                if (this.vetor[i] == this.valor) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " encontrou o valor " + this.valor);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao procurar valor no vetor");
        }
        System.out.println("Stop thread.");
    }
}
