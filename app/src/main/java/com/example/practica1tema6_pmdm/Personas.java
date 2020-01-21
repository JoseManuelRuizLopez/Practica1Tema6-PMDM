package com.example.practica1tema6_pmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import static android.Manifest.permission.CALL_PHONE;

public class Personas extends AppCompatActivity {


    ImageView imgt1, imgt2, imgt3, imgt4, imgt5, imgt6;

    String telefono, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);

        imgt1 = findViewById(R.id.imgt1);
        imgt2 = findViewById(R.id.imgt2);
        imgt3 = findViewById(R.id.imgt3);
        imgt4 = findViewById(R.id.imgt4);
        imgt5 = findViewById(R.id.imgt5);
        imgt6 = findViewById(R.id.imgt6);

        registerForContextMenu(imgt1);
        registerForContextMenu(imgt2);
        registerForContextMenu(imgt3);
        registerForContextMenu(imgt4);
        registerForContextMenu(imgt5);
        registerForContextMenu(imgt6);

        /*
        SharedPreferences prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("Num1", "tel:666666666");
        editor.putString("Corr1", "Estamoaqui@gmail.com");

        editor.putString("Num2", "tel:689668725");
        editor.putString("Corr2", "Depressetion45@gmail.com");

        editor.putString("Num3", "tel:601391131");
        editor.putString("Corr3", "Quinterete@gmail.com");

        editor.putString("Num4", "tel:666555777");
        editor.putString("Corr4", "Theshitprogramer@gmail.com");

        editor.putString("Num5", "tel:968452366");
        editor.putString("Corr5", "Masterinos@gmail.com");

        editor.putString("Num6", "tel:854756322");
        editor.putString("Corr6", "Lordvader@gmail.com");

        editor.commit();
         */
    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();

        if (v.getId() == R.id.imgt1) {
            SharedPreferences prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
            telefono = prefs.getString("Num1", "sss");
            email = prefs.getString("Corr1", "sss");
        }

        if (v.getId() == R.id.imgt2) {
            SharedPreferences prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
            telefono = prefs.getString("Num2", "sss");
            email = prefs.getString("Corr2", "sss");
        }

        if (v.getId() == R.id.imgt3) {
            SharedPreferences prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
            telefono = prefs.getString("Num3", "sss");
            email = prefs.getString("Corr3", "sss");
        }

        if (v.getId() == R.id.imgt4) {
            SharedPreferences prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
            telefono = prefs.getString("Num4", "sss");
            email = prefs.getString("Corr4", "sss");
        }

        if (v.getId() == R.id.imgt5) {
            SharedPreferences prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
            telefono = prefs.getString("Num5", "sss");
            email = prefs.getString("Corr5", "sss");
        }

        if (v.getId() == R.id.imgt6) {
            SharedPreferences prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
            telefono = prefs.getString("Num6", "sss");
            email = prefs.getString("Corr6", "sss");
        }

        inflater.inflate(R.menu.menuconxpersonas, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnLlamar:
                if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    Intent i42 = new Intent(Intent.ACTION_CALL);
                    i42.setData(Uri.parse(telefono));
                    startActivity(i42);
                } else {
                    requestPermissions(new String[]{CALL_PHONE}, 1);
                }

                break;
            case R.id.mnCorreo:
                Intent i41 = new Intent(Intent.ACTION_SEND);
                i41.setType("text/plain");
                i41.putExtra(Intent.EXTRA_SUBJECT, "Asunto de prueba");
                i41.putExtra(Intent.EXTRA_TEXT, "Probando el envío");
                i41.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                startActivity(i41);
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuedit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String mensaje = "";
        switch (item.getItemId()) {
            case R.id.mnEdit:
                /*fragEdit = new FragEditar();
                FragmentTransaction transacction = getSupportFragmentManager().beginTransaction();
                transacction.add(R.id.contenedor, fragEdit);
                transacction.commit();
                break;

                 */

            Intent intent = new Intent(getApplicationContext(), EditarPreferencias.class);
            startActivity(intent);
        }

        return true;
    }
}
