package com.sample;

import com.sample.data.Data;
import com.vaadin.data.Binder;
import com.vaadin.ui.VerticalLayout;

import java.util.HashMap;

import static com.sample.DataDay.add_label;
import static com.sample.Punkt4.doubleCheckboxFromString;

public class Punkt7 {


    public static void punkt7(VerticalLayout layout, Binder<Data> binder) {
        HashMap<String, String> field2name = new HashMap<>();
        field2name.put("lekiZwiotczajace", "leki zwiotczające");
        add_label(layout, "7. Leki");
        doubleCheckboxFromString(layout, binder, "pantoprazol", field2name);
        doubleCheckboxFromString(layout, binder, "metoklopramid", field2name);
        doubleCheckboxFromString(layout, binder, "laktuloza", field2name);
        doubleCheckboxFromString(layout, binder, "enema", field2name);
        doubleCheckboxFromString(layout, binder, "bisakodyl", field2name);
        doubleCheckboxFromString(layout, binder, "lekiZwiotczajace", field2name);
    }
}
