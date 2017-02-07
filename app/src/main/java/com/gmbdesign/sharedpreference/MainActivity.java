package com.gmbdesign.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos la referencia al objeto SharedPreferences, si no existe crea uno nuevo
        SharedPreferences sharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE);

        //podemos obtener valores buscando por clave. Nos obliga a indicar un valor por defecto
        int nveces = sharedPreferences.getInt("nveces", -1);
        Log.e("TAG", "nveces = " + nveces);

        //contador para controlar las veces que un usuario a usado nuestra aplicacion
        nveces = (nveces == -1) ? 1: ++nveces;

        //Para añadir información necesitamos un editor
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("nveces", nveces);
        editor.commit(); //importante hacer el commit para setear los datos
    }
}
