package edu.cftic.alarmaservicioapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GestorAlarma {

    private Context context;

    public GestorAlarma (Context context)
    {
        this.context = context;
    }

    public void programarAlarma ()

    {
        Calendar calendar_actual = Calendar.getInstance();


        long tiempo = calendar_actual.getTimeInMillis() + 10000; //en 10 ss saltará la alarma

        Intent intentAlarm = new Intent(this.context, AlarmaReceiver.class);
        AlarmManager alarmManager = (AlarmManager) this.context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pi = PendingIntent.getBroadcast(this.context, 55, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT);

        alarmManager.set(AlarmManager.RTC_WAKEUP, tiempo, pi);//TIempo, No es el tiempo que falta. Es el tiempo expresado en milisegundos equivalente a la fecha y hora del omento en que se quiere ejecutar


        //mensaje informativo
        SimpleDateFormat dateformatter = new SimpleDateFormat("E dd/MM/yyyy 'a las' hh:mm:ss");
        String mensaje = "Alarma programada para " + dateformatter.format(tiempo);
        Log.d("MIAPP", mensaje);


        Toast.makeText(this.context, mensaje, Toast.LENGTH_LONG).show();
    }
}
