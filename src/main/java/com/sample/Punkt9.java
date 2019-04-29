package com.sample;

import com.google.common.collect.ImmutableList;
import com.sample.data.Data;
import com.vaadin.data.Binder;
import com.vaadin.ui.*;

import java.lang.reflect.Field;
import java.util.List;

import static com.sample.DataDay.addToLayout;
import static com.sample.Punkt2.twoCheckBoxes;

public class Punkt9 {

    private static class Names{

        private final String showText;
        private final String className;
        private final String booleanName;
        List<String> names;
        Names(List<String> names, String showText, String className, String booleanName){
            this.names = names;
            this.showText = showText;
            this.className = className;
            this.booleanName = booleanName;
        }
    }


    public static void punkt9(VerticalLayout layout, Binder<Data> binder) {
        CheckBox antybiotyki = twoCheckBoxes(layout, "9. Antybiotyki");
        binder.forField(antybiotyki).bind(Data::isAntybiotyki, Data::setAntybiotyki);

        VerticalLayout hl = new VerticalLayout();
        ImmutableList<String> listBetaLaktamy = ImmutableList.of("Ampicylina", "Amoksycylina", "Kloksacylina", "Augumentin", "Piperacylina");
        Names namesBetaLaktamy = new Names(listBetaLaktamy, "beta-laktamy", "BetaLaktamy", "isBetaLaktamy");
        VerticalLayout betaLaktamy = doubleNested(hl, binder, namesBetaLaktamy);
        TextField betaLaktamyInne = new TextField();
        addToLayout(betaLaktamy, betaLaktamyInne, "Inne", "0");
        binder.forField(betaLaktamyInne).bind(x-> x.Antybiotyki.BetaLaktamy.getInne(),(x, y)-> x.Antybiotyki.BetaLaktamy.setInne(y));


        ImmutableList<String> listCefalosporyny = ImmutableList.of("Ceftriakson","Cefaleksyna","Cefpodoksym", "Cefotaksym", "Cefuroksym", "Cefepim");
        Names namesCefalosporyny = new Names(listCefalosporyny, "Cefalosporyny", "Cefalosporyny", "isCefalosporyny");
        VerticalLayout Cefalosporyny = doubleNested(hl, binder, namesCefalosporyny);
        TextField CefalosporynyInne = new TextField();
        addToLayout(Cefalosporyny, CefalosporynyInne, "Inne", "0");
        binder.forField(CefalosporynyInne).bind(x-> x.Antybiotyki.Cefalosporyny.getInne(),(x, y)-> x.Antybiotyki.Cefalosporyny.setInne(y));

        ImmutableList<String> listKarbapenemy = ImmutableList.of("Meropenem");
        Names namesKarbapenemy = new Names(listKarbapenemy, "Karbapenemy", "Karbapenemy", "isKarbapenemy");
        doubleNested(hl, binder, namesKarbapenemy);

        ImmutableList<String> listAminoglikozydy = ImmutableList.of("Gentamycyna", "Tobramycyna", "Amikacyna");
        Names namesAminoglikozydy = new Names(listAminoglikozydy, "Aminoglikozydy", "Aminoglikozydy", "isAminoglikozydy");
        doubleNested(hl, binder, namesAminoglikozydy);

        ImmutableList<String> listChinolony = ImmutableList.of("Lewofloksacyna", "Ciprofloksacyna", "Moksyfloksacyna");
        Names namesChinolony = new Names(listChinolony, "Chinolony", "Chinolony", "isChinolony");
        doubleNested(hl, binder, namesChinolony);

        ImmutableList<String> listTetracykliny = ImmutableList.of("Tygecyklina");
        Names namesTetracykliny = new Names(listTetracykliny, "Tetracykliny", "Tetracykliny", "isTetracykliny");
        doubleNested(hl, binder, namesTetracykliny);

        ImmutableList<String> listNitromidazole = ImmutableList.of("MetronidazolIv", "Metronidazolpo");
        Names namesNitromidazole = new Names(listNitromidazole, "Nitromidazole", "Nitromidazole", "isNitromidazole");
        doubleNested(hl, binder, namesNitromidazole);

        ImmutableList<String> listLinkozamidy = ImmutableList.of("Klindamycyna");
        Names namesLinkozamidy = new Names(listLinkozamidy, "Linkozamidy", "Linkozamidy", "isLinkozamidy");
        doubleNested(hl, binder, namesLinkozamidy);

        ImmutableList<String> listMakrolidy = ImmutableList.of("Klarytromycyna", "Azytromycyna");
        Names namesMakrolidy = new Names(listMakrolidy, "Makrolidy", "Makrolidy", "isMakrolidy");
        doubleNested(hl, binder, namesMakrolidy );

        ImmutableList<String> listMonobaktamy = ImmutableList.of("Aztreonam");
        Names namesMonobaktamy = new Names(listMonobaktamy, "Monobaktamy", "Monobaktamy", "isMonobaktamy");
        doubleNested(hl, binder, namesMonobaktamy );

        ImmutableList<String> listPrzeciwwirusowe = ImmutableList.of();
        Names namesPrzeciwwirusowe = new Names(listPrzeciwwirusowe, "Przeciwwirusowe", "Przeciwwirusowe", "isPrzeciwwirusowe");
        doubleNested(hl, binder, namesPrzeciwwirusowe);

        ImmutableList<String> listAzole = ImmutableList.of("Flukonazol","Worykonazol", "Pozakonazol","Amfoterycyna" );
        Names namesAzole = new Names(listAzole, "Azole", "Azole", "isAzole");
        doubleNested(hl, binder, namesAzole);

        ImmutableList<String> listEchinokandydy = ImmutableList.of("Mikafungina");
        Names namesEchinokandydy = new Names(listEchinokandydy, "Echinokandydy", "Echinokandydy", "isEchinokandydy");
        doubleNested(hl, binder, namesEchinokandydy);


        ImmutableList<String> listAntybiotykiInne = ImmutableList.of("Biseptol", "Ryfaksymina","Linezolid", "Fosfomycyna");
        Names namesAntybiotykiInne = new Names(listAntybiotykiInne, "Inne antybiotyki", "AntybiotykiInne", "isAntybiotykiInne");
        VerticalLayout antybiotykiInne = doubleNested(hl, binder, namesAntybiotykiInne);
        TextField antybiotykiInneInne = new TextField();
        addToLayout(antybiotykiInne, antybiotykiInneInne, "Inne", "0");
        binder.forField(antybiotykiInneInne).bind(x-> x.Antybiotyki.AntybiotykiInne.getInne(),(x, y)-> x.Antybiotyki.AntybiotykiInne.setInne(y));


        hl.setVisible(false);
        layout.addComponent(hl);
        antybiotyki.addValueChangeListener(
                event ->{
                    if(antybiotyki.getValue()) {
                        hl.setVisible(true);
                    }
                    else {
                        hl.setVisible(false);
                    }
                }
        );
    }

