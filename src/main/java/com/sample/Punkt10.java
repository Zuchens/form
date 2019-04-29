package com.sample;

import com.sample.data.Data;
import com.sample.data.Patient;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToFloatConverter;
import com.vaadin.ui.*;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.sample.DataDay.*;
import static com.sample.Punkt2.exclude;
import static com.sample.Punkt2.twoCheckBoxes;
import static com.sample.Punkt9.setNestedClassFromName;

public class Punkt10 {

    public static void punkt10(Layout layout, Binder<Data> binder) {
        add_label(layout, "10. Żywienie");
        zywienieEN(layout, binder);
        zywienieTPN(layout, binder);
        zywienieDoustna(layout, binder);
        zywienieNPO(layout, binder);
        zywienieDodatkowaWoda(layout, binder);

        Label labelMessage = new Label("Miejsce Zgłębnika");
        layout.addComponent(labelMessage);
        CheckBox nos = new CheckBox("Nos");
        binder.forField(nos).bind(Data::isZglebnikNos, Data::setZglebnikNos);
        CheckBox usta = new CheckBox("Usta");
        binder.forField(usta).bind(Data::isZglebnikUsta, Data::setZglebnikUsta);
        CheckBox PEG = new CheckBox("PEG");
        binder.forField(PEG).bind(Data::isZglebnikPEG, Data::setZglebnikPEG);
        CheckBox brak = new CheckBox("Brak");
        binder.forField(brak).bind(Data::isZglebnikBrak, Data::setZglebnikBrak);

        exclude(nos, usta, PEG, brak);
        exclude(usta, PEG, brak, nos);
        exclude(PEG, brak, nos, usta);
        exclude(brak, nos, usta, PEG);



        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.addComponent(nos);
        horizontalLayout.addComponent(usta);
        horizontalLayout.addComponent(PEG);
        horizontalLayout.addComponent(brak);
        layout.addComponent(horizontalLayout);

    }

    private static void zywienieDodatkowaWoda(Layout layout, Binder<Data> binder) {
        CheckBox zywienie = twoCheckBoxes(layout, "dodatkowa woda");
        binder.forField(zywienie).bind(Data::isZywienieDodatkowaWoda, Data::setZywienieDodatkowaWoda);
        VerticalLayout h1 = new VerticalLayout();
        h1.setVisible(false);

        LinkedHashMap<String, String> map1 = new LinkedHashMap();
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
        CheckBox zywienie = twoCheckBoxes(layout, "Zywienie Doustne");
        binder.forField(zywienie).bind(Data::isZywienieDoustna, Data::setZywienieDoustna);
        VerticalLayout h1 = new VerticalLayout();
        h1.setVisible(false);

        LinkedHashMap<String, String> map1 = new LinkedHashMap();
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
        CheckBox zywienie = twoCheckBoxes(layout, "Zywienie TPN");
        binder.forField(zywienie).bind(Data::isZywienieTPN, Data::setZywienieTPN);
        VerticalLayout h1 = new VerticalLayout();
        h1.setVisible(false);

        LinkedHashMap<String, String> map1 = new LinkedHashMap();
        map1.put("iloscZywienia", "ilość żywienia wml na 24 h");
        map1.put("Przeplyw", "przepływ ml/h");
        addZywienieENFloat(binder, h1, "ZywienieTPN", map1);

        LinkedHashMap<String, String> map2 = new LinkedHashMap();
        map2.put( "Standard01", "Standard 01");
        map2.put("Standard02", "Standard 02");
        map2.put("Standard03", "Standard 03");
        map2.put("Standard04", "Standard 04");

        map2.put( "Hepa01", "Hepa 01");
        map2.put("Hepa02", "Hepa 02");
        map2.put("Hepa03", "Hepa 03");
        map2.put("Hepa04", "Hepa 04");


        map2.put( "Nephro01", "Nephro 01");
        map2.put("Nephro02", "Nephro 02");
        map2.put("Nephro03", "Nephro 03");
        map2.put("Nephro04", "Nephro 04");

        map2.put("StartStandard", "Start Standard");
        map2.put("StartNephro", "Start Nephro");
        map2.put("StartHepa", "Start Hepa");
        addPreparaty(binder, h1, "ZywienieTPN", map2);
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
        CheckBox zywienie = twoCheckBoxes(layout, "Zywienie EN");
        binder.forField(zywienie).bind(Data::isZywienieEN, Data::setZywienieEN);
        VerticalLayout h1 = new VerticalLayout();
        h1.setVisible(false);

        LinkedHashMap<String, String> map1 = new LinkedHashMap();
        map1.put("dojelitowego", "cel żywienia dojelitowego w ml");
        map1.put("procentCelu", "% osiągniętego celu");
        map1.put("iloscWMl", "ilość żywienia w ml na 24 h");
        map1.put("PrzeplywWMl", "przepływ ml/h");

        addZywienieENFloat(binder, h1, "ZywienieEN", map1);
        addZaburzeniaKarmienia(binder, h1);
        LinkedHashMap<String, String> map2 = new LinkedHashMap();
        map2.put("Peptamen", "Peptamen");
        map2.put("Diason", "Diason");
        map2.put("FresubinHPFibre", "Fresubin HP Fibre");
        map2.put("NutrisonProtein", "Nutrison Protein");
        map2.put("glukoza5", "glukoza 5%");
        map2.put("Peptisorb", "Peptisorb");
        map2.put("Impact", "Impact");
        map2.put("FresubinHPEnergy", "Fresubin HP Energy");



        addPreparaty(binder, h1, "ZywienieEN", map2);
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

    private static void addPreparaty(Binder<Data> binder, Layout h1, String fieldName, LinkedHashMap<String, String> map ) {
        add_label(h1, "Preparat");
        for(Map.Entry<String, String> name : map.entrySet()) {
            CheckBox check = twoCheckBoxes(h1, name.getValue());
            setNestedClassFromName(check, binder,  fieldName, name.getKey());
        }
        TextField text = new TextField();
        addToLayout(h1, text, "Inne", "0");
        setNestedClassFromName(text, binder,  fieldName, "Inne");
    }

    private static void addZywienieENFloat(Binder<Data> binder, Layout h1,  String fieldName, LinkedHashMap<String, String> map ) {
        for(Map.Entry<String, String> name : map.entrySet()) {
            setNestedClassFromNameFloat(h1, name.getValue(), binder, fieldName, name.getKey());
        }
    }

    private static void addZaburzeniaKarmienia(Binder<Data> binder, Layout h1) {
        CheckBox karmienia = twoCheckBoxes(h1, "Przerwanie/zaburzenie karmienia");
        VerticalLayout h2 = new VerticalLayout();
        h2.setVisible(false);
        LinkedHashMap<String, String> map2 = new LinkedHashMap();
        map2.put("wymioty", "wymioty");
        map2.put("zalegania", "zalegania");
        map2.put("naCzczo", "na czczo");
        map2.put("krwawienie", "krwawienie z przewodu pokarmowego");
        map2.put("inneZaburzenia", "inne Zaburzenia");
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
