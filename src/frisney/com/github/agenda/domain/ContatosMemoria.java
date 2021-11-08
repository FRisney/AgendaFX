package frisney.com.github.agenda.domain;

import frisney.com.github.listacontatos.classes.Contato;

import java.util.ArrayList;

public class ContatosMemoria {
    private static ArrayList<Contato> contatos;

    public static ArrayList<Contato> getContatos() {
        return contatos;
    }

    public static void setContatos(ArrayList<Contato> contatos) {
        ContatosMemoria.contatos = contatos;
    }

    public static void addContato(Contato contato){
        contatos.add(contato);
    }

    public static void delContato(Contato contato) { contatos.remove(contato); }
    public static void delContato(int index) { contatos.remove(index); }

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
