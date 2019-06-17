package edu.cftic.alarmaservicioapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ServicioReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("MIAPP", "El servicio ha finalizado, lanzo una notificación");
        NotificaMensaje.lanzarNotificiacion(context);


    }
}
