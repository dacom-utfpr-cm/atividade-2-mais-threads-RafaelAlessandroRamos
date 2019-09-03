package Atividade5;

/**
 *
 * @author rafael
 */
public class Intercala implements Runnable {

    int vetor[];
    int inicio;
    int meio;
    int fim;

    public Intercala(int[] vetor, int inicio, int meio, int fim) {
        this.vetor = vetor;
        this.inicio = inicio;
        this.meio = meio;
        this.fim = fim;
    }

    @Override
    public void run() {
        int i, j, k;
        int vetorB[] = new int[vetor.length];
        for (i = inicio; i < meio; i++) {
            vetorB[i] = vetor[i];
        }
        for (j = meio + 1; j < fim; j++) {
            vetorB[fim + meio + 1 - j] = vetor[j];
        }
        i = inicio;
        j = fim;
        for (k = inicio; k < fim; k++) {
            if (vetorB[i] <= vetorB[j]) {
                vetor[k] = vetorB[i];
                i = i + 1;
            } else {
                vetor[k] = vetorB[j];
                j = j - 1;
            }
        }
    }
}
