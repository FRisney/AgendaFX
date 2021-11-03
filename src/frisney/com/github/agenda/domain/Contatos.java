package frisney.com.github.agenda.domain;

import frisney.com.github.listacontatos.classes.Contato;
import frisney.com.github.listacontatos.enums.TipoInfo;

import java.util.ArrayList;

public class Contatos {
    private static ArrayList<Contato> contatos;

    public static ArrayList<Contato> getContatos() {
        return contatos;
    }

    public static void setContatos(ArrayList<Contato> contatos) {
        Contatos.contatos = contatos;
    }

    public static void addContato(Contato contato){
        contatos.add(contato);
    }

    public static Contato getContato(int index) throws Exception {
        try{
            return contatos.get(index);
        }catch (Exception e){
            throw new Exception("Contato nao encontrado");
        }
    }

    public static void updateContato(int index, Contato contatoNovo) throws Exception {
        Contato contatoAntigo = getContato(index);
        int indiceCopntato = contatos.indexOf(contatoAntigo);
        contatos.set(indiceCopntato, contatoNovo);
    }

    public static void initialize() {
        contatos = new ArrayList<>();
    }
}
