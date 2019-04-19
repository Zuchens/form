package com.sample;

import com.sample.data.Data;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToFloatConverter;
import com.vaadin.ui.*;

import java.lang.reflect.Field;

import static com.sample.DataDay.*;

public class Punkt3 {

    public static void punkt3(VerticalLayout layout, Binder<Data> binder) {

        add_label(layout, "3. Badania laboratoryjne");
        String[] names = {"wbc", "rbc", "hb", "plt", "hco3", "na", "k", "cl", "crea", "albuminy", "ca", "mg", "ri", "crp", "pct"};
        for(String name : names) {
            badanie(name, layout, binder);
        }

    }

    static void badanie(String name, Layout layout, Binder<Data> binder) {
        TextField field = new TextField();
        addToLayout(layout, field,name.toUpperCase(), "0.0");
        binder.forField(field)
                .withConverter(
                        new StringToFloatConverter(String.format("%s musi być liczbą", name)))
                .withValidationStatusHandler(
                        status -> commonStatusChangeHandler(status,
                                field))
                .bind(x-> {
                    try {
                        Field f = x.getClass().getField(name);
                        return (Float) f.get(x);
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
                    }});
    }
}
