/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

/**
 *
 * @author rodricxc
 */
public class Professor extends Usuario {
    private String departamento;

    public Professor(int id, String nome, String cpf, String departamento) {
        super(nome, cpf);
        this.departamento = departamento;
        this.setId(id);
    }
    /**
    * Converte o objeto para uma string de modo que ele possa ser 
    * reconstruido com os mesmos valores
    * 
    * Usado na escrita em arquivo
    */
    public String toStringIDs() {
        return String.format("%d\t%s\t%s\t%s", getId(), getNome(), getCpf(),getDepartamento());
    }

    @Override
    public String toString() {
        return String.format("ID: %d\tNome: %s\tCPF: %s\tDepartamento: %s", getId(), getNome(), getCpf(),getDepartamento());
    }

    public String getDepartamento() {
        return departamento;
    }

    /**
     *
     * @return id do Professor
     */
    @Override
    public int getId() {
        return super.getId();
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o){
        if((o instanceof Professor) && (((Professor)o).getCpf().equals(this.getCpf()))){
            return true;
        } else {
            return false;
        }
    }
}
