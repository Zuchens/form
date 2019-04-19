package com.sample;

import com.sample.data.Data;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Layout;

import com.vaadin.data.Binder;
import com.vaadin.ui.VerticalLayout;

import java.util.HashMap;
import java.util.Map;

import static com.sample.DataDay.add_label;
import static com.sample.Punkt10.setNestedClassFromNameFloat;
import static com.sample.Punkt2.twoCheckBoxes;
import static com.sample.Punkt9.setNestedClassFromName;

public class Punkt11 {
    public static void punkt11(Layout layout, Binder<Data> binder) {
        HashMap<String, String> field2name = new HashMap<>();
        field2name.put("wyproznienie", "Wypróżnienie");
        field2name.put("bristolskaWiekszaNiz6", "Czy któryś w stolców w skali bristolskiej był większy ≥ 6");
        field2name.put("krew", "Czy w którymś była krew?");
        field2name.put("Flexiseal", "Czy był założony Flexiseal");

        add_label(layout, "11. Stolec");
        CheckBox wyproznienie = nested(layout, binder, "wyproznienie", field2name, "Stolec");
        VerticalLayout h1 = new VerticalLayout();
        h1.setVisible(false);

        setNestedClassFromNameFloat(h1, "ilość", binder, "Stolec", "iloscWyproznienia");

        layout.addComponent(h1);
        wyproznienie.addValueChangeListener(
                event ->{
                    if(wyproznienie.getValue()) {
                        h1.setVisible(true);
                    }
                    else {
                        h1.setVisible(false);
                    }
                }
        );

        nested(layout, binder, "bristolskaWiekszaNiz6", field2name, "Stolec");
        nested(layout, binder, "krew", field2name, "Stolec");
        nested(layout, binder, "Flexiseal", field2name, "Stolec");
    }
    static CheckBox nested(Layout layout, Binder<Data> binder, String field, Map<String, String> field2name, String classField) {
        String showText = field2name.get(field);
        CheckBox betaLaktamy = twoCheckBoxes(layout, showText);
        betaLaktamy.setValue(false);
        setNestedClassFromName(betaLaktamy, binder,classField, field);
        return betaLaktamy;
    }
}
