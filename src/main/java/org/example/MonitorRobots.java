package org.example;

public class MonitorRobots extends Thread{



    public MonitorRobots(){

    }
    public synchronized void esperar(){
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void notificar(){
        notifyAll();
    }

}
