package frisney.com.github.agenda;

import frisney.com.github.agenda.domain.ContatosMemoria;
import frisney.com.github.agenda.util.Navegador;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Map;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Navegador.initNavigator(primaryStage);
        Navegador.createViews(Map.ofEntries(
            Map.entry("list","list.fxml"),
            Map.entry("form","form.fxml")
        ));
        ContatosMemoria.initialize();
        Navegador.navigate("list");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
