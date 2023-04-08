package com.example.nadador;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextView tvNombre, tvEdad, tvPeso, tvAltura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();

        Button training = (Button) findViewById(R.id.training);
        Button estadisticas = (Button) findViewById(R.id.estadisticas);
        Button salir = (Button) findViewById(R.id.salir);

        tvNombre = (TextView) findViewById(R.id.nombre);
        tvEdad = (TextView) findViewById(R.id.edad);
        tvPeso = (TextView) findViewById(R.id.peso);
        tvAltura = (TextView) findViewById(R.id.altura);


        preferences();

        training.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ShowTraining.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });

        estadisticas.setOnClickListener(view -> statisticsDialog());

        salir.setOnClickListener(view -> finish());

    }

    public void statisticsDialog() {
        DialogStatistics ds = new DialogStatistics();
        ds.show(getSupportFragmentManager(), "Dialogo Estadísticas");
    }

    public void preferences() {
        SharedPreferences sp = getSharedPreferences("Usuarios", Context.MODE_PRIVATE);

        String usuario = sp.getString("Usuario", "No existe la información");
        String edad = sp.getString("Edad", "No existe la información");
        String peso = sp.getString("Peso", "No existe la información");
        String altura = sp.getString("Altura", "No existe la información");

        tvNombre.setText(usuario);
        tvEdad.setText(edad);
        tvPeso.setText(peso);
        tvAltura.setText(altura);
    }
}