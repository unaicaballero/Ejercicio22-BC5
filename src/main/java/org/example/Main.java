package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ejercicio 22 - Dialogo de seleccion de opciones");

        Button seleccionarButton = new Button("Seleccionar opcion");

        // Al pulsar se abre un ChoiceDialog con una lista de opciones
        seleccionarButton.setOnAction(event -> mostrarDialogoOpciones());

        VBox vbox = new VBox(seleccionarButton);
        vbox.setSpacing(10);
        vbox.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(vbox, 280, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarDialogoOpciones() {
        // Lista de opciones disponibles
        List<String> opciones = Arrays.asList("Opcion A", "Opcion B", "Opcion C", "Opcion D");

        // ChoiceDialog recibe la opcion por defecto y la lista completa
        ChoiceDialog<String> dialogo = new ChoiceDialog<>("Opcion A", opciones);
        dialogo.setTitle("Seleccion de opciones");
        dialogo.setHeaderText("Elige una opcion de la lista:");
        dialogo.setContentText("Opciones disponibles:");

        // showAndWait() devuelve un Optional con la opción elegida
        Optional<String> resultado = dialogo.showAndWait();

        if (resultado.isPresent()) {
            System.out.println("Opcion seleccionada: " + resultado.get());
        } else {
            System.out.println("El usuario cerro el dialogo sin seleccionar.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}