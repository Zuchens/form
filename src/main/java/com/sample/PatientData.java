package com.sample;

import com.sample.data.Patient;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToFloatConverter;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.ui.*;

import static com.sample.DataDay.addToLayout;
import static com.sample.DataDay.commonStatusChangeHandler;

public class PatientData {

    public static void addPatientData(VerticalLayout layout, Binder<Patient> binder) {

        dataPrzyjecia(layout, binder);
        dataPrzyjeciaDoOiT(layout, binder);
        dataIntubacji(layout, binder);
        plec(layout, binder);
        wiek(layout, binder);
        wzrost(layout, binder);
        waga(layout, binder);
        puntakcjaApache(layout, binder);
        kodRozpoznania(layout, binder);
        pochodzeniePacjenta(layout, binder);
        obciazenia(layout, binder);


    }

    private static HorizontalLayout obciazenia(VerticalLayout layout, Binder<Patient> binder) {
        TextField id = new TextField();
        HorizontalLayout lay = addToLayout(layout, id, "Obciążenia przy przyjęciu", "0");
        binder.forField(id)
                .bind(Patient::getObciazeniaPrzyPrzyjeciu, Patient::setObciazeniaPrzyPrzyjeciu);
        return lay;
    }


    private static HorizontalLayout plec(VerticalLayout layout, Binder<Patient> binder) {
        Label labelMessage = new Label("Płeć");
        layout.addComponent(labelMessage);
        CheckBox kobieta = new CheckBox("Kobieta");
        binder.forField(kobieta).bind(Patient::isPlecKobieta, Patient::setPlecKobieta);
        CheckBox mezczyzna = new CheckBox("Mężczyzna");
        binder.forField(mezczyzna).bind(Patient::isPlecMeska, Patient::setPlecMeska);
        Punkt12.exclude(kobieta, mezczyzna);
        Punkt12.exclude(mezczyzna, kobieta);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.addComponent(kobieta);
        horizontalLayout.addComponent(mezczyzna);
        layout.addComponent(horizontalLayout);
        return horizontalLayout;
    }
    private static HorizontalLayout pochodzeniePacjenta(VerticalLayout layout, Binder<Patient> binder) {
        Label labelMessage = new Label("Pacjent przyjęty z:");
        layout.addComponent(labelMessage);
        CheckBox przyjetySor = new CheckBox("SOR");
        binder.forField(przyjetySor).bind(Patient::isPrzyjetySor, Patient::setPrzyjetySor);
        CheckBox blokOperacyjny = new CheckBox("Inny oddział");
        binder.forField(blokOperacyjny).bind(Patient::isBlokOperacyjny, Patient::setBlokOperacyjny);
        CheckBox innyOddzial = new CheckBox("Blok operacyjny");
        binder.forField(innyOddzial).bind(Patient::isInnyOddzial, Patient::setInnyOddzial);
        CheckBox innySzpital = new CheckBox("Inny szpital");
        binder.forField(innySzpital).bind(Patient::isInnySzpital, Patient::setInnySzpital);
        CheckBox dps = new CheckBox("DPS");
        binder.forField(dps).bind(Patient::isDps, Patient::setDps);

        exclude(przyjetySor, blokOperacyjny, innyOddzial, innySzpital, dps);
        exclude(blokOperacyjny, innyOddzial, innySzpital, dps, przyjetySor);
        exclude(innyOddzial, innySzpital, dps, przyjetySor, blokOperacyjny);
        exclude(innySzpital, dps, przyjetySor, blokOperacyjny, innyOddzial);
        exclude(dps, przyjetySor, blokOperacyjny, innyOddzial, innySzpital);



        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.addComponent(przyjetySor);
        horizontalLayout.addComponent(blokOperacyjny);
        horizontalLayout.addComponent(innyOddzial);
        horizontalLayout.addComponent(innySzpital);
        horizontalLayout.addComponent(dps);
        layout.addComponent(horizontalLayout);


        DateField czasInnySzpital = new DateField();
        HorizontalLayout lay = addToLayout(layout, czasInnySzpital, "Od kiedy?", "0");
        binder.forField(czasInnySzpital)
                .bind(Patient::getInnySzpitalOdKiedy, Patient::setInnySzpitalOdKiedy);
        lay.setVisible(false);
        innySzpital.addValueChangeListener(event->{
            if(innySzpital.getValue()) {
                lay.setVisible(true);
            }else{
                lay.setVisible(false);
            }
        });


        return horizontalLayout;
    }

