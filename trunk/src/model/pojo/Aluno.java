/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author rodricxc
 */
@Entity
public class Aluno extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @OneToMany(mappedBy = "aluno")
    private List<AlunoTurma> alunoTurmas;

    protected Aluno() {
        super("","");
    }
    

    public Aluno( String nome, String cpf) {
            super(nome, cpf);
            this.alunoTurmas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "model.dao.Aluno[ id=" + getId() + " ]";
    }
    
}
