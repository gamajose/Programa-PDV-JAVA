package Utilitarios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataHora {

    public String hora;
    public String data;

    private SimpleDateFormat horaFormatada;
    private SimpleDateFormat dataFormatada;

    public DataHora() {
        horaFormatada = new SimpleDateFormat("HH:mm:ss");
        dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    }

    public String ler_hora() {
        Date horaAtual = new Date();
        hora = horaFormatada.format(horaAtual);
        return hora;
    }

    public String ler_Data() {
        Date dataAtual = new Date();
        data = dataFormatada.format(dataAtual);
        return data;
    }

    public long calcularDatas(Date a, Date b) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        cal1.set(2013, Calendar.SEPTEMBER, 30, 19, 30, 00);
        cal2.set(2013, Calendar.OCTOBER, 1, 9, 00, 00);

        long milis1 = cal1.getTimeInMillis();
        long milis2 = cal2.getTimeInMillis();

        long diff = milis2 - milis1;

        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        long diffDays = diff / (24 * 60 * 60 * 1000);

        return diff;

    }

}
