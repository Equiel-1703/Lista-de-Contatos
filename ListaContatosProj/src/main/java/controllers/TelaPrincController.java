package controllers;

import listacontatos.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import listacontatos.Communicator;
import listacontatos.Contato;


public class TelaPrincController implements Initializable {

    @FXML
    private ListView<Contato> listView;
    private static ObservableList<Contato> bslist = FXCollections.observableArrayList();
    
    public void addContact() throws IOException {
        Parent rootAddScene = FXMLLoader.load(this.getClass().getResource("/setContato.fxml"));
        
        Scene addScene = new Scene(rootAddScene);
        App.getMainStage().setScene(addScene);
        App.getMainStage().setTitle("Adicionar Contato");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.setItems(bslist);
        
        Communicator com = Communicator.getInstance();
        if(!com.stack.isEmpty())
            bslist.add((Contato)com.stack.pop());
    }
    
}
