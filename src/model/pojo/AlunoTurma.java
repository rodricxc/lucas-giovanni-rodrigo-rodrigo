/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.turma);
        hash = 29 * hash + Objects.hashCode(this.aluno);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AlunoTurma other = (AlunoTurma) obj;
        if (!Objects.equals(this.turma, other.turma)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "model.dao.AlunoTurma[ id=" + id + " ]";
    }

    /**
     * @return the faltas
     */
    public int getFaltas() {
        return faltas;
    }

    /**
     * @return the notaFinal
     */
    public float getNotaFinal() {
        float nota = 0;
        for (NotaAtividade notaAtividade : notaAtividades) {
            nota += notaAtividade.getNota();
        }
        notaFinal = nota;
        return nota;
    }
    
}
