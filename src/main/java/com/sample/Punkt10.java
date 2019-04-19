package com.sample;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.sample.data.Data;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToFloatConverter;
import com.vaadin.ui.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.sample.DataDay.*;
import static com.sample.Punkt2.twoCheckBoxes;
import static com.sample.Punkt4.doubleCheckboxFromString;
import static com.sample.Punkt9.setNestedClassFromName;

public class Punkt10 {

    public static void punkt10(Layout layout, Binder<Data> binder) {
        add_label(layout, "10. Żywienie");
        zywienieEN(layout, binder);
        zywienieTPN(layout, binder);
        zywienieDoustna(layout, binder);
        zywienieNPO(layout, binder);
        zywienieDodatkowaWoda(layout, binder);

    }

    private static void zywienieDodatkowaWoda(Layout layout, Binder<Data> binder) {
        CheckBox zywienie = twoCheckBoxes(layout, "isZywienieDodatkowaWoda");
        binder.forField(zywienie).bind(Data::isZywienieDodatkowaWoda, Data::setZywienieDodatkowaWoda);
        VerticalLayout h1 = new VerticalLayout();
        h1.setVisible(false);

        HashMap<String, String> map1 = new HashMap();
        map1.put("ileMl", "ilość w ml");
        addZywienieENFloat(binder, h1, "ZywienieDodatkowaWoda", map1);

        layout.addComponent(h1);
        zywienie.addValueChangeListener(
                event ->{
                    if(zywienie.getValue()) {
                        h1.setVisible(true);
                    }
                    else {
                        h1.setVisible(false);
                    }
                }
        );
    }

    private static void zywienieNPO(Layout layout, Binder<Data> binder) {
        CheckBox zywienie = twoCheckBoxes(layout, "NPO");
        binder.forField(zywienie).bind(Data::isZywienieNPO, Data::setZywienieNPO);

        CheckBox jesc = twoCheckBoxes(layout, "Czy może jeść");
        binder.forField(jesc).bind(Data::isJesc, Data::setJesc);

        CheckBox pic = twoCheckBoxes(layout, "Czy może pić");
        binder.forField(pic).bind(Data::isPic, Data::setPic);
    }

    private static void zywienieDoustna(Layout layout, Binder<Data> binder) {
        CheckBox zywienie = twoCheckBoxes(layout, "ZywienieDoustna");
        binder.forField(zywienie).bind(Data::isZywienieDoustna, Data::setZywienieDoustna);
        VerticalLayout h1 = new VerticalLayout();
        h1.setVisible(false);

        HashMap<String, String> map1 = new HashMap();
        map1.put("iloscZywienia", "ilość w ml");
        addZywienieENFloat(binder, h1, "ZywienieDoustna", map1);

        layout.addComponent(h1);
        zywienie.addValueChangeListener(
                event ->{
                    if(zywienie.getValue()) {
                        h1.setVisible(true);
                    }
                    else {
                        h1.setVisible(false);
                    }
                }
        );
    }

    private static void zywienieTPN(Layout layout, Binder<Data> binder) {
        CheckBox zywienie = twoCheckBoxes(layout, "ZywienieTPN");
        binder.forField(zywienie).bind(Data::isZywienieTPN, Data::setZywienieTPN);
        VerticalLayout h1 = new VerticalLayout();
        h1.setVisible(false);

        HashMap<String, String> map1 = new HashMap();
        map1.put("iloscZywienia", "ilość żywienia wml na 24 h");
        map1.put("Przeplyw", "przepływ ml/h");
        addZywienieENFloat(binder, h1, "ZywienieTPN", map1);

        HashMap<String, String> map2 = new HashMap();
        map2.put( "Standard01", "Standard 01");
        map2.put("Standard02", "Standard 02");
        addZywienieENBoolean(binder, h1, "ZywienieTPN", map2);
        layout.addComponent(h1);
        zywienie.addValueChangeListener(
                event ->{
                    if(zywienie.getValue()) {
                        h1.setVisible(true);
                    }
                    else {
                        h1.setVisible(false);
                    }
                }
        );
    }

    private static void zywienieEN(Layout layout, Binder<Data> binder) {
        CheckBox zywienie = twoCheckBoxes(layout, "EN");
        binder.forField(zywienie).bind(Data::isZywienieEN, Data::setZywienieEN);
        VerticalLayout h1 = new VerticalLayout();
        h1.setVisible(false);

        HashMap<String, String> map1 = new HashMap();
        map1.put("dojelitowego", "cel żywienia dojelitowego w ml");
        map1.put("procentCelu", "% osiągniętego celu");
        map1.put("iloscWMl", "ilość żywienia w ml na 24 h");
        map1.put("PrzeplywWMl", "przepływ ml/h");

        addZywienieENFloat(binder, h1, "ZywienieEN", map1);
        addZaburzeniaKarmienia(binder, h1);
        HashMap<String, String> map2 = new HashMap();
        map2.put("Peptamen", "Peptamen");
        map2.put("Diason", "Diason");
        addZywienieENBoolean(binder, h1, "ZywienieEN", map2);
        layout.addComponent(h1);
        zywienie.addValueChangeListener(
                event ->{
                    if(zywienie.getValue()) {
                        h1.setVisible(true);
                    }
                    else {
                        h1.setVisible(false);
                    }
                }
        );
    }

    private static void addZywienieENBoolean(Binder<Data> binder, Layout h1, String fieldName, HashMap<String, String> map ) {
        add_label(h1, "Preparat");
        for(Map.Entry<String, String> name : map.entrySet()) {
            CheckBox check = twoCheckBoxes(h1, name.getValue());
            setNestedClassFromName(check, binder,  fieldName, name.getKey());
        }
    }

    private static void addZywienieENFloat(Binder<Data> binder, Layout h1,  String fieldName, HashMap<String, String> map ) {
        for(Map.Entry<String, String> name : map.entrySet()) {
            setNestedClassFromNameFloat(h1, name.getValue(), binder, fieldName, name.getKey());
        }
    }

    private static void addZaburzeniaKarmienia(Binder<Data> binder, Layout h1) {
        CheckBox karmienia = twoCheckBoxes(h1, "Przerwanie/zaburzenie karmienia");
        VerticalLayout h2 = new VerticalLayout();
        h2.setVisible(false);
        HashMap<String, String> map2 = new HashMap();
        map2.put("wymioty", "wymioty");
        map2.put("zalegania", "zalegania");
        map2.put("naCzczo", "na czczo");
        map2.put("krwawienie", "krwawienie z przewodu pokarmowego");
        for(Map.Entry<String, String> name : map2.entrySet()) {
            CheckBox badanie = twoCheckBoxes(h2, name.getValue());

            setNestedClassFromName(badanie, binder,"ZywienieEN", name.getKey());
        }

        karmienia.addValueChangeListener(
                event ->{
                    if(karmienia.getValue()) {
                        h2.setVisible(true);
                    }
                    else {
                        h2.setVisible(false);
                    }
                }
        );
        h1.addComponent(h2);
    }

    public static void setNestedClassFromNameFloat(Layout layout, String showText, Binder<Data> binder, String dataField, String fieldName) {
        TextField field = new TextField();
        addToLayout(layout, field,showText, "0.0");
        binder.forField(field)
                .withConverter(
                        new StringToFloatConverter(String.format("%s musi być liczbą", fieldName)))
                .bind(x-> {
                    try {
                        Field f = x.getClass().getField(dataField);
                        Object thisClass = f.get(x);
                        Field f1 = thisClass.getClass().getField(fieldName);
                        return (Float)f1.get(thisClass);
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

}
