package com.example.viajestaxi;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;


public class Estadisticas extends Activity {
	TextView tv1,tv2;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_estadisticas);
		tv1=(TextView)findViewById(R.id.textView1);
		tv2=(TextView)findViewById(R.id.textView2);
		Bundle datos=getIntent().getExtras();
		tv1.setText("Cantidad de viajes diurnos: "+datos.getString("diurnos"));
		tv2.setText("Cantidad de viajes nocturnos: "+datos.getString("nocturnos"));
	}

	public void retornar (View v) {
		finish();
	}

}
