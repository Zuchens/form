/*
 * Copyright 2000-2016 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.sample.data;

/**
 * @author Vaadin Ltd
 *
 */
public class Data {

    private int day;
    private int id;
    private int czasDoby;

    private boolean inwazyjneMw;
    private boolean nieinwazyjneMw;

    private boolean wazopresory;
    private boolean noradrenalina;
    private boolean adrenalina;
    private boolean dobutamina;
    private boolean dopamina;

    private boolean dializa;
    private boolean ihd;
    private boolean cvvhd;
    private boolean cvvhf;
    private boolean cvvhdf;

    public float wbc;
    public float rbc;
    public float hb;
    public float plt;
    public float hco3;
    public float na;
    public float k;
    public float cl;
    public float crea;
    public float albuminy;
    public float ca;
    public float mg;
    public float ri;
    public float crp;
    public float pct;

    public boolean rehabilitacja;


    public boolean nowyAntybiotyk;
    public boolean zmianaAntybiotyk;

    public boolean infekcjaOddechowa;
    public boolean infekcjaKrwiopochodna;
    public boolean infekcjaJamyBrzusznej;
    public boolean infekcjaUkladuMoczowego;
    public boolean infekcjaInne;

    public boolean pantoprazol;
    public boolean metoklopramid;
    public boolean laktuloza;
    public boolean enema;
    public boolean bisakodyl;
    public boolean lekiZwiotczajace;

    public boolean opioidy;

    public float Morfina;
    public float Oksykodon;
    public float Propofol;
    public float Midazolam;
    public float Fentanyl;
    public float Dexdor;
    public float Ketamina;
    public float Estazolam;
    public float Tiopental;
    public String opioidyInne;

    public String getOpioidyInne() {
        return opioidyInne;
    }

    public void setOpioidyInne(String opioidyInne) {
        this.opioidyInne = opioidyInne;
    }

    public boolean IsAntybiotyki;
    public Antybiotyki Antybiotyki = new Antybiotyki();

    public boolean IsZywienieEN;

    public boolean isZywienieEN() {
        return IsZywienieEN;
    }

    public void setZywienieEN(boolean zywienieEN) {
        IsZywienieEN = zywienieEN;
    }

    public ZywienieEN ZywienieEN = new ZywienieEN();

    public boolean isZywienieTPN() {
        return isZywienieTPN;
    }

    public void setZywienieTPN(boolean zywienieTPN) {
        isZywienieTPN = zywienieTPN;
    }

    public boolean isZywienieTPN;
    public ZywienieTPN ZywienieTPN = new ZywienieTPN();

    public boolean isZywienieDoustna;
    public ZywienieDoustna ZywienieDoustna = new ZywienieDoustna();

    public boolean isZywienieNPO;


    public boolean isZywienieDodatkowaWoda;
    public ZywienieDodatkowaWoda ZywienieDodatkowaWoda = new ZywienieDodatkowaWoda();

    public boolean jesc;
    public boolean pic;

    public boolean zglebnikNos;

    public boolean isZglebnikNos() {
        return zglebnikNos;
    }

    public void setZglebnikNos(boolean zglebnikNos) {
        this.zglebnikNos = zglebnikNos;
    }

    public boolean isZglebnikUsta() {
        return zglebnikUsta;
    }

    public void setZglebnikUsta(boolean zglebnikUsta) {
        this.zglebnikUsta = zglebnikUsta;
    }

    public boolean isZglebnikPEG() {
        return zglebnikPEG;
    }

    public void setZglebnikPEG(boolean zglebnikPEG) {
        this.zglebnikPEG = zglebnikPEG;
    }

    public boolean isZglebnikBrak() {
        return zglebnikBrak;
    }

    public void setZglebnikBrak(boolean zglebnikBrak) {
        this.zglebnikBrak = zglebnikBrak;
    }

    public boolean zglebnikUsta;
    public boolean zglebnikPEG;
    public boolean zglebnikBrak;

