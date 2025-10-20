package com.example.multimedia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle extras = getIntent().getExtras();
        int valor = extras.getInt("MiValor");
        String valor2 = extras.getString("MiValor2");


        /*Toast.makeText(this, "Los valores recibidos son: "+valor+" y "+valor2,Toast.LENGTH_LONG).show();*/

    }

    public void iniciarActivity(View view){

        Intent intentActivity = new Intent(this, MainActivity.class);
        startActivity(intentActivity);

    }

    public void crearAlarma(View view){
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Alarma Trabajo")
                .putExtra(AlarmClock.EXTRA_HOUR, 12)
                .putExtra(AlarmClock.EXTRA_MINUTES, 15);
        startActivity(intent);
    }
    public void llamarNum(View view){
        String numeroTel = "+34643660866";
        Uri marcar = Uri.parse("tel:" + numeroTel);
        Intent intent = new Intent(Intent.ACTION_DIAL, marcar);
        startActivity(intent);
    }

}