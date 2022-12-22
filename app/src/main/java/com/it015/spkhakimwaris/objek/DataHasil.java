package com.it015.spkhakimwaris.objek;

public class DataHasil {

    String value;
    String ahli_waris;
    double bagian;
    double jumlah;
    double saham;
    double harta_bagian;
    double harta_perorang;
    boolean status_ashobah;
    boolean status_bilgoir;
    boolean status_maal_goir;
    int ashobah_bil_goir_1;
    int ashobah_bil_goir_2;
    int total_bilgoir=0;
    String ket_bagian;


    public String getKet_bagian() {
        return ket_bagian;
    }

    public void setKet_bagian(String ket_bagian) {
        this.ket_bagian = ket_bagian;
    }

    String formatRupiah;

    public String getFormatRupiah() {
        return formatRupiah;
    }

    public void setFormatRupiah(String formatRupiah) {
        this.formatRupiah = formatRupiah;
    }

    public int getTotal_bilgoir() {
        return total_bilgoir;
    }

    public void setTotal_bilgoir(int total_bilgoir) {
        this.total_bilgoir = total_bilgoir;
    }

    public int getAshobah_bil_goir_1() {
        return ashobah_bil_goir_1;
    }

    public void setAshobah_bil_goir_1(int ashobah_bil_goir_1) {
        this.ashobah_bil_goir_1 = ashobah_bil_goir_1;
    }

    public int getAshobah_bil_goir_2() {
        return ashobah_bil_goir_2;
    }

    public void setAshobah_bil_goir_2(int ashobah_bil_goir_2) {
        this.ashobah_bil_goir_2 = ashobah_bil_goir_2;
    }

    public boolean isStatus_bilgoir() {
        return status_bilgoir;
    }

    public void setStatus_bilgoir(boolean status_bilgoir) {
        this.status_bilgoir = status_bilgoir;
    }

    public boolean isStatus_maal_goir() {
        return status_maal_goir;
    }

    public void setStatus_maal_goir(boolean status_maal_goir) {
        this.status_maal_goir = status_maal_goir;
    }

    public boolean isStatus_ashobah() {
        return status_ashobah;
    }

    public void setStatus_ashobah(boolean status_ashobah) {
        this.status_ashobah = status_ashobah;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAhli_waris() {
        return ahli_waris;
    }

    public void setAhli_waris(String ahli_waris) {
        this.ahli_waris = ahli_waris;
    }

    public double getBagian() {
        return bagian;
    }

    public void setBagian(double bagian) {
        this.bagian = bagian;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public double getSaham() {
        return saham;
    }

    public void setSaham(double saham) {
        this.saham = saham;
    }

    public double getHarta_bagian() {
        return harta_bagian;
    }

    public void setHarta_bagian(double harta_bagian) {
        this.harta_bagian = harta_bagian;
    }

    public double getHarta_perorang() {
        return harta_perorang;
    }

    public void setHarta_perorang(double harta_perorang) {
        this.harta_perorang = harta_perorang;
    }

    public DataHasil() {
    }

    public DataHasil(String value, String ahli_waris, double bagian, double jumlah, double saham, double harta_bagian, double harta_perorang) {
        this.value = value;
        this.ahli_waris = ahli_waris;
        this.bagian = bagian;
        this.jumlah = jumlah;
        this.saham = saham;
        this.harta_bagian = harta_bagian;
        this.harta_perorang = harta_perorang;
    }
}
