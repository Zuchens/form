package com.sample;


import com.sample.data.Data;
import com.vaadin.data.Binder;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

import java.lang.reflect.Field;
import java.util.HashMap;

import static com.sample.DataDay.add_label;
import static com.sample.Punkt2.twoCheckBoxes;

public class Punkt4 {

    public static void punkt4(VerticalLayout layout, Binder<Data> binder) {
        HashMap<String, String> field2name = new HashMap<>();
        field2name.put("rehabilitacja", "Rehabilitacja");

        add_label(layout, "4. Rehabilitacja");

        doubleCheckboxFromString(layout, binder, "rehabilitacja", field2name);
    }

    public static CheckBox doubleCheckboxFromString(Layout layout, Binder<Data> binder, String name, HashMap<String, String> field2name) {
        CheckBox rehabilitacja = twoCheckBoxes(layout, field2name.getOrDefault(name, name));
        binder.forField(rehabilitacja).bind(
                x-> {
                    try {
                        Field f = x.getClass().getField(name);
                        return (Boolean) f.get(x);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return null;
                }, (x, y)->{
                    try {
                        Field f = x.getClass().getField(name);
                        f.set(x, y);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }}
        );
        return rehabilitacja;
    }
}