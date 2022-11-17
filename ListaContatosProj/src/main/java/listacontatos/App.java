package listacontatos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Stage mainStage;
    
    @Override
    public void start(Stage stage) throws IOException {
        if(mainStage == null)
            mainStage = stage;

        Parent root = FXMLLoader.load(this.getClass().getResource("/telaPrincipal.fxml"));
        
        Scene sc = new Scene(root);
        
        mainStage.setScene(sc);
        mainStage.setTitle("Agenda");
        mainStage.setResizable(false);
        mainStage.show();
    }
    
    public static Stage getMainStage() {
        return mainStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}