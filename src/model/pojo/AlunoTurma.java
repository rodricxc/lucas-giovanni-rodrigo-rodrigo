/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodricxc
 */
public class AlunoTurma {
    private int id;
    private int turmaId;
    private int alunoId;
    private int faltas;
    private float notaFinal;
    /**
     * Lista com Ids dos RegistroAtividade(s) que a auxiliam no
     * salvamento das notas de cada aluno em determinada Atividade 
     *  
     */
    List<Integer> listaNotaAtividades;

    public AlunoTurma(int id, Turma turma, Aluno aluno) {
            this(id,turma.getId(),aluno.getId());
            aluno.addRegistro(this.getId());
            turma.addRegistro(this.getId());
    }
    public AlunoTurma(int id, int turmaId, int alunoId) {
            this.id = id;
            this.alunoId = alunoId;
            this.turmaId = turmaId;
            listaNotaAtividades = new ArrayList<>();
    }
    public AlunoTurma(int id, int turmaId, int alunoId, int faltas,
                    float notaFinal, List<Integer> registroAtividades) {

            this(id, turmaId, alunoId);
            this.faltas = faltas;
            this.notaFinal = notaFinal;
            this.listaNotaAtividades = registroAtividades;
    }
    public int getFaltas() {
            return faltas;
    }
    public void setFaltas(int faltas) {
            this.faltas = faltas;
    }
    public int getId() {
            return id;
    }
    public int getAlunoId() {
            return this.alunoId;
    }
    public int getTurmaId() {
            return this.turmaId;
    }
    /**
    * Converte o objeto para uma string de modo que ele possa ser 
    * reconstruido com os mesmos valores
    * 
    * Usado na escrita em arquivo
    */
    public String toStringIDs() {
            int nAtividades = this.listaNotaAtividades.size();
            String sAtividades = new String();
            for (int i = 0; i < this.listaNotaAtividades.size(); i++) {
                    sAtividades += "\t" + this.listaNotaAtividades.get(i);
            }
            return String.format("%d\t%d\t%d\t%d\t%.2f\t%d%s", id, turmaId, alunoId, faltas,
                            notaFinal, nAtividades, sAtividades);
    }
    
    @Override
    public boolean equals(Object o){

        if((o instanceof AlunoTurma) && 
                (((AlunoTurma)o).getId() == this.getId()) ){
            return true;
        } else {
            return false;
        }
    }
}
