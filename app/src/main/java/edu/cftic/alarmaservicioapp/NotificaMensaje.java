package edu.cftic.alarmaservicioapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import static android.content.Context.NOTIFICATION_SERVICE;


public class NotificaMensaje {



    //El id
    public static final String NOTIFICATION_CHANNEL_ID = "channel_id";

    //El nombre visible para el usuario en Ajustes
    public static final String CHANNEL_NAME = "Notification Channel";

    private static NotificationChannel crearCanalNotificacion ()
    {
        NotificationChannel notificationChannel = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);

            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setLightColor(Color.GREEN);

            //La duración del patrón de vibración {silencio,vibración,silencio,vibración,..}
            notificationChannel.setVibrationPattern(new long[]{
                    500,
                    500,
                    500,
                    500,
                    500
            });

            //Indicamos si la notificación será visible estando la pantalla bloqueada o no
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
        }



        return notificationChannel;
    }

    public static void lanzarNotificiacion(Context context) {

        Log.d("MIAPP", "Lanzando notificación");
        NotificationCompat.Builder nb = null;

        /**
         * Para versión de 8 o mas existen los canales, son tipos de aviso de notificaciones nueva
         * si no se ejecuta de manera normal, por el else
          */

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel nc = crearCanalNotificacion();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(nc);
            nb = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID);
        } else {

            nb =  new NotificationCompat.Builder(context, null);

        }



        // esto es similar a un alertDialog
        nb.setSmallIcon(R.mipmap.ic_launcher);
        nb.setContentTitle("INFORME ENVIADO");
        nb.setAutoCancel(true);
        nb.setDefaults(Notification.DEFAULT_ALL);

        Intent resultIntent = new Intent(context, MainActivity.class);
        resultIntent.putExtra("MENSAJE", "VENGO DE LA ALARMA");

        // Cuando le de a una notificacion iremos al main de nuevo
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), resultIntent, PendingIntent.FLAG_ONE_SHOT);

        nb.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(537, nb.build());//537
    }
}
