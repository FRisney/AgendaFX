package frisney.com.github.agenda.domain;

import frisney.com.github.listacontatos.classes.Contato;

import java.util.ArrayList;

public interface IContatos {
    ArrayList<Contato> getContatos();

    Contato getContato(int index) throws Exception;

    void addContato(Contato contato);

    void updateContato(int index, Contato contatoNovo) throws Exception;

    void delContato(Contato contato);

    void delContato(int index);
}
