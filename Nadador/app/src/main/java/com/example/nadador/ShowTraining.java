package com.example.nadador;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShowTraining extends AppCompatActivity {

    private ListAdapter adapter;
    private List<Entrenamiento> trainingList;


    public List<Entrenamiento> getTrainingList() {
        return trainingList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_training);

        Objects.requireNonNull(getSupportActionBar()).hide();

        ListView lv = (ListView) findViewById(R.id.itemlist);
        Button back = (Button) findViewById(R.id.back);
        Button add = (Button) findViewById(R.id.add);

        trainingList = iniciarArray();

        adapter = new ListAdapter(getApplicationContext(), trainingList);

        lv.setAdapter(adapter);

        statistics(trainingList);

        lv.setOnItemClickListener((adapterView, view, position, id) -> mostrarTraining(position));

        lv.setOnItemLongClickListener((adapterView, view, position, id) -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(ShowTraining.this);

            builder.setTitle("Selecciona una opción: ")
                    .setIcon(R.mipmap.ic_launcher);

            final CharSequence[] opciones = new CharSequence[3];
            opciones[0] = "Mostrar entrenamiento.";
            opciones[1] = "Modificar entrenamiento.";
            opciones[2] = "Borrar entrenamiento.";

            builder.setItems(opciones, (dialogInterface, i) -> {

                if (i == 0) {
                    mostrarTraining(position);
                }
                if (i == 1) {
                    DialogModify dialogModify = new DialogModify();
                    dialogModify.setPosition(position);
                    dialogModify.show(getSupportFragmentManager(), "Test");
                }
                if (i == 2) {

                    new AlertDialog.Builder(ShowTraining.this)
                            .setIcon(android.R.drawable.ic_delete)
                            .setTitle("¿Estás seguro?")
                            .setMessage("¿Desea borrar el entrenamiento?")
                            .setPositiveButton("Sí", (dialogInterface1, which) -> {
                                trainingList.remove(position);
                                adapter.notifyDataSetChanged();
                            })
                            .setNegativeButton("No", null)
                            .show();
                }

                Toast.makeText(ShowTraining.this, "Ha seleccionado la opción: " + opciones[i], Toast.LENGTH_SHORT).show();
            });

            builder.setNegativeButton("CANCEL", (dialogInterface, i) -> dialogInterface.cancel());

            AlertDialog alertDialog = builder.create();
            alertDialog.show();

            return true;
        });

        back.setOnClickListener(view -> {
            Intent intent = new Intent(ShowTraining.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });

        add.setOnClickListener(view -> {

            DialogAdd dialogAdd = new DialogAdd();
            dialogAdd.show(getSupportFragmentManager(), "Test");


        });

        DialogAdd.setShowTraining(this);
        DialogModify.setShowTraining(this);

    }

    public List<Entrenamiento> iniciarArray() {

        List<Entrenamiento> tl = new ArrayList<>();

        tl.add(new Entrenamiento(1, "12/10/2022", 240, 2.0f));
        tl.add(new Entrenamiento(2, "24/01/2023", 465, 7.3f));
        tl.add(new Entrenamiento(3, "04/03/2022", 876, 1.5f));
        tl.add(new Entrenamiento(4, "09/06/2022", 263, 0.6f));
        tl.add(new Entrenamiento(5, "22/11/2022", 340, 3.1f));
        tl.add(new Entrenamiento(6, "04/03/2022", 1293, 4.2f));


        return tl;

    }

    public void mostrarTraining(int position) {

        new AlertDialog.Builder(ShowTraining.this)
                .setTitle("Training " + trainingList.get(position).getFecha() + ":")
                .setMessage(trainingList.get(position).toString())
                .setPositiveButton("OK", (dialogInterface, which) -> {
                })
                .show();
    }

    public String statistics(List<Entrenamiento> trainingList) {
        int z = trainingList.size() - 1;

        float kmTotal = 0.0f;
        float mediaMinKm = 0.0f;

        for (int i = 0; i <= z; i++) {

            kmTotal += trainingList.get(i).getDistancia();

            mediaMinKm += ((trainingList.get(i).getSegundos() / 60) / trainingList.get(i).getDistancia());

        }
        mediaMinKm = mediaMinKm / trainingList.size();

        return "Los kilometros nadados en total por el nadador logeado son " + kmTotal +
                " km y la media de los minutos por kilometro es " + mediaMinKm + ".";
    }

}