
package Atividade3;

/**
 *
 * @author rafael
 */

public class Particao implements Runnable {

    private int inicio;
    private int fim;

    public Particao(int inicio, int fim){
        this.inicio = inicio;
        this.fim = fim;
    }

    @Override
    public void run() {
        System.out.print("Start thread...");
        for (int i = this.inicio; i < this.fim; i++) {
            int divCount = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    divCount++;
                }
            }
            if (divCount == 2) {
                System.out.println("Primo: " + i);
            }
        }
        System.out.print("Stop thread.");
    }
}
