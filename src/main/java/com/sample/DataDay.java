package com.sample;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.annotation.WebServlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
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

    public static HorizontalLayout add_label(Layout layout, String s) {
        Label labelMessage = new Label(s);
        labelMessage.setWidth(LABEL_WIDTH, Unit.PIXELS);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        horizontalLayout.addComponent(labelMessage);
        layout.addComponent(horizontalLayout);
        return horizontalLayout;
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
        //TODO jesli chceckboxy wylaczone - wyzeruj
        VerticalLayout layout = new VerticalLayout();
        layout.setWidth(100, Unit.PERCENTAGE);
        setContent(layout);
        TextField id = punkt1(layout, binder);

        id.setVisible(false);
        TextField idUnbind = new TextField();
        addToLayout(layout, idUnbind, "Id pacjenta", "0");

        idUnbind.addValueChangeListener(event-> id.setValue(idUnbind.getValue()));

        AtomicInteger maxValue = new AtomicInteger(lastDay(idUnbind));
        idUnbind.addValueChangeListener(event-> maxValue.set(lastDay(idUnbind)));
        CheckBox poprzedni = new CheckBox(String.format("Ostatni znaleziony dzień pacjenta %s to %d. Czy Chcesz załadować dane z tego dnia jako podstawę dnia następnego?", idUnbind.getValue(), maxValue.get()));
        layout.addComponent(poprzedni);
        poprzedni.setVisible(false);
        HorizontalLayout newDay = add_label(layout, "Pacjent nie ma jeszcze zarejestrowanego żadnego dnia");
        idUnbind.addValueChangeListener(event -> {
                    if (lastDay(idUnbind) == -1) {
                        poprzedni.setVisible(false);
                        newDay.setVisible(true);
                    } else {
                        poprzedni.setVisible(true);
                        newDay.setVisible(false);
                    }
        });


        idUnbind.addValueChangeListener(event-> poprzedni.setCaption(String.format("Ostatni znaleziony dzień pacjenta %s to %d. Czy Chcesz załadować dane z tego dnia?", idUnbind.getValue(), maxValue.get())));

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
                    File f = new File("persons\\person_"+idUnbind.getValue()+".json");
                    if(!f.exists()) {
                        horizontalLayout.setVisible(true);
                        pacjentWBazieMsg.setVisible(false);
                    }else{
                        horizontalLayout.setVisible(false);
                        pacjentWBazieMsg.setVisible(true);
                    }
                }
        );
        TextField day = dayView(layout, binder);
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
        idUnbind.focus();
        binderPatient.setBean(new Patient());


        day.addValueChangeListener(event->{
            String name = String.format("days\\day_%s_%s.json", idUnbind.getValue(), day.getValue());
            File f = new File(name);
            if (f.exists()){
                bindFromFile(name);
            }
        });

        poprzedni.addValueChangeListener(event->{
            if(poprzedni.getValue()) {
                String name =String.format("days\\day_%s_%s.json", idUnbind.getValue(), maxValue.get());
                bindFromFile(name);
                day.setValue(String.valueOf(Integer.valueOf(day.getValue()) + 1));

            }
    });
        binder.setBean(new Data());
    }

    private void bindFromFile(String name) {
        Gson gson = new Gson();
        JsonReader reader = null;

        try {
            reader = new JsonReader(new FileReader(name));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Data data = gson.fromJson(reader, Data.class);
        binder.setBean(data);
    }

    private int lastDay(TextField id) {
        int maxValue = -1;
        try (Stream<Path> paths = Files.walk(Paths.get("days"))) {
            for(Path path : paths.collect(Collectors.toList())){
                String name = String.format("days\\day_%s_", id.getValue());
                System.out.println(name);
                if(path.toString().startsWith(name)){
                    String p = path.toString().replace(name, "");
                    p = p.replace(".json", "");
                    System.out.println(p);
                    Integer value = Integer.valueOf(p);
                    if(value > maxValue){
                        maxValue = value;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maxValue;
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
        Button button = new Button("Zapisz dzień", event -> save());
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
                FileWriter writer = new FileWriter("persons/person_"+ binder.getBean().getId()+".json");
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
                FileWriter writer = new FileWriter("days/day_"+ data.getId()+"_"+ data.getDay()+".json");
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