/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import model.pojo.Aluno;

/**
 *
 * @author rodricxc
 */
@Entity
public class AlunoTurma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Turma turma;
    @ManyToOne
    private Aluno aluno;
    @OneToMany(mappedBy = "alunoTurma")
    private List<NotaAtividade> notaAtividades;
    private int faltas;
    private float notaFinal;

    public AlunoTurma() {
    }

    public AlunoTurma(Turma turma, Aluno aluno) {
        this.turma = turma;
        this.aluno = aluno;
        this.notaAtividades = new ArrayList<NotaAtividade>();
        this.faltas = 0;
        this.notaFinal = 0;
    }
    
    public boolean addNotaAtividade(NotaAtividade notaAtividade) {
        if (!this.notaAtividades.contains(notaAtividade)) {
            this.notaAtividades.add(notaAtividade);
            return true;
        }
        return false;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Aluno getAluno() {
        return aluno;
    }
    
    public Turma getTurma() {
        return turma;
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
        if (!(object instanceof AlunoTurma)) {
            return false;
        }
        AlunoTurma other = (AlunoTurma) object;
        if (this.id == null && other.id != null) {
            return false;
        }
        if (!this.aluno.getId().equals(other.getAluno().getId()) ||
                !this.turma.getId().equals(other.getTurma().getId())) {
            return false;
        }
        if (this.id != null && !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.dao.AlunoTurma[ id=" + id + " ]";
    }
    
}