    static VerticalLayout doubleNested(VerticalLayout layout, Binder<Data> binder, Names names) {
        CheckBox betaLaktamy = twoCheckBoxes(layout, names.showText);
        betaLaktamy.setValue(false);
        setNestedClassFromName(betaLaktamy, binder,"Antybiotyki", names.booleanName);

        VerticalLayout h2 = new VerticalLayout();
        for(String name : names.names) {
            setNestedCheckboxes(h2, binder, "Antybiotyki", names.className, name);
        }
        layout.addComponent(h2);
        betaLaktamy.addValueChangeListener(
                event ->{
                    if(betaLaktamy.getValue()) {
                        h2.setVisible(true);
                    }
                    else {
                        h2.setVisible(false);
                    }
                }
        );
        h2.setVisible(false);
        layout.addComponent(h2);
        return h2;
    }

    static void setNestedCheckboxes(VerticalLayout h2, Binder<Data> binder, String dataField, String fieldName, String fieldName2) {
        CheckBox check = twoCheckBoxes(h2, fieldName2);
        setDoubleNestedClassFromName(check, binder, dataField, fieldName, fieldName2);
    }

    static void setDoubleNestedClassFromName(AbstractField betaLaktamy, Binder<Data> binder, String dataField, String fieldName, String fieldName2) {
        binder.forField(betaLaktamy)
                .bind(x-> {
                    try {
                        Field antybiotyki = x.getClass().getField(dataField);
                        Object antybiotykObject = antybiotyki.get(x);
                        Field konkretnyAntybiotyk = antybiotykObject.getClass().getField(fieldName);
                        Object konkretnyAntybiotykObject = konkretnyAntybiotyk.get(antybiotykObject);
                        System.out.println(fieldName2);
                        Field f = konkretnyAntybiotykObject.getClass().getField(fieldName2);
                        return (Boolean) f.get(konkretnyAntybiotykObject);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return null;
                }, (x, y)->{
                    try {
                        Field antybiotyki = x.getClass().getField(dataField);
                        Object antybiotykObject = antybiotyki.get(x);
                        Field konkretnyAntybiotyk = antybiotykObject.getClass().getField(fieldName);
                        Object konkretnyAntybiotykObject = konkretnyAntybiotyk.get(antybiotykObject);
                        Field f = konkretnyAntybiotykObject.getClass().getField(fieldName2);
                        f.set(konkretnyAntybiotykObject, y);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }});
    }


    static void setNestedClassFromName(AbstractField betaLaktamy, Binder<Data> binder,String dataField, String fieldName) {

        binder.forField(betaLaktamy)
                .bind(x-> {
                    try {
                        Field f = x.getClass().getField(dataField);
                        Object thisClass = f.get(x);
                        Field f1 = thisClass.getClass().getField(fieldName);
                        return f1.get(thisClass);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return null;
                }, (x, y)->{
                    try {
                        Field f = x.getClass().getField(dataField);
                        Object thisClass = f.get(x);
                        Field f1 = thisClass.getClass().getField(fieldName);
                        f1.set(thisClass, y);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }});
    }

    static void badanie(String name, Layout layout, Binder<Data> binder) {
        TextField field = new TextField();
        addToLayout(layout, field,name.toUpperCase(), "0.0");

    }

}
