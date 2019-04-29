package com.sample;

import com.sample.data.Data;
import com.vaadin.data.Binder;
import com.vaadin.ui.VerticalLayout;

import java.util.LinkedHashMap;

import static com.sample.DataDay.add_label;
import static com.sample.Punkt4.doubleCheckboxFromString;

public class Punkt6 {

    public static void punkt6(VerticalLayout layout, Binder<Data> binder) {
        LinkedHashMap<String, String> field2name = new LinkedHashMap<>();
        field2name.put("infekcjaOddechowa", "oddechowej");
        field2name.put("infekcjaKrwiopochodna", "krwiopochodnej");
        field2name.put("infekcjaJamyBrzusznej", "jamy brzusznej");
        field2name.put("infekcjaUkladuMoczowego", "układu moczowego");
        // TODO jakie
        field2name.put("infekcjaInne", "innej");

        add_label(layout, "6. Podejrzenie infekcji");
        doubleCheckboxFromString(layout, binder, "infekcjaOddechowa", field2name);
        doubleCheckboxFromString(layout, binder, "infekcjaKrwiopochodna", field2name);
        doubleCheckboxFromString(layout, binder, "infekcjaJamyBrzusznej", field2name);
        doubleCheckboxFromString(layout, binder, "infekcjaUkladuMoczowego", field2name);
        doubleCheckboxFromString(layout, binder, "infekcjaInne", field2name);
    }
}
