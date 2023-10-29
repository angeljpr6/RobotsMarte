package org.example;

import java.util.ArrayList;
import java.util.TreeMap;

public class Base extends Thread {

    private int kriptonitas;
    private int baterias;
    private int piedras;

    public Base() {
        this.kriptonitas = 3;
        this.baterias = 1;
        this.piedras = 0;
    }

    @Override
    public void run() {
        super.run();


        while (true) {
            Robot robot1 = new Robot(this,"Angel");
            Robot robot2 = new Robot(this,"Lucas");
            Robot robot3 = new Robot(this,"Raul");
            Robot robot4 = new Robot(this,"Dani");
            Robot robot5 = new Robot(this,"Joni");

            robot1.start();
            robot2.start();
            robot3.start();
            robot4.start();
            robot5.start();

        }

    }

    public int getKriptonitas() {
        return kriptonitas;
    }

    public int getBaterias() {
        return baterias;
    }

    public void setKriptonitas(int kriptonitas) {
        this.kriptonitas = kriptonitas;
    }

    public void setBaterias(int baterias) {
        this.baterias = baterias;
    }

    public int getPiedras() {
        return piedras;
    }

    public void setPiedras(int piedras) {
        this.piedras = piedras;
    }
}
