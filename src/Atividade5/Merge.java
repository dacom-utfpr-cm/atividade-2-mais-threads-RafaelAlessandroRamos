package Atividade5;

/**
 *
 * @author rafael
 */
public class Merge implements Runnable {

    int vetor[];
    int inicio;
    int fim;

    public Merge(int[] vetor, int inicio, int fim) {
        this.vetor = vetor;
        this.inicio = inicio;
        this.fim = fim;
    }

    @Override
    public void run() {
        int meio;
        if (inicio < fim) {
            try {
                meio = (inicio + fim) / 2;
                Thread tm1 = new Thread(new Merge(this.vetor, this.inicio, meio));
                tm1.start();
                tm1.join();
                Thread tm2 = new Thread(new Merge(this.vetor, meio + 1, this.fim));
                tm2.start();
                tm2.join();
                Thread ti = new Thread(new Intercala(this.vetor, this.inicio, meio, this.fim));
                ti.start();
                ti.join();
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(Merge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        System.out.println(this.vetor.toString());
    }
}
