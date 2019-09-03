/*
 * Faça um programa em Java que consulte periodicamente o estado de um conjunto de threads.
 */
package Atividade1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public class Main implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                //System.out.println(Thread.currentThread().getName());
                for (long i = 0; i < 999999999;) {
                    i++;
                }
                Thread.sleep(1000);
                break;
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Start main...");

        Thread t1 = new Thread(new Main());
        Thread t2 = new Thread(new Main());
        Thread t3 = new Thread(new Main());
        Thread t4 = new Thread(new Main());

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        int cont = 0;
        while (true) {
            System.out.println(t1.getName() + " : " + t1.getState());
            System.out.println(t2.getName() + " : " + t2.getState());
            System.out.println(t3.getName() + " : " + t3.getState());
            System.out.println(t4.getName() + " : " + t4.getState());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            cont++;
            if (cont > 7) {
                break;
            }
        }
        System.out.println("Stop main.");
    }
}
