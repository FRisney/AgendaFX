package frisney.com.github.agenda.domain;

import frisney.com.github.listacontatos.classes.Contato;

import java.util.ArrayList;

public class ContatosMemoria implements IContatos {
    private static ArrayList<Contato> contatos = new ArrayList<>();

    @Override
    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    @Override
    public void addContato(Contato contato){
        contatos.add(contato);
    }

    @Override
    public void delContato(Contato contato) {
        contatos.remove(contato);
    }
    @Override
    public void delContato(int index) {
        contatos.remove(index);
    }

    @Override
    public Contato getContato(int index) throws Exception {
        try{
            return contatos.get(index);
        }catch (Exception e){
            throw new Exception("Contato nao encontrado");
        }
    }

    @Override
    public void updateContato(int index, Contato contatoNovo) throws Exception {
        Contato contatoAntigo = getContato(index);
        int indiceCopntato = contatos.indexOf(contatoAntigo);
        contatos.set(indiceCopntato, contatoNovo);
    }
}
