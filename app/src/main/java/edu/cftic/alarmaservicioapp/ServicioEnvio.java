package edu.cftic.alarmaservicioapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ServicioEnvio extends Service {

    public ServicioEnvio() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //
        try {

            Log.d("MIAPP", "Servicio iniciado!...enviando el correo");
            //TODO enviaríamos el correo

            // Nosotros cuando terminemos de realizar la acción que queremos  paramos el servicio
            // y llamaría a onDestroy()
            stopSelf(startId);
        }
        catch (Throwable t)
        {
            Log.e("MIAPP", "ERRORAZO", t);
        }

        return Service.START_NOT_STICKY;
    }

    // Cuando terminamos el servicio realizamos el intent_reciver

    @Override
    public void onDestroy() {
        super.onDestroy();


        Log.d("MIAPP", "Servicio Terminado");


        Intent intent_reciver = new Intent("SERVICIO_TERMINADO");
        sendBroadcast(intent_reciver);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
