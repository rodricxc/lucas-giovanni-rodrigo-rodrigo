/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author rodricxc
 */
@Entity
public class Professor extends Usuario implements Serializable {
    

    private String departamento;
    @OneToMany(mappedBy = "professor")
    private List<Turma> turmas;

    public Professor() {
        super("","");
    }
    
    public Professor(String nome, String cpf, String departamento) {
        super(nome, cpf);
        this.departamento = departamento;
    }
    /**
    * Converte o objeto para uma string de modo que ele possa ser 
    * reconstruido com os mesmos valores
    * 
    * Usado na escrita em arquivo
    */

    @Override
    public String toString() {
        return "model.dao.Professor[ id=" + getId() + " ]";
    }
    
}
