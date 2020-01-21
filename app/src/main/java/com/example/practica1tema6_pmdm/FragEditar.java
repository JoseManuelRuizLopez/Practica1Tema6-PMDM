package com.example.practica1tema6_pmdm;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragEditar extends Fragment {

    EditText txtNumero;
    EditText txtCorreo;
    Button btnAceptar;
    Button btnCancelar;

    public FragEditar() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_frag_editar, container, false);

        //botones(v);

        return v;
    }
/*
    public void botones(View v) {
        txtNumero = v.findViewById(R.id.txtNumero);
        txtCorreo = v.findViewById(R.id.txtCorreo);
        btnAceptar = v.findViewById(R.id.btnAceptar);
        btnCancelar = v.findViewById(R.id.btnCancelar);

        btnAceptar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnCancelar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void sss()
    {
        SharedPreferences prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
    }
*/
}
