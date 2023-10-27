package org.example;

public class Robot extends Thread{

    private boolean tieneKriptonita;
    private boolean tieneBateria;
    private Base base;

    public Robot(Base base) {
        tieneBateria=false;
        tieneKriptonita=false;
        this.base=base;
    }

    @Override
    public void run() {
        super.run();
        cargar();
        trabajar();
    }

    public void cargar(){
        if (base.getKriptonitas()>0) {
            base.setKriptonitas(base.getKriptonitas() - 1);
            System.out.println("Un robot cogio una kriptonita");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("a");
            }
            if (base.getBaterias() > 0) {
                base.setBaterias(base.getBaterias() - 1);
                System.out.println("Un robot cogio una bateria");

            }
        }else {
            notifyAll();

        }
    }
    public void descargar(){
        base.setBaterias(base.getBaterias()+1);
        base.setPiedras(base.getPiedras()+10);
        base.setKriptonitas(base.getKriptonitas()+1);
    }
    public synchronized void trabajar(){
        try {
            System.out.println(this.getName()+" ha salido a trabajar");
            wait(5000);
            descargar();
            System.out.println(this.getName()+" ha recogido 10 piedras");
            System.out.println("Kriptonitas en la base: "+base.getKriptonitas());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }notifyAll();


    }
}
