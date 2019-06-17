package edu.cftic.alarmaservicioapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ServicioReceiver extends BroadcastReceiver {


    //

    /**
     *Este es el que escucha, lo hemos configurado en el manifest con un intent con el siguiente mensaje
     * SERVICIO_TERMINADO Y lanzaría una notificación
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("MIAPP", "El servicio ha finalizado, lanzo una notificación");
        NotificaMensaje.lanzarNotificiacion(context);


    }
}
