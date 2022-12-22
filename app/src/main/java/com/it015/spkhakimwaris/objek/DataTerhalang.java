package com.it015.spkhakimwaris.objek;

public class DataTerhalang {

    String value;
    String ket;
    int nilai;
    boolean status;
    String jenis_kelamin;
    String aturan;
    int step;

    public DataTerhalang() {
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public DataTerhalang(String value, String ket, int nilai,
                         boolean status, String jenis_kelamin, String aturan, int step) {
        this.value = value;
        this.ket = ket;
        this.nilai = nilai;
        this.status = status;
        this.jenis_kelamin = jenis_kelamin;
        this.aturan = aturan;
        this.step=0;
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

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAturan() {
        return aturan;
    }

    public void setAturan(String aturan) {
        this.aturan = aturan;
    }
}
