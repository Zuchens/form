package com.sample;

import com.sample.data.Data;
import com.vaadin.data.Binder;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.sample.DataDay.add_label;
import static com.sample.Punkt2.twoCheckBoxes;
import static com.sample.Punkt9.setNestedClassFromName;

public class Punkt12 {
    public static void punkt12(Layout layout, Binder<Data> binder) {
        add_label(layout, "11. Końcowe");
        CheckBox ostatniDzień = twoCheckBoxes(layout, "Ostatni dzień");
        binder.forField(ostatniDzień).bind(Data::isOstatniDzien, Data::setOstatniDzien);
        VerticalLayout h1 = new VerticalLayout();
        h1.setVisible(false);
        CheckBox check = twoCheckBoxes(h1, "Zgon");
        setNestedClassFromName(check, binder,  "OstatniDzien", "zgon");

        CheckBox check2 = twoCheckBoxes(h1, "Wypis");
        setNestedClassFromName(check, binder,  "OstatniDzien", "wypis");

        layout.addComponent(h1);
        VerticalLayout h2 = new VerticalLayout();
        h2.setVisible(false);
        LinkedHashMap<String, String> map2 = new LinkedHashMap();
        map2.put("innyOddzial", "inny oddział");
        map2.put("DPS", "DPS");
        map2.put("dom", "dom");
        map2.put("inne", "inne");

        for(Map.Entry<String, String> name : map2.entrySet()) {
            CheckBox check3 = twoCheckBoxes(h2, name.getValue());
            setNestedClassFromName(check3, binder,  "OstatniDzien", name.getKey());
        }

        layout.addComponent(h2);
        check2.addValueChangeListener(
                event ->{
                    if(check2.getValue()) {
                        h2.setVisible(true);
                    }
                    else {
                        h2.setVisible(false);
                    }
                }
        );
        exclude(check, check2);
        exclude(check2, check);

        ostatniDzień.addValueChangeListener(
                event ->{
                    if(ostatniDzień.getValue()) {
                        h1.setVisible(true);
                    }
                    else {
                        h1.setVisible(false);
                    }
                }
        );
    }

    public static void exclude(CheckBox check, CheckBox check2) {
        check.addValueChangeListener(
                event ->{
                    if(check.getValue()) {
                        check2.setValue(false);
                    }
                    else {
                        check2.setValue(true);
                    }
                }
        );
    }
}
