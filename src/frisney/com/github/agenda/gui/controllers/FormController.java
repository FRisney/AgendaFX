package frisney.com.github.agenda.gui.controllers;

import frisney.com.github.agenda.domain.Contatos;
import frisney.com.github.agenda.domain.Navegador;
import frisney.com.github.listacontatos.classes.Contato;
import frisney.com.github.listacontatos.classes.Email;
import frisney.com.github.listacontatos.classes.Telefone;
import frisney.com.github.listacontatos.enums.TipoTelefone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FormController implements Initializable {
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnCriar;
    @FXML
    private Label lblTitle;
    @FXML
    private TextField fldNome;
    @FXML
    private TextField fldSobrenome;
    @FXML
    private TextField fldEmail;
    @FXML
    private TextField fldTelefone;

    private char action = 'A';
    private int editIndex = -1;

    public void goBack(ActionEvent event){
        Navegador.navigate("list");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            var param = Navegador.getParameter();
            if (param == null || (int)param < 0) return;
            editIndex = (int) param;

            Contato contato = Contatos.getContato(editIndex);

            lblTitle.setText("Editar Contato");
            action = 'E';

            fldNome.setText(contato.getNome());
            fldSobrenome.setText(contato.getSobrenome());
            fldEmail.setText(contato.getEmail());
            fldTelefone.setText(contato.getTelefone());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void confirmar(ActionEvent event){
        switch (action){
            case 'E':
                editaContato();
                break;
            case 'A':
                criaContato();
                break;
        }
        goBack(event);
    }

    public void editaContato(){
        Contato novoContato = new Contato(
            fldNome.getText(),
            fldSobrenome.getText()
        );
        novoContato.setInfo(new Telefone(fldTelefone.getText(),TipoTelefone.CELULAR));
        try {
            Contatos.updateContato(editIndex,novoContato);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void criaContato(){
        Contato contato = new Contato(
                fldNome.getText(),
                fldSobrenome.getText()
        );
        contato.setInfo(new Telefone(fldTelefone.getText(),TipoTelefone.CELULAR));
        contato.setInfo(new Email(fldEmail.getText()));
        Contatos.addContato(contato);
    }
}
