package com.example.etapia.contactfrom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText txtnombre;
    EditText txttelefono;
    EditText txtcorreo;
    EditText txtdescripcion;

    DatePicker simpleDatePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btListe = (Button)findViewById(R.id.enviar);
        btListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MainActivity.this, DetalleContact.class);

                txtnombre = (EditText)findViewById(R.id.Nombre);
                intent.putExtra("nombredeta", txtnombre.getText().toString());

                txttelefono = (EditText)findViewById(R.id.telefono);
                intent.putExtra("telefonodeta", txttelefono.getText().toString());

                txtcorreo = (EditText)findViewById(R.id.email);
                intent.putExtra("correodeta", txtcorreo.getText().toString());

                txtdescripcion = (EditText)findViewById(R.id.desc);
                intent.putExtra("descdeta", txtdescripcion.getText().toString());

                simpleDatePicker = (DatePicker) findViewById(R.id.fecha);

                int day = simpleDatePicker.getDayOfMonth();
                int month = simpleDatePicker.getMonth();
                int year = simpleDatePicker.getYear();

                intent.putExtra("dia", day);
                intent.putExtra("mes", month);
                intent.putExtra("anio", year);

                //intent.putExtra("fecha", simpleDatePicker.getYear()  +'/'+ simpleDatePicker.getMonth()+ '/' + simpleDatePicker.getDayOfMonth());

               startActivity(intent);
        }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == MainActivity.RESULT_OK){
            txtnombre   = (EditText)findViewById(R.id.Nombre);
            String resultt=data.getStringExtra("nomdeta");

            Bundle bundle = getIntent().getExtras();

            String tel  = bundle.getString("resultt").toString();
            txtnombre.setText(tel);


        }
    }
}

