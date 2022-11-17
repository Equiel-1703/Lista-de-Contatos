package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import listacontatos.App;
import listacontatos.Communicator;
import listacontatos.Contato;
import listacontatos.Telefone;
import listacontatos.TipoTelefone;

public class SetContatoController implements Initializable {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtEnder;
    @FXML
    private Button btnOK;
    @FXML
    private TextField txtDDI;
    @FXML
    private TextField txtDDD;
    @FXML
    private TextField txtTel;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnCancel;
    @FXML
    private RadioButton rbtnComercial;
    @FXML
    private ToggleGroup TipoTel;
    @FXML
    private RadioButton rbtnResidencial;
    @FXML
    private RadioButton rbtnCelular;
    
    public void clickOK() throws IOException {
        
        // Cria alerta para informar o usuário de possíveis erros
        Alert a = new Alert(Alert.AlertType.ERROR);
        
        // Cria o contato
        Contato novoContato = new Contato();
        // Cria os objetos de telefone e tipo de telefone
        TipoTelefone tipoT = rbtnCelular.isSelected() ? TipoTelefone.CELULAR : rbtnComercial.isSelected() ? TipoTelefone.COMERCIAL : TipoTelefone.RESIDENCIAL;
        Telefone novoTel = new Telefone(tipoT);
        
        if(!novoTel.setDDD(txtDDD.getText()))
        {
            a.setContentText("Erro no DDD!");
            a.show();
            return;
        }
        
        if(!novoTel.setDDI(txtDDI.getText()))
        {
            a.setContentText("Erro no DDI!");
            a.show();
            return;
        }
        
        if(!novoTel.setNUM(txtTel.getText()))
        {
            a.setContentText("Número de telefone em formato incorreto!");
            a.show();
            return;
        }
        
        // Depois de validado, seta o telefone
        novoContato.setTelefone(novoTel);
        
        // Seta email
        if(!novoContato.setEmail(txtEmail.getText()))
        {
            a.setContentText("Email em formato inválido!");
            a.show();
            return;
        }
        
        // Seta nome e endereço
        novoContato.setEndereco(txtEnder.getText());
        novoContato.setNome(txtNome.getText());

        // Coloca o contato criado na pilha do comunicador
        Communicator com = Communicator.getInstance();
        com.stack.push(novoContato);
        
        // Troca de cena
        Parent root = FXMLLoader.load(this.getClass().getResource("/telaPrincipal.fxml"));
        Scene sc = new Scene(root);
        
        App.getMainStage().setScene(sc);
        App.getMainStage().setTitle("Agenda");
    }
    
    public void clickCancel() {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
