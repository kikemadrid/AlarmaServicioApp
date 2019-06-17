package edu.cftic.alarmaservicioapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

public class AlarmaReceiver extends BroadcastReceiver {


    /**
     * Cuando suene la alarma llamara al pendingIntent que esta configurada con esta clase AlarmaReceiver
     * parará por este método
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {

        try
        {

            Log.d("MIAPP", "Alarma ejecutándose");


            Intent intent_serv = new Intent(context, ServicioEnvio.class);
            context.startService(intent_serv);
            Log.d("MIAPP", "Lanzando el servicio");

        }
        catch (Throwable t)
        {
            Log.e("MIAPP", "ERRORAZO", t);
        }
    }
}
