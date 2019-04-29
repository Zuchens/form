package com.sample;

import com.sample.data.Data;
import com.vaadin.data.Binder;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

import static com.sample.DataDay.addToLayout2Checboxes;
import static com.sample.DataDay.add_label;

public class Punkt2 {

    //punkt2
    public static void punkt2(VerticalLayout layout, Binder<Data> binder) {

        add_label(layout, "2. Zaawansowane techniki leczenia");


        CheckBox inwazyjneMw = twoCheckBoxes(layout, "Inwazyjne MW");
        binder.forField(inwazyjneMw).bind(Data::isInwazyjneMw, Data::setInwazyjneMw);

        CheckBox nieInwazyjneMw = twoCheckBoxes(layout, "Nieinwazyjne MW");
        binder.forField(nieInwazyjneMw).bind(Data::isNieinwazyjneMw, Data::setNieinwazyjneMw);

        CheckBox wazopresory = twoCheckBoxes(layout, "Wazopresory");
        binder.forField(wazopresory).bind(Data::isWazopresory, Data::setWazopresory);

        HorizontalLayout multiFieldWazopresory = multiFieldWazopresory(layout,binder);
        wazopresory.addValueChangeListener(event ->{
            if(wazopresory.getValue()) {
                multiFieldWazopresory.setVisible(true);
            }else{
                multiFieldWazopresory.setVisible(false);
            }
        });

        CheckBox dializa = twoCheckBoxes(layout, "Dializa");
        binder.forField(dializa).bind(Data::isDializa, Data::setDializa);

        HorizontalLayout multiDializa = addExclusiveMultiDializa(layout, binder);
        dializa.addValueChangeListener(event ->{
            if(dializa.getValue()) {
                multiDializa.setVisible(true);
            }else{
                multiDializa.setVisible(false);
            }
        });

    }

    private static HorizontalLayout addExclusiveMultiDializa(VerticalLayout layout, Binder<Data> binder) {
        CheckBox ihd = new CheckBox("ihd");
        binder.forField(ihd).bind(Data::isIhd, Data::setIhd);
        CheckBox cvvhd = new CheckBox("cvvhd");
        binder.forField(cvvhd).bind(Data::isCvvhd, Data::setCvvhd);
        CheckBox cvvhf = new CheckBox("cvvhf");
        binder.forField(cvvhf).bind(Data::isCvvhf, Data::setCvvhf);
        CheckBox cvvhdf = new CheckBox("cvvhdf");
        binder.forField(cvvhdf).bind(Data::isCvvhdf, Data::setCvvhdf);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.addComponent(ihd);
        horizontalLayout.addComponent(cvvhd);
        horizontalLayout.addComponent(cvvhf);
        horizontalLayout.addComponent(cvvhdf);
        horizontalLayout.setVisible(false);
        layout.addComponent(horizontalLayout);


        exclude(ihd, cvvhd, cvvhf, cvvhdf);
        exclude(cvvhd, ihd, cvvhf, cvvhdf);
        exclude(cvvhf, ihd, cvvhd, cvvhdf);
        exclude(cvvhdf, ihd, cvvhd, cvvhf);
        return horizontalLayout;
    }

    public static void exclude(CheckBox ihd, CheckBox cvvhd, CheckBox cvvhf, CheckBox cvvhdf) {
        ihd.addValueChangeListener(event ->{
            if(ihd.getValue()){
                cvvhd.setValue(false);
                cvvhf.setValue(false);
                cvvhdf.setValue(false);
            }
        });
    }

    private static HorizontalLayout multiFieldWazopresory(VerticalLayout layout, Binder<Data> binder) {
        CheckBox noradrenalina = new CheckBox("Noradrenalina");
        binder.forField(noradrenalina).bind(Data::isNoradrenalina, Data::setNoradrenalina);
        CheckBox adrenalina = new CheckBox("Adrenalina");
        binder.forField(adrenalina).bind(Data::isAdrenalina, Data::setAdrenalina);
        CheckBox dobutamina = new CheckBox("Dobutamina");
        binder.forField(dobutamina).bind(Data::isDobutamina, Data::setDobutamina);
        CheckBox dopamina = new CheckBox("Dopamina");
        binder.forField(dopamina).bind(Data::isDopamina, Data::setDopamina);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.addComponent(noradrenalina);
        horizontalLayout.addComponent(adrenalina);
        horizontalLayout.addComponent(dobutamina);
        horizontalLayout.addComponent(dopamina);
        horizontalLayout.setVisible(false);
        layout.addComponent(horizontalLayout);
        return horizontalLayout;
    }

    public static CheckBox twoCheckBoxes(Layout layout, String name) {
        CheckBox yes = new CheckBox("TAK");
        CheckBox no = new CheckBox("NIE");
        yes.addValueChangeListener(event ->
                no.setValue(! yes.getValue()));
        no.addValueChangeListener(event ->
                yes.setValue(! no.getValue()));
        no.setValue(true);
        addToLayout2Checboxes(layout, yes, no,name, true);
        return yes;
    }

}
