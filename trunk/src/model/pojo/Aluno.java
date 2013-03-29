/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author rodricxc
 */
@Entity
public class Aluno extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<Integer> listaAlunoTurmas;

    protected Aluno() {
        super("","");
    }
    

    public Aluno( String nome, String cpf) {
            super(nome, cpf);
            this.listaAlunoTurmas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "model.dao.Aluno[ id=" + getId() + " ]";
    }
    
}
