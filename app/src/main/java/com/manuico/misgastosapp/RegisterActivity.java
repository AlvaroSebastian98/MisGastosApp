package com.manuico.misgastosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText detailInput;
    private EditText amountInput;
    private EditText detalleIngresos;
    private EditText montoIngresos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        detailInput = (EditText)findViewById(R.id.detail_input);
        amountInput = (EditText)findViewById(R.id.amount_input);
        detalleIngresos = (EditText)findViewById(R.id.detalle_ingresos);
        montoIngresos = (EditText)findViewById(R.id.monto_ingresos);
    }

    public void register(View view){
        String detalle = detailInput.getText().toString();
        String monto = amountInput.getText().toString();

        if(detalle.isEmpty() || monto.isEmpty()){
            Toast.makeText(this, "You must complete these fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Gasto gasto = new Gasto(detalle, Double.parseDouble(monto));

        GastoRepository gastoRepository = GastoRepository.getInstance();
        gastoRepository.agregarGasto(gasto);

        finish();

    }

    public void registerIngresos(View view){
        String detalle = detalleIngresos.getText().toString();
        String monto = montoIngresos.getText().toString();

        if(detalle.isEmpty() || monto.isEmpty()){
            Toast.makeText(this, "You must complete these fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Ingreso ingreso = new Ingreso(detalle, Double.parseDouble(monto));

        IngresoRepository ingresoRepository = IngresoRepository.getInstance();
        ingresoRepository.agregarIngreso(ingreso);

        finish();

    }

}
