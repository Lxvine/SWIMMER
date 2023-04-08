package com.example.nadador;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.List;

public class DialogAdd extends AppCompatDialogFragment {

    EditText et1, et2, et3;

    private static ShowTraining showTraining;

    public static void setShowTraining(ShowTraining showTraining) {
        DialogAdd.showTraining = showTraining;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.layout_dialog_add, null);

        et1 = view.findViewById(R.id.fechaet);
        et2 = view.findViewById(R.id.segundoset);
        et3 = view.findViewById(R.id.distanciaet);

        builder.setView(view)
                .setTitle("Añadir entrenamiento: ")
                .setNegativeButton("Cancel", (dialog, which) -> {

                })

                .setPositiveButton("OK", (dialogInterface, which) -> {
                    List<Entrenamiento> training = DialogAdd.showTraining.getTrainingList();
                    training.add(new Entrenamiento(training.size(), et1.getText().toString(), Integer.parseInt(et2.getText().toString()), Float.parseFloat(et3.getText().toString())));
                });

        return builder.create();
    }

}