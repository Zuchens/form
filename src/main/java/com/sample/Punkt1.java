package com.sample;

import com.sample.data.Data;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import static com.sample.DataDay.*;

public class Punkt1 {

    // punkt1
    static TextField punkt1(VerticalLayout layout, Binder<Data> binder) {
        add_label(layout, "1. Dane podstawowe");
        TextField id = patientId(layout, binder);
        return id;
    }

    public static TextField dayView(VerticalLayout layout, Binder<Data> binder) {
        TextField day = day(layout, binder);
        HorizontalLayout czas = czas_trwania_doby(layout, day, binder);
        day.addValueChangeListener(event ->{
            if(Integer.valueOf(day.getValue()) == 1) {
                czas.setVisible(true);
            }else{
                czas.setVisible(false);
            }
        });
        return day;
    }

    private static HorizontalLayout czas_trwania_doby(VerticalLayout layout, TextField day, Binder<Data> binder) {
        TextField id = new TextField();
        HorizontalLayout lay = addToLayout(layout, id, "Czas trwania doby 1[h]", "0",false);
        binder.forField(id)
                .withConverter(
                        new StringToIntegerConverter("Czas trwania doby jest liczbą od 0 do 24"))
                .withValidationStatusHandler( status -> commonStatusChangeHandler(status,id))
                .bind(Data::getCzasDoby, Data::setCzasDoby);
        return lay;
    }
    private static TextField patientId(VerticalLayout layout, Binder<Data> binder) {
        TextField id = new TextField();
        addToLayout(layout, id, "", "0");
        binder.forField(id).asRequired("")
                .withConverter(
                        new StringToIntegerConverter("Id pacjenta musi byc liczba"))
                .bind(Data::getId, Data::setId);
        return id;
    }
    private static TextField day(VerticalLayout layout, Binder<Data> binder) {
        TextField id = new TextField();
        addToLayout(layout, id, "Dzień", "0");
        binder.forField(id).asRequired("Dzień nie może być pusty")
                .withConverter(
                        new StringToIntegerConverter("Dzień musi byc liczba"))
                .withValidationStatusHandler(
                        status -> commonStatusChangeHandler(status,
                                id))
                .bind(Data::getDay, Data::setDay);
        return id;
    }
}
