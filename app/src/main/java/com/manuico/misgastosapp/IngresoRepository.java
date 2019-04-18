package com.manuico.misgastosapp;

import java.util.ArrayList;
import java.util.List;

public class IngresoRepository {

    private static IngresoRepository _INSTANCE = null;

    private IngresoRepository(){}

    public static IngresoRepository getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new IngresoRepository();
        return _INSTANCE;
    }

    private List<Ingreso> ingresos = new ArrayList<>();

    public List<Ingreso> getIngresos() {
        return this.ingresos;
    }

    public void agregarIngreso(Ingreso ingreso){
        this.ingresos.add(ingreso);
    }


}
