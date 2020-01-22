package com.example.practica1tema6_pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class BlocDeNotas extends AppCompatActivity {

    EditText txtarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloc_de_notas);

        txtarea = (EditText)findViewById(R.id.txtArea);

        SharedPreferences prefs = getSharedPreferences("ficheroblocnotas", Context.MODE_PRIVATE);

        txtarea.setText(prefs.getString("bloc", "No existe texto guardado"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuicono, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnGuardar:

                SharedPreferences prefs = getSharedPreferences("ficheroblocnotas", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                editor.putString("bloc", txtarea.getText().toString());

                editor.commit();
                Toast.makeText(this, "Texto Guardado", Toast.LENGTH_SHORT).show();

                break;
        }

        return true;
    }
}
