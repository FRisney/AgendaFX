package frisney.com.github.agenda.gui.controllers;

import frisney.com.github.agenda.domain.Contatos;
import frisney.com.github.agenda.domain.Navegador;
import frisney.com.github.listacontatos.classes.Contato;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ListController implements Initializable {
    @FXML
    private Button btnNovo;
    @FXML
    private TableView<Contato> tblLista;

    public void goNovoContato(ActionEvent event){
        Navegador.navigate("form");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarDados();
    }

    public void carregarDados(){
        ObservableList<Contato> listaContatos = FXCollections.observableArrayList(Contatos.getContatos());
        this.tblLista.setItems(listaContatos);
    }

    public void selecionaContato(ActionEvent event){
        int index = tblLista.getSelectionModel().getSelectedIndex();
        if (index < 0) return;

        Navegador.navigateWithParam("form",index);
    }
}
