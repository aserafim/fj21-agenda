package br.com.caelum.agenda;

import java.util.Calendar;

public class Contato {
    private Long id;
    private String nome;
    private String email;
    private String endereco;
    private Calendar dataNascimento;

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }


    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getEndereco(){
        return this.endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public Calendar getDataNascimento(){
        return this.dataNascimento;
    }
    public void setDataNascimento(Calendar dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }
}
