package com.example.etapia.contactfrom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class DetalleContact extends AppCompatActivity {

    TextView txtdetnombre;
    TextView txtdettelefono;
    TextView txtdetcorreo;
    TextView txtdetdesc;
    TextView txtdetnom;

    TextView fechad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contact);
        Button btl = (Button)findViewById(R.id.editar);

         btl.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           //Intent intent = new Intent(DetalleContact.this, MainActivity.class);

                                           txtdetnom = (TextView)findViewById(R.id.nombred);
                                           //intent.putExtra("nomdeta", txtdetnom.getText().toString());

                                           // startActivity(intent);

                                           Intent returnIntent = new Intent();
                                           returnIntent.putExtra("nomdeta",txtdetnom.getText().toString());
                                           setResult(MainActivity.RESULT_OK,returnIntent);
                                           finish();


                                       }
                                   });
        txtdetnombre   = (TextView)findViewById(R.id.nombred);
        txtdettelefono = (TextView)findViewById(R.id.telefonod);
        txtdetcorreo   = (TextView)findViewById(R.id.correod);
        txtdetdesc     = (TextView)findViewById(R.id.descd);
        fechad         = (TextView)findViewById(R.id.fecha);

        Bundle bundle = getIntent().getExtras();

        String nom  = bundle.getString("nombredeta").toString();
        txtdetnombre.setText(" Nombre : " + nom);

        String tel  = bundle.getString("telefonodeta").toString();
        txtdettelefono.setText("Telefono : " + tel);

        String cor  = bundle.getString("correodeta").toString();
        txtdetcorreo.setText("Correo : " + cor);

        String desc  = bundle.getString("descdeta").toString();
        txtdetdesc.setText("Descripcion : " + desc);

        int dia = bundle.getInt("dia");
        int mes =bundle.getInt("mes");
        int anio = bundle.getInt("anio");
        fechad.setText("Fecha : " + String.valueOf(dia) + "/" + String.valueOf(mes + 1) + "/" + String.valueOf(anio));

    }
}
