package com.sample;

import com.sample.data.Data;
import com.sample.data.Patient;
import com.vaadin.data.Binder;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import static com.sample.DataDay.addToLayout;
import static com.sample.Punkt2.twoCheckBoxes;
import static com.sample.Punkt3.badanie;

public class Punkt8 {

    public static void punkt8(VerticalLayout layout, Binder<Data> binder) {
        CheckBox opioidy = twoCheckBoxes(layout, "8. Opioidy I sedacja");
        binder.forField(opioidy).bind(Data::isOpioidy, Data::setOpioidy);
        VerticalLayout hl = new VerticalLayout();
        badanie( "Morfina", hl, binder);
        badanie( "Oksykodon", hl, binder);
        badanie( "Propofol", hl, binder);
        badanie( "Midazolam", hl, binder);
        badanie( "Fentanyl", hl, binder);
        badanie( "Dexdor", hl, binder);
        badanie( "Ketamina", hl, binder);
        badanie( "Estazolam", hl, binder);
        badanie( "Tiopental", hl, binder);
        TextField text = new TextField();
        addToLayout(hl, text, "Inne - wpisz w formacie \"NAZWA LEKU:ILOŚĆ, NAZWA LEKU 2: ILOŚĆ2\"", "0");
        binder.forField(text).bind(Data::getOpioidyInne, Data::setOpioidyInne);
        hl.setVisible(false);
        layout.addComponent(hl);
        opioidy.addValueChangeListener(
                event ->{
                    if(opioidy.getValue()) {
                        hl.setVisible(true);
                    }
                    else {
                        hl.setVisible(false);
                    }
                }
        );
    }

}
