package com.example.aplicacion_alumno;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CargaAcademica {
    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("claveTipoCarga")
    @Expose
    private String tipoCarga;
    @SerializedName("matriculaAlumno")
    @Expose
    private String matriculaAlumno;
    @SerializedName("idPeriodo")
    @Expose
    private  int idPeriodo;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public String getMatriculaAlumno() {
        return matriculaAlumno;
    }

    public void setMatriculaAlumno(String matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }
}
