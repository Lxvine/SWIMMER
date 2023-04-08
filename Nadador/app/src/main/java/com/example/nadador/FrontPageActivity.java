package com.example.nadador;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class FrontPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        Objects.requireNonNull(getSupportActionBar()).hide();

        final Timer t = new Timer ();
        t.schedule(new TimerTask() {
            @Override
            public void run () {
                Intent intent = new Intent(FrontPageActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}