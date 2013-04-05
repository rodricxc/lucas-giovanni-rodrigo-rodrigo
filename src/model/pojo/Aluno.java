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
    
    public boolean addAlunoTurma(AlunoTurma alunoTurma) {
        if (!this.alunoTurmas.contains(alunoTurma)) {
            this.alunoTurmas.add(alunoTurma);
            return true;
        }
        return false;
    }

    public List<AlunoTurma> getAlunoTurmas() {
        return this.alunoTurmas;
    }
    
    public List<AlunoTurma> getAprovadas() {
        List<AlunoTurma> lista = new ArrayList<>();
        for (AlunoTurma alunoTurma : this.alunoTurmas) {
            if (alunoTurma.getNotaFinal() >= 6.0 &&
                    alunoTurma.getFaltas() <= alunoTurma.getTurma().getDisciplina().getCargaHoraria()) {
                lista.add(alunoTurma);
            }
        }
        return lista;
    }
    
    @Override
    public String toString() {
        return this.nome+" - cpf: "+this.cpf;
    }
    
}
