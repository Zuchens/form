package com.sample.data;

import java.time.LocalDate;
import java.util.Date;

public class Patient {
    int id;
    LocalDate dataPrzyjecia;
    LocalDate dataPrzyjeciaDoOiT;
    LocalDate dataIntubacji;
    boolean intubacja;
    int wiek;
    boolean plecMeska;
    boolean plecKobieta;
    int wzrost;
    float waga;
    int punktacjaApache;
    int kodRozpoznania;
    boolean przyjetySor;
    boolean blokOperacyjny;
    //TODO  jaki?
    boolean innyOddzial;
    boolean innySzpital;
    LocalDate innySzpitalDate;
    boolean dps;
    String obciazeniaPrzyPrzyjeciu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataPrzyjecia() {
        return dataPrzyjecia;
    }

    public void setDataPrzyjecia(LocalDate dataPrzyjecia) {
        this.dataPrzyjecia = dataPrzyjecia;
    }

    public LocalDate getDataPrzyjeciaDoOiT() {
        return dataPrzyjeciaDoOiT;
    }

    public void setDataPrzyjeciaDoOiT(LocalDate dataPrzyjeciaDoOiT) {
        this.dataPrzyjeciaDoOiT = dataPrzyjeciaDoOiT;
    }

    public LocalDate getDataIntubacji() {
        return dataIntubacji;
    }

    public void setDataIntubacji(LocalDate dataIntubacji) {
        this.dataIntubacji = dataIntubacji;
    }

    public boolean isIntubacja() {
        return intubacja;
    }

    public void setIntubacja(boolean intubacja) {
        this.intubacja = intubacja;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public boolean isPlecMeska() {
        return plecMeska;
    }

    public void setPlecMeska(boolean plecMeska) {
        this.plecMeska = plecMeska;
    }

    public boolean isPlecKobieta() {
        return plecKobieta;
    }

    public void setPlecKobieta(boolean plecKobieta) {
        this.plecKobieta = plecKobieta;
    }

    public int getWzrost() {
        return wzrost;
    }

    public void setWzrost(int wzrost) {
        this.wzrost = wzrost;
    }

    public float getWaga() {
        return waga;
    }

    public void setWaga(float waga) {
        this.waga = waga;
    }

    public int getPunktacjaApache() {
        return punktacjaApache;
    }

    public void setPunktacjaApache(int punktacjaApache) {
        this.punktacjaApache = punktacjaApache;
    }

    public int getKodRozpoznania() {
        return kodRozpoznania;
    }

    public void setKodRozpoznania(int kodRozpoznania) {
        this.kodRozpoznania = kodRozpoznania;
    }

    public boolean isPrzyjetySor() {
        return przyjetySor;
    }

    public void setPrzyjetySor(boolean przyjetySor) {
        this.przyjetySor = przyjetySor;
    }

    public boolean isBlokOperacyjny() {
        return blokOperacyjny;
    }

    public void setBlokOperacyjny(boolean blokOperacyjny) {
        this.blokOperacyjny = blokOperacyjny;
    }

    public boolean isInnyOddzial() {
        return innyOddzial;
    }

    public void setInnyOddzial(boolean innyOddzial) {
        this.innyOddzial = innyOddzial;
    }

    public boolean isInnySzpital() {
        return innySzpital;
    }

    public void setInnySzpital(boolean innySzpital) {
        this.innySzpital = innySzpital;
    }

    public LocalDate getInnySzpitalDate() {
        return innySzpitalDate;
    }

    public void setInnySzpitalDate(LocalDate innySzpitalDate) {
        this.innySzpitalDate = innySzpitalDate;
    }

    public boolean isDps() {
        return dps;
    }

    public void setDps(boolean dps) {
        this.dps = dps;
    }

    public String getObciazeniaPrzyPrzyjeciu() {
        return obciazeniaPrzyPrzyjeciu;
    }

    public void setObciazeniaPrzyPrzyjeciu(String obciazeniaPrzyPrzyjeciu) {
        this.obciazeniaPrzyPrzyjeciu = obciazeniaPrzyPrzyjeciu;
    }
}
