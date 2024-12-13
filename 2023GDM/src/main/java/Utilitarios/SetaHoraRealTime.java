/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import telas.TelaMasterApp;

/**
 *
 * @author Deibidson Mesquita
 */
public class SetaHoraRealTime implements Runnable {

    private final DataHora dt;
    private final Thread t;
    private volatile boolean shouldStop = false;

    public SetaHoraRealTime() {
        this.t = new Thread(this);
        dt = new DataHora();
    }

    public void start() {
        t.start();
    }

    public void stop() {
        shouldStop = true;
    }

    @Override
    public void run() {
        while (!shouldStop) {
            TelaMasterApp.setaHoraRealTimeApp(dt.ler_hora());

        }
    }

}
