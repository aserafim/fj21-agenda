package br.com.caelum.agenda;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class TestaConsulta {

    public static void main(String[] args) throws ClassNotFoundException{

        ContatoDao dao = new ContatoDao();

        List<Contato> contatos = dao.getLista();
        SimpleDateFormat dataFormatada = new SimpleDateFormat();

        for(Contato contato:contatos){

            System.out.println("Nome: " + contato.getNome());
            System.out.println("Email: " + contato.getEmail());
            System.out.println("Endereço: " + contato.getEndereco());
            System.out.println("Data de nascimento: " + dataFormatada.format(contato.getDataNascimento().getTime()) + "\n");
        }

    }
}
