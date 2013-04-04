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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author rodricxc
 */
@Entity
public class Turma implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "turma")
    private List<AlunoTurma> alunoTurmas;
    private int ano;
    private int periodo;
    private String localAula;
    private String horario;
    private int vagas;
    @ManyToOne
    private Disciplina disciplina;
    @ManyToOne
    private Professor professor;
    @OneToMany(mappedBy = "turma")
    private List<Atividade> atividades;

    public Turma() {
    }

    public Turma(int ano, int periodo, String local, String horario, int vagas,
            Disciplina disciplina, Professor professor) {
        this.ano = ano;
        this.periodo = periodo;
        this.localAula = local;
        this.horario = horario;
        this.vagas = vagas;
        this.disciplina = disciplina;
        this.professor = professor;
    }
    
    public boolean addAlunoTurma(AlunoTurma alunoTurma) {
        if (!this.alunoTurmas.contains(alunoTurma)) {
            this.alunoTurmas.add(alunoTurma);
            return true;
        }
        return false;
    }
    
    public boolean addAtividade(Atividade atividade) {
        if (!this.atividades.contains(atividade)) {
            this.getAtividades().add(atividade);
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getLocalAula() {
        return localAula;
    }

    public void setLocalAula(String localAula) {
        this.localAula = localAula;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public boolean addAluno(AlunoTurma alunoTurma) {
        if (!alunoTurmas.contains(alunoTurma)) {
            alunoTurmas.add(alunoTurma);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turma)) {
            return false;
        }
        Turma other = (Turma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Turma: "+ getDisciplina().getNome()+" - "+ano+"/"+periodo+" prof: "+professor.getNome();
    }

    public Professor getProfessor() {
        return professor;
    }
    
    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    public List<AlunoTurma> getAlunoTurmas() {
        return alunoTurmas;
    }

    /**
     * @return the atividades
     */
    public List<Atividade> getAtividades() {
        return atividades;
    }

}
