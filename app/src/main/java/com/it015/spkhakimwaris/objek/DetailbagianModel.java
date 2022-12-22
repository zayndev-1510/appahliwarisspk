package com.it015.spkhakimwaris.objek;

public class DetailbagianModel {

    String value;
    String konten;


    public DetailbagianModel() {
    }

    public DetailbagianModel(String value, String konten) {
        this.value = value;
        this.konten = konten;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }
}
