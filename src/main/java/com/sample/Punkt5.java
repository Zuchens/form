package com.sample;

import com.sample.data.Data;
import com.vaadin.data.Binder;
import com.vaadin.ui.VerticalLayout;

import java.util.LinkedHashMap;

import static com.sample.DataDay.add_label;
import static com.sample.Punkt4.doubleCheckboxFromString;

public class Punkt5 {

    public static void punkt5(VerticalLayout layout, Binder<Data> binder) {

        LinkedHashMap<String, String> field2name = new LinkedHashMap<>();
        field2name.put("nowyAntybiotyk", "Nowy antybiotyk");
        field2name.put("zmianaAntybiotyk", "Zmiana antybiotyku");

        add_label(layout, "5. Antybiotyki");
        doubleCheckboxFromString(layout, binder, "nowyAntybiotyk", field2name);
        doubleCheckboxFromString(layout, binder, "zmianaAntybiotyk", field2name);
    }

}
