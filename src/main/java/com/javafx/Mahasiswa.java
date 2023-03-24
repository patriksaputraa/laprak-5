package com.javafx;

import java.util.StringTokenizer;

public class Mahasiswa {
    private String nim,nama,kota;

    public Mahasiswa(String nim, String nama, String kota){
        this.nim = nim;
        this.nama = nama;
        this.kota = kota;
    }

    public String getNim() {
        return nim;
    }

    public boolean cekNim(){
        boolean check_nim = true;
        char temp_nim;
        for (int i = 0; i < this.nim.length(); i++) {
            temp_nim = this.nim.charAt(i);
            if(!(Character.isDigit(temp_nim))){
                check_nim = false;
                break;
            }
        }
        return check_nim;
    }

    public void setNim(String nim) {
        nim += "00000000";
        if(nim.length()>8){
            if(cekNim()==true){
                this.nim = nim.substring(0, 8);
            }
        }
    }

    public boolean cekString(){
        boolean check_string = true;
        char temp_string;
        for (int i = 0; i < this.nama.length(); i++) {
            temp_string = this.nama.charAt(i);
            if(Character.isDigit(temp_string)){
                check_string = false;
                break;
            }
        }
        return check_string;
    }

    public void setNama(String nama) {
        String temp_nama = "";
        String capitalized = "";
        StringTokenizer st = new StringTokenizer(nama, " ");
        for(int i = 0; i<st.countTokens()+1;i++){
            temp_nama = st.nextToken();
            capitalized += temp_nama.substring(0,1).toUpperCase() + temp_nama.substring(1);
            if(i<st.countTokens()){
                capitalized += " ";
            }
        }
        this.nama = capitalized;
    }

    public String getNama() {
        return nama;
    }

    public String getKota() {
        return kota.toUpperCase();
    }

    public void setKota(String kota) {
        this.kota = kota.toUpperCase();
    }

    public String getMahasiswa(){
        return getNim() + "," + getNama() + "," + getKota();
    }
}
