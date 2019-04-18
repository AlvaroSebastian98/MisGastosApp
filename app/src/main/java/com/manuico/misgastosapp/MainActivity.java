package com.manuico.misgastosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import im.dacer.androidcharts.PieHelper;
import im.dacer.androidcharts.PieView;

public class MainActivity extends AppCompatActivity {

    private static final int REGISTER_FORM_REQUEST = 100;

    private ListView list;
    private TextView totalFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalFinal = findViewById(R.id.total);
        list = (ListView) findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        list.setAdapter(adapter);
    }

    public void addItem(View view){
        startActivityForResult(new Intent(this, RegisterActivity.class), REGISTER_FORM_REQUEST);
    }

    // return from RegisterActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        double totalGastos = 0;
        double totalIngresos = 0;
        double total;

        // refresh data
        ArrayAdapter<String> adapter = (ArrayAdapter<String>)list.getAdapter();

        adapter.clear();

        GastoRepository gastoRepository = GastoRepository.getInstance();
        IngresoRepository ingresoRepository = IngresoRepository.getInstance();

        List<Gasto> gastos = gastoRepository.getGastos();
        List<Ingreso> ingresos = ingresoRepository.getIngresos();

        System.out.println(gastos);

        Pie pie = AnyChart.pie();
        List<DataEntry> data2 = new ArrayList<>();

        for (Gasto gasto : gastos) {
            adapter.add(gasto.getDetalle() + ": -" + gasto.getMonto());
            data2.add(new ValueDataEntry(gasto.getDetalle(), gasto.getMonto()));
            totalGastos += gasto.getMonto();
        }

        for (Ingreso ingreso : ingresos) {
            adapter.add(ingreso.getDetalle() + ": +" + ingreso.getMonto());
            data2.add(new ValueDataEntry(ingreso.getDetalle(), ingreso.getMonto()));
            totalIngresos += ingreso.getMonto();
        }

        pie.data(data2);

        AnyChartView anyChartView = (AnyChartView) findViewById(R.id.any_chart_view);
        anyChartView.setChart(pie);

        adapter.notifyDataSetChanged();

        total = totalIngresos - totalGastos;
        totalFinal.setText("" + total);


    }

}
