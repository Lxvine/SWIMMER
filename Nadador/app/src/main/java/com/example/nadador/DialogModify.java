package com.example.nadador;

import android.annotation.SuppressLint;
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
import java.util.Objects;

public class DialogModify extends AppCompatDialogFragment {

    EditText et1, et2, et3;

    private static ShowTraining showTraining;
    private static int position;

    public static void setShowTraining(ShowTraining showTraining) {
        DialogModify.showTraining = showTraining;
    }

    public void setPosition(int position) {
        DialogModify.position = position;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        @SuppressLint("UseRequireInsteadOfGet") LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();

        View view = inflater.inflate(R.layout.layout_dialog_add, null);

        et1 = view.findViewById(R.id.fechaet);
        et2 = view.findViewById(R.id.segundoset);
        et3 = view.findViewById(R.id.distanciaet);

        builder.setView(view)
                .setTitle("Modificar entrenamiento: ")
                .setNegativeButton("Cancel", (dialog, which) -> {

                })

                .setPositiveButton("OK", (dialogInterface, which) -> {
                    List<Entrenamiento> training = DialogModify.showTraining.getTrainingList();
                    training.remove(position);
                    training.add(position, new Entrenamiento(training.size(), et1.getText().toString(), Integer.parseInt(et2.getText().toString()), Float.parseFloat(et3.getText().toString())));
                });


        return builder.create();
    }

}
