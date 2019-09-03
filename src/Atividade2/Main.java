/*
 * Faça um programa em Java para testar um conjunto de operações sobre um grupo 
 * de threads. Use o ThreadGroup.
 */
package Atividade2;

/**
 *
 * @author rafael
 */
public class Main implements Runnable {

    @Override
    public void run() {
        System.out.println("Start thread... " + Thread.currentThread().getName());
        System.out.println("Stop thread. " + Thread.currentThread().getName());

    }

    public static void main(String[] args) {

        System.out.println("Start main...");

        ThreadGroup group = new ThreadGroup("ThreadGoup");

        System.out.println("Group name : " + group.getName());

        Thread t1 = new Thread(group, new Main(), "t1");
        Thread t2 = new Thread(group, new Main(), "t2");
        Thread t3 = new Thread(group, new Main(), "t3");
        Thread t4 = new Thread(group, new Main(), "t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("Threads ativas " + group.activeCount());
        System.out.println("Threads priority " + group.getMaxPriority());
        group.isDaemon();
        try {
            group.destroy();
        } catch (Exception e) {
            System.out.println("Sem threads ativas para destruir");
        }

        System.out.println("Stop main.");

    }
}
