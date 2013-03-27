/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

/**
 *
 * @author rodricxc
 */
public abstract class Usuario {
    private String nome;
    private String cpf;
    private int id;


    public Usuario(String nome, String cpf){
            this.cpf = cpf;
            this.nome = nome;
    }

    public String getCpf() {
            return cpf;
    }

    public void setCpf(String cpf) {
            this.cpf = cpf;
    }

    public String getNome() {
            return nome;
    }

    public void setNome(String nome) {
            this.nome = nome;
    }

    public int getId() {
            return id;
    }

    protected void setId(int id) {
            this.id = id;
    }
}
