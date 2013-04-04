/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author rodricxc
 */
@Entity
public class Professor extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    

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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "model.dao.Professor[ id=" + getId() + " ]";
    }

    public boolean addTurma(Turma turma) {
        if (!this.turmas.contains(turma)) {
            this.turmas.add(turma);
            return true;
        }
        return false;
    }
   
    public List<Turma> getTurmas() {
        return this.turmas;
    }
}