    private static void exclude(CheckBox ch1, CheckBox ch2, CheckBox ch3, CheckBox ch4, CheckBox ch5) {
        ch1.addValueChangeListener(event ->{
            if(ch1.getValue()){
                ch2.setValue(false);
                ch3.setValue(false);
                ch4.setValue(false);
                ch5.setValue(false);
            }
        });
    }
    private static HorizontalLayout dataPrzyjecia(VerticalLayout layout, Binder<Patient> binder) {
        DateField id = new DateField();
        HorizontalLayout lay = addToLayout(layout, id, "Data przyjęcia", "0");
        binder.forField(id)
                .bind(Patient::getDataPrzyjecia, Patient::setDataPrzyjecia);
        return lay;
    }
    private static HorizontalLayout dataIntubacji(VerticalLayout layout, Binder<Patient> binder) {
        CheckBox przyjetyOiT = new CheckBox("Czy intubacja");
        layout.addComponent(przyjetyOiT);
        DateField id = new DateField();
        HorizontalLayout lay = addToLayout(layout, id, "Data intubacji", "0");
        binder.forField(id)
                .bind(Patient::getDataIntubacji, Patient::setDataIntubacji);
        lay.setVisible(false);
        przyjetyOiT.addValueChangeListener(event->{
            if(przyjetyOiT.getValue()) {
                lay.setVisible(true);
            }else{
                lay.setVisible(false);
            }
        });
        return lay;
    }

    private static HorizontalLayout dataPrzyjeciaDoOiT(VerticalLayout layout, Binder<Patient> binder) {
        DateField id = new DateField();
        HorizontalLayout lay = addToLayout(layout, id, "Data przyjęcia do OiT", "0");
        binder.forField(id)
                .bind(Patient::getDataPrzyjeciaDoOiT, Patient::setDataPrzyjeciaDoOiT);
        return lay;

    }
    private static HorizontalLayout wiek(VerticalLayout layout, Binder<Patient> binder) {
        TextField id = new TextField();
        HorizontalLayout lay = addToLayout(layout, id, "Wiek [lata]", "0");
        binder.forField(id)
                .withConverter(
                        new StringToIntegerConverter("Musi być tu liczba"))
                .withValidationStatusHandler( status -> commonStatusChangeHandler(status,id))
                .bind(Patient::getWiek, Patient::setWiek);
        return lay;
    }

    private static HorizontalLayout wzrost(VerticalLayout layout, Binder<Patient> binder) {
        TextField id = new TextField();
        HorizontalLayout lay = addToLayout(layout, id, "Wzrost [cm]", "0");
        binder.forField(id)
                .withConverter(
                        new StringToIntegerConverter("Musi być tu liczba"))
                .withValidationStatusHandler( status -> commonStatusChangeHandler(status,id))
                .bind(Patient::getWzrost, Patient::setWzrost);
        return lay;
    }

    private static HorizontalLayout waga(VerticalLayout layout, Binder<Patient> binder) {
        TextField id = new TextField();
        HorizontalLayout lay = addToLayout(layout, id, "Waga [kg]", "0");
        binder.forField(id)
                .withConverter(
                        new StringToFloatConverter("Musi być tu liczba"))
                .withValidationStatusHandler( status -> commonStatusChangeHandler(status,id))
                .bind(Patient::getWaga, Patient::setWaga);
        return lay;
    }

    private static HorizontalLayout puntakcjaApache(VerticalLayout layout, Binder<Patient> binder) {
        TextField id = new TextField();
        HorizontalLayout lay = addToLayout(layout, id, "Puntakcja Apache II", "0");
        binder.forField(id)
                .withConverter(
                        new StringToIntegerConverter("Musi być tu liczba"))
                .withValidationStatusHandler( status -> commonStatusChangeHandler(status,id))
                .bind(Patient::getPunktacjaApache, Patient::setPunktacjaApache);
        return lay;
    }


    private static HorizontalLayout kodRozpoznania(VerticalLayout layout, Binder<Patient> binder) {
        TextField id = new TextField();
        HorizontalLayout lay = addToLayout(layout, id, "Kod Rozpoznania", "0");
        binder.forField(id)
                .withConverter(
                        new StringToIntegerConverter("Musi być tu liczba"))
                .withValidationStatusHandler( status -> commonStatusChangeHandler(status,id))
                .bind(Patient::getWiek, Patient::setWiek);
        return lay;
    }

}
