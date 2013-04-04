/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author rodricxc
 */
@Entity
public class NotaAtividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Atividade atividade;
    @ManyToOne
    private AlunoTurma alunoTurma; 
    private float nota;

    public NotaAtividade() {
    }
    
    public NotaAtividade(AlunoTurma alunoTurma, Atividade atividade) {
        this.alunoTurma = alunoTurma;
        this.atividade = atividade;
    }
    
    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaAtividade)) {
            return false;
        }
        NotaAtividade other = (NotaAtividade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.dao.NotaAtividade[ id=" + id + " ]";
    }

    /**
     * @return the atividade
     */
    public Atividade getAtividade() {
        return atividade;
    }

    /**
     * @return the alunoTurma
     */
    public AlunoTurma getAlunoTurma() {
        return alunoTurma;
    }

    /**
     * @return the nota
     */
    public float getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(float nota) {
        this.nota = nota;
    }
    
}
