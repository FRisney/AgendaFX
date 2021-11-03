package frisney.com.github.agenda.domain;

import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navegador {
    private static Map<String, String> _views;
    private static Stage _primaryStage;
    private static Object parameter;

    public static void initNavigator(Stage primaryStage){
        _primaryStage = primaryStage;
    }

    public static void createViews(Map<String,String> views){
        _views = new HashMap<>();
        System.out.println("Inicializando views:");
        views.forEach((s, s2) -> {
            var path = "/frisney/com/github/agenda/gui/views/" + s2;
            _views.put(s,path);
            System.out.printf("%s -> %s\n", s, s2);
        });
        System.out.println("views inicializadas");
    }

    public static void navigate(String view){
        try {
            System.out.printf("Navegando para %s\n",view);
            Parent root = (Parent)FXMLLoader.load(
                Navegador.class.getResource(_views.get(view))
            );
            _primaryStage.setScene(new Scene(root));
            _primaryStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void navigateWithParam(String view, Object param){
        parameter = param;
        navigate(view);
    }

    public static void limpaParam(){
        parameter = null;
    }

    public static Object getParameter(){
        if (parameter == null) return null;
        Object aux = parameter;
        limpaParam();
        return aux;
    }

}

