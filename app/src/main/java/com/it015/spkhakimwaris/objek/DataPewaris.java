package com.it015.spkhakimwaris.objek;

public class DataPewaris {

    String value;
    String ket;
    String jenis_kelamin;
    int nilai;
    boolean status;
    int step;
    double bagian;

    public DataPewaris(double bagian) {
        this.bagian = bagian;
    }

    public double getBagian() {
        return bagian;
    }

    public void setBagian(double bagian) {
        this.bagian = bagian;
    }

    public DataPewaris() {
    }
    public DataPewaris(String value, String ket, String jenis_kelamin, int nilai, boolean status, int step,double bagian) {
        this.value = value;
        this.ket = ket;
        this.jenis_kelamin = jenis_kelamin;
        this.nilai = nilai;
        this.status = status;
        this.step = step;
        this.bagian=bagian;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }



    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }




}
