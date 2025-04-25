package com.example.osobistepowitanie;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_COUNT = "licznik";
    private int licznik = 0;
    Button przycisk1;
    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Przypisanie przycisków
        przycisk1 = findViewById(R.id.przycisk1);
        edittext = findViewById(R.id.edittext);

        // Przywracanie stanu
        if (savedInstanceState != null) {
            licznik = savedInstanceState.getInt(KEY_COUNT);
        }
        textview.setText("Dane usunięto: " + licznik + " razy");

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                licznik = 0;
                textview.setText("Dane usunięto: " + licznik + " razy");
            }
        });

        przycisk1.setOnClickListener(v -> showAlertDialog());
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Prosty AlertDialog");
        builder.setMessage("Czy na pewno chcesz usunąć dane?");

        builder.setPositiveButton("TAK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                licznik++;
                textview.setText("Dane usunięto: " + licznik + " razy");
                Toast.makeText(MainActivity.this, "Dane zostały usunięte", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("NIE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Kliknięto Anuluj", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create().show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, licznik);
    }
}
