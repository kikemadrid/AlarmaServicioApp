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

            stopSelf(startId);
        }
        catch (Throwable t)
        {
            Log.e("MIAPP", "ERRORAZO", t);
        }

        return Service.START_NOT_STICKY;
    }

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
