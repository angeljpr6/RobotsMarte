package org.example;

public class Robot extends Thread{

    private String nombre;
    private Base base;

    public Robot(Base base, String nombre) {
        this.base=base;
        this.nombre=nombre;
    }

    @Override
    public void run() {
        super.run();
        cargar();
        trabajar();
    }

    public synchronized void cargar(){
        while (base.getKriptonitas()<=0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        base.setKriptonitas(base.getKriptonitas()-1);
        System.out.println(nombre+" ha cogido una Kriptonita");
        notifyAll();

        while (base.getBaterias()<=0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        base.setBaterias(base.getBaterias()-1);
        System.out.println(nombre+" ha cogido una Bateria");
        notifyAll();

    }
    public synchronized void descargar(){
        base.setBaterias(base.getBaterias()+1);
        base.setPiedras(base.getPiedras()+10);
        base.setKriptonitas(base.getKriptonitas()+1);

    }
    public synchronized void trabajar(){
        try {
            System.out.println(nombre+" ha salido a trabajar");
            Thread.sleep(5000);
            descargar();
            System.out.println(nombre+" ha recogido 10 piedras");
            System.out.println("Kriptonitas en la base: "+base.getKriptonitas());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifyAll();


    }
}
