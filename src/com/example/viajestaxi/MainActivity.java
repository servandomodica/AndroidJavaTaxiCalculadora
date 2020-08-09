package com.example.viajestaxi;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;


public class MainActivity extends Activity {
	Spinner sp1,sp2;
	EditText et1;
	RadioButton r1,r2;
	TextView tvcantidad,tvrecaudado;
	int cantViajes,diurnos,nocturnos;
	float totalRecaudado;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp1=(Spinner)findViewById(R.id.spinner1);
        sp2=(Spinner)findViewById(R.id.spinner2);
        et1=(EditText)findViewById(R.id.editText1);
        r1=(RadioButton)findViewById(R.id.radio0);
        r2=(RadioButton)findViewById(R.id.radio1);
        tvcantidad=(TextView)findViewById(R.id.textView4);
        tvrecaudado=(TextView)findViewById(R.id.textView5);
        String[] barrios={"General Paz","Alberdi","Cerro","Centro"};
        ArrayAdapter<String> adaptador1=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, barrios);
        sp1.setAdapter(adaptador1);
        sp2.setAdapter(adaptador1);
    }

    public void procesar (View v) {
    	String barrio1=sp1.getSelectedItem().toString();
    	String barrio2=sp2.getSelectedItem().toString();
    	if (barrio1.equals(barrio2)) {
    		Toast.makeText(this, "Debe seleccionar barrios diferentes", Toast.LENGTH_LONG).show();
    		return;
    	}
    	String s=et1.getText().toString();
    	if (s.length()==0) {
    		Toast.makeText(this, "Debe cargar un importe", Toast.LENGTH_LONG).show();
    		return;
    	}
    	float costo=Float.parseFloat(s);
    	totalRecaudado=totalRecaudado+costo;
    	cantViajes++;
    	tvcantidad.setText("Cantidad de viajes: "+cantViajes);
    	tvrecaudado.setText("Total recaudado: "+totalRecaudado);
    	if (r1.isChecked()) {
    		diurnos++;
    	}
    	if (r2.isChecked()) {
    		nocturnos++;
    	}
    }
    
    public void verEstadisticas (View v) {
    	Intent intento1=new Intent(this, Estadisticas.class);
    	intento1.putExtra("diurnos", String.valueOf(diurnos));
    	intento1.putExtra("nocturnos", String.valueOf(nocturnos));    	
    	startActivity(intento1);
    }
    
}
