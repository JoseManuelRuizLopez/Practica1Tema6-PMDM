package com.example.practica1tema6_pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class EditarPreferencias extends AppCompatActivity {

    Button btnAceptar, btnCancelar;
    EditText txtNumero, txtCorreo;

    Spinner spnPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_preferencias);

        spnPersonas  = (Spinner) findViewById(R.id.spinner);
        txtNumero = findViewById(R.id.txtNumero);
        txtCorreo = findViewById(R.id.txtCorreo);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar = findViewById(R.id.btnCancelar);

        //Rellenar los spinners
        ArrayAdapter arrayAdapter;
        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.spnPersonas, R.layout.support_simple_spinner_dropdown_item);
        spnPersonas.setAdapter(arrayAdapter);

        btnAceptar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                String num = "", corr = "";

                if(spnPersonas.getSelectedItem().toString().equals(getString(R.string.p1)))
                {
                   num = "Num1";
                   corr = "Corr1";
                }

                if(spnPersonas.getSelectedItem().toString().equals(getString(R.string.p2)))
                {
                    num = "Num2";
                    corr = "Corr2";
                }

                if(spnPersonas.getSelectedItem().toString().equals(getString(R.string.p3)))
                {
                    num = "Num3";
                    corr = "Corr3";
                }

                if(spnPersonas.getSelectedItem().toString().equals(getString(R.string.p4)))
                {
                    num = "Num4";
                    corr = "Corr4";
                }

                if(spnPersonas.getSelectedItem().toString().equals(getString(R.string.p5)))
                {
                    num = "Num5";
                    corr = "Corr5";
                }

                if(spnPersonas.getSelectedItem().toString().equals(getString(R.string.p6)))
                {
                    num = "Num6";
                    corr = "Corr6";
                }

                SharedPreferences prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                editor.putString(num, "tel:" + txtNumero.getText().toString());
                editor.putString(corr, txtCorreo.getText().toString());

                editor.commit();

                finish();
            }
        });

        btnCancelar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