    public Stolec Stolec = new Stolec();

    public boolean isOstatniDzien() {
        return isOstatniDzien;
    }

    public void setOstatniDzien(boolean ostatniDzien) {
        isOstatniDzien = ostatniDzien;
    }

    public boolean isOstatniDzien;
    public OstatniDzien OstatniDzien = new OstatniDzien();

    public boolean isJesc() {
        return jesc;
    }

    public void setJesc(boolean jesc) {
        this.jesc = jesc;
    }

    public boolean isPic() {
        return pic;
    }

    public void setPic(boolean pic) {
        this.pic = pic;
    }
    public boolean isZywienieDoustna() {
        return isZywienieDoustna;
    }

    public void setZywienieDoustna(boolean zywienieDoustna) {
        isZywienieDoustna = zywienieDoustna;
    }

    public boolean isZywienieNPO() {
        return isZywienieNPO;
    }

    public void setZywienieNPO(boolean zywienieNPO) {
        isZywienieNPO = zywienieNPO;
    }

    public boolean isZywienieDodatkowaWoda() {
        return isZywienieDodatkowaWoda;
    }

    public void setZywienieDodatkowaWoda(boolean zywienieDodatkowaWoda) {
        isZywienieDodatkowaWoda = zywienieDodatkowaWoda;
    }

    public boolean isAntybiotyki() {
        return IsAntybiotyki;
    }

    public void setAntybiotyki(boolean antybiotyki) {
        IsAntybiotyki = antybiotyki;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCzasDoby() {
        return czasDoby;
    }

    public void setCzasDoby(int czasDoby) {
        this.czasDoby = czasDoby;
    }

    public boolean isInwazyjneMw() {
        return inwazyjneMw;
    }

    public void setInwazyjneMw(boolean inwazyjneMw) {
        this.inwazyjneMw = inwazyjneMw;
    }

    public boolean isNieinwazyjneMw() {
        return nieinwazyjneMw;
    }

    public void setNieinwazyjneMw(boolean nieinwazyjneMw) {
        this.nieinwazyjneMw = nieinwazyjneMw;
    }

    public boolean isWazopresory() {
        return wazopresory;
    }

    public void setWazopresory(boolean wazopresory) {
        this.wazopresory = wazopresory;
    }

    public boolean isNoradrenalina() {
        return noradrenalina;
    }

    public void setNoradrenalina(boolean noradrenalina) {
        this.noradrenalina = noradrenalina;
    }

    public boolean isAdrenalina() {
        return adrenalina;
    }

    public void setAdrenalina(boolean adrenalina) {
        this.adrenalina = adrenalina;
    }

    public boolean isDobutamina() {
        return dobutamina;
    }

    public void setDobutamina(boolean dobutamina) {
        this.dobutamina = dobutamina;
    }

    public boolean isDopamina() {
        return dopamina;
    }

    public void setDopamina(boolean dopamina) {
        this.dopamina = dopamina;
    }

    public boolean isDializa() {
        return dializa;
    }

    public void setDializa(boolean dializa) {
        this.dializa = dializa;
    }

    public boolean isIhd() {
        return ihd;
    }

    public void setIhd(boolean ihd) {
        this.ihd = ihd;
    }

    public boolean isCvvhd() {
        return cvvhd;
    }

    public void setCvvhd(boolean cvvhd) {
        this.cvvhd = cvvhd;
    }

    public boolean isCvvhf() {
        return cvvhf;
    }

    public void setCvvhf(boolean cvvhf) {
        this.cvvhf = cvvhf;
    }

    public boolean isCvvhdf() {
        return cvvhdf;
    }

    public void setCvvhdf(boolean cvvhdf) {
        this.cvvhdf = cvvhdf;
    }

    public boolean isOpioidy() {
        return opioidy;
    }

    public void setOpioidy(boolean opioidy) {
        this.opioidy = opioidy;
    }
}