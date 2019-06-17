package edu.cftic.alarmaservicioapp;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //si viene de la notificación
        String mensaje_noti = getIntent().getStringExtra("MENSAJE");
        if (mensaje_noti!=null) {
            TextView tv = findViewById(R.id.textView);
            tv.setText(mensaje_noti);
        }
    }

    /**
     * APLICACION QUE PROGRAMA UNA ALARMA GestorAlarma
     * Esta a su vez cuando se activa reciever (AlarmaReceiver) lanza un servicio (ServicioEnvio)
     * Cuando el anterior termina llama a un receiver (ServicioReceiver)
     * Este ultimo a su vez llama a una notificación
     * @param view
     */

    public void lanzarAlarma(View view) {

        GestorAlarma ga = new GestorAlarma(this);
        ga.programarAlarma();
        this.finish();


    }
}
