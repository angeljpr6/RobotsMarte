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
        Robot robot1 = new Robot(this);
        Robot robot2 = new Robot(this);
        Robot robot3 = new Robot(this);
        Robot robot4 = new Robot(this);
        Robot robot5 = new Robot(this);

        while (true){
            robot1.run();
            robot2.run();
            robot3.run();
            robot4.run();
            robot5.run();
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
