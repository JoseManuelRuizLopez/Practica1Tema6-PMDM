package com.example.practica1tema6_pmdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgPersona;
    ImageView imgBloc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPersona = findViewById(R.id.imgPersona);
        imgBloc  =findViewById(R.id.imgBloc);

        imgPersona.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Personas.class);
                startActivity(intent);
            }
        });

        imgBloc.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BlocDeNotas.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnPersonas:
                Intent intent = new Intent(getApplicationContext(), Personas.class);
                startActivity(intent);
                break;

            case R.id.mnBloc:
                Intent intent1 = new Intent(getApplicationContext(), BlocDeNotas.class);
                startActivity(intent1);
                break;
        }

        return true;
    }


}
