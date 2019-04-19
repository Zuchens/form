package com.sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sample.data.Data;
import com.sample.data.Patient;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Binder;
import com.vaadin.data.BindingValidationStatus;
import com.vaadin.data.BindingValidationStatus.Status;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.themes.ValoTheme;

import static com.sample.Punkt1.dayView;
import static com.sample.Punkt1.punkt1;
import static com.sample.Punkt10.punkt10;
import static com.sample.Punkt11.punkt11;
import static com.sample.Punkt12.punkt12;
import static com.sample.Punkt2.punkt2;
import static com.sample.Punkt3.punkt3;
import static com.sample.Punkt4.punkt4;
import static com.sample.Punkt5.punkt5;
import static com.sample.Punkt6.punkt6;
import static com.sample.Punkt7.punkt7;
import static com.sample.Punkt8.punkt8;
import static com.sample.Punkt9.punkt9;

@Title("Registration Form")
@Theme("registration")
public class DataDay extends UI {

    private static final int WIDTH = 300;
    private static final int LABEL_WIDTH = 350;
    private final Binder<Data> binder = new Binder<>();
    private final Binder<Patient> binderPatient = new Binder<>();

    private boolean showConfirmPasswordStatus;

    private static final String VALID = "valid";
    public static HorizontalLayout addToLayout(Layout layout, AbstractField textField,
                                         String message, String placeholder) {
        return addToLayout(layout, textField,message,placeholder, true);
    }
    public static HorizontalLayout addToLayout(Layout layout, AbstractField textField,
                                         String message, String placeholder, boolean visible) {
        Label labelMessage = new Label(message);
        labelMessage.setWidth(WIDTH, Unit.PIXELS);
        textField.setData(labelMessage);
//        textField.setPlaceholder(placeholder);
        Label statusMessage = new Label();
        statusMessage.setVisible(false);
        statusMessage.addStyleName("validation-message");
        textField.setData(statusMessage);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.addComponent(labelMessage);
        horizontalLayout.addComponent(textField);
        horizontalLayout.setVisible(visible);
        textField.setWidth(WIDTH, Unit.PIXELS);
        horizontalLayout.addComponent(statusMessage);
        layout.addComponent(horizontalLayout);
        return horizontalLayout;
    }

    public static void add_label(Layout layout, String s) {
        Label labelMessage = new Label(s);
        labelMessage.setWidth(LABEL_WIDTH, Unit.PIXELS);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.addComponent(labelMessage);
        layout.addComponent(horizontalLayout);
    }


    public static HorizontalLayout addToLayout2Checboxes(Layout layout, AbstractField textField,AbstractField textField2,
                                         String message, boolean visible) {
        Label labelMessage = new Label(message);
        labelMessage.setWidth(WIDTH, Unit.PIXELS);
        textField.setData(labelMessage);
        Label statusMessage = new Label();
        statusMessage.setVisible(false);
        statusMessage.addStyleName("validation-message");
        textField.setData(statusMessage);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.addComponent(labelMessage);
        horizontalLayout.addComponent(textField);
        horizontalLayout.addComponent(textField2);
        horizontalLayout.setVisible(visible);
        textField.setWidth(WIDTH, Unit.PIXELS);
        horizontalLayout.addComponent(statusMessage);
        layout.addComponent(horizontalLayout);
        return horizontalLayout;
    }

