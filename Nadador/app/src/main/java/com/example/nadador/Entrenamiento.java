package com.example.nadador;

import androidx.annotation.NonNull;

public class Entrenamiento {

    //Atributos clase Entrenamiento:

    public int id, segundos;
    public String fecha;
    public float distancia;

    //Constructor clase Entrenamiento:

    public Entrenamiento(int id, String fecha, int segundos, float distancia) {
        this.id = id;
        this.fecha = fecha;
        this.segundos = segundos;
        this.distancia = distancia;
    }

    //Getters y Setters clase Entrenamiento:

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public float getSegundos() {
        return segundos;
    }

    public float getDistancia() {
        return distancia;
    }


    //Método toString clase Entrenamiento:

    @NonNull
    @Override
    public String toString() {
        return "Con fecha " + fecha + " se ha hecho una distancia de " + distancia + " kilómetros, con un cálculo de " + minKm() + " minutos por kilómetro y " + segKm() + " segundos por kilómetro, a una velocidad de " + kmsH() + " km/h.";
    }

    //Método para calcular los minutos por kilómetro:

    public float minKm() {
        return ((segundos / 60) / distancia);
    }

    //Método para calcular los segundos por kilómetro:

    public float segKm() {
        return (segundos / distancia);
    }

    //Método para calcular los kilometros por hora:

    public float kmsH() {
        return (distancia / (segundos / (float) 3600));
    }

}
