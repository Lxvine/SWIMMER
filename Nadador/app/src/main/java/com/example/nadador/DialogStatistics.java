package com.example.nadador;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.List;

public class DialogStatistics extends AppCompatDialogFragment {

    ShowTraining st = new ShowTraining();

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        List<Entrenamiento> training = st.iniciarArray();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Estadísticas: ")
                .setMessage(st.statistics(training))
                .setPositiveButton("OK", (dialogInterface, i) -> {

                });

        return builder.create();

    }

}