    @Override
    protected void init(VaadinRequest request) {
        //TODO checkbox zeby wypelnic danymi z poprzedniego dnia
        //TODO jesli chceckboxy wylaczone - wyzeruj
        VerticalLayout layout = new VerticalLayout();
        layout.setWidth(100, Unit.PERCENTAGE);
        setContent(layout);
        TextField id = punkt1(layout, binder);

        VerticalLayout horizontalLayout = new VerticalLayout();
        Label labelMessage = new Label("Nowy Pacjent");
        labelMessage.setWidth(WIDTH, Unit.PIXELS);
        horizontalLayout.addComponent(labelMessage);
        PatientData.addPatientData(horizontalLayout, binderPatient);
        horizontalLayout.addComponent(createPatientButton());
        horizontalLayout.setVisible(false);
        layout.addComponent(horizontalLayout);


        Label pacjentWBazieMsg = hiddentMessage(layout, "Pacjent już w bazie");
        id.addValueChangeListener(
                event->{
                    System.out.println("person_"+id.getValue()+".json");
                    File f = new File("person_"+id.getValue()+".json");
                    if(!f.exists()) {
                        horizontalLayout.setVisible(true);
                        pacjentWBazieMsg.setVisible(false);
                    }else{
                        horizontalLayout.setVisible(false);
                        pacjentWBazieMsg.setVisible(true);
                    }
                }
        );
        dayView(layout, binder);
        punkt2(layout,binder);
        punkt3(layout,binder);
        punkt4(layout,binder);
        punkt5(layout,binder);
        punkt6(layout,binder);
        punkt7(layout,binder);
        punkt8(layout,binder);
        punkt9(layout,binder);
        punkt10(layout, binder);
        punkt11(layout, binder);
        punkt12(layout, binder);
        layout.addComponent(createButton());
        id.focus();
        binderPatient.setBean(new Patient());
        binder.setBean(new Data());
    }

    private Label hiddentMessage(Layout layout, String message) {
        Label labelMessage = new Label(message);
        labelMessage.setWidth(WIDTH, Unit.PIXELS);
        labelMessage.setVisible(false);
        layout.addComponent(labelMessage);
        return labelMessage;
    }


    private Button createPatientButton() {
        Button button = new Button("Zapisz podstawowe dane pacjenta", event -> savePatient());
        button.addStyleName(ValoTheme.BUTTON_PRIMARY);
        button.setWidth(WIDTH, Unit.PIXELS);
        return button;
    }

    // other
    private Button createButton() {
        Button button = new Button("Zapisz", event -> save());
        button.addStyleName(ValoTheme.BUTTON_PRIMARY);
        button.setWidth(WIDTH, Unit.PIXELS);
        return button;
    }

    private void savePatient() {
        Patient data = new Patient();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (binderPatient.writeBeanIfValid(data)) {
            Notification.show("Registration data saved successfully",
                    String.format("Patient Information'%d'",
                            binder.getBean().getId()),
                    Type.HUMANIZED_MESSAGE);

            String json = gson.toJson(data);

            try {
                FileWriter writer = new FileWriter("person_"+ binder.getBean().getId()+".json");
                writer.write(json);
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Notification.show(
                    "Registration could not be saved, please check all fields",
                    Type.ERROR_MESSAGE);
        }
    }

    public static void commonStatusChangeHandler(BindingValidationStatus<?> event,
                                           AbstractTextField field) {
        Label statusLabel = (Label) field.getData();
        statusLabel.setVisible(!event.getStatus().equals(Status.UNRESOLVED));
        switch (event.getStatus()) {
            case OK:
                statusLabel.setValue("");
                statusLabel.setIcon(VaadinIcons.CHECK);
                statusLabel.getParent().addStyleName(VALID);
                break;
            case ERROR:
                statusLabel.setIcon(VaadinIcons.CLOSE);
                statusLabel.setValue(event.getMessage().orElse("Unknown error"));
                statusLabel.getParent().removeStyleName(VALID);
            default:
                break;
        }
    }
    private void save() {
        Data data = new Data();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (binder.writeBeanIfValid(data)) {
            Notification.show("Registration data saved successfully",
                    String.format("Day Data of patient '%d',day '%d'",
                            data.getId(), data.getDay()),
                    Type.HUMANIZED_MESSAGE);
            String json = gson.toJson(data);

            try {
                FileWriter writer = new FileWriter("day_"+ data.getId()+"_"+ data.getDay()+".json");
                writer.write(json);
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Notification.show(
                    "Registration could not be saved, please check all fields",
                    Type.ERROR_MESSAGE);
        }
    }

    @WebServlet(urlPatterns = "/*")
    @VaadinServletConfiguration(ui = DataDay.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}