package com.example.nadador;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText nombre, edad, peso, altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Objects.requireNonNull(getSupportActionBar()).hide();

        nombre = (TextInputEditText) findViewById(R.id.nombreHint);
        edad = (TextInputEditText) findViewById(R.id.edadHint);
        peso = (TextInputEditText) findViewById(R.id.pesoHint);
        altura = (TextInputEditText) findViewById(R.id.alturaHint);

        Button button = (Button) findViewById(R.id.loginButton);

        button.setOnClickListener(view -> {

            escribirUsuario();
            Toast.makeText(LoginActivity.this, "Bienvenido/a " + Objects.requireNonNull(nombre.getText()) + ".", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("Usuario", nombre.getText().toString());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();


        });
    }

    public void escribirUsuario() {

        // Recoger los datos introducidos:
        String usuarioAux = Objects.requireNonNull(nombre.getText()).toString();
        String edadAux = Objects.requireNonNull(edad.getText()).toString();
        String pesoAux = Objects.requireNonNull(peso.getText()).toString();
        String alturaAux = Objects.requireNonNull(altura.getText()).toString();

        // SharePreferences "Usuarios":
        SharedPreferences pref = getSharedPreferences("Usuarios", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        // Se introducen en las Strings los usuarios y sus keys:
        editor.putString("Usuario", usuarioAux);
        editor.putString("Edad", edadAux);
        editor.putString("Peso", pesoAux);
        editor.putString("Altura", alturaAux);
        editor.apply();
    }

}