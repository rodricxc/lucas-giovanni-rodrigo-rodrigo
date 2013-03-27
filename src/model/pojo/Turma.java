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
public class Turma {
    private int id;
    private int ano;
    private int periodo;
    private String local;
    private String horario;
    private int vagas;
    private int disciplina;
    private int professor;
    private List<Integer> listaAlunoTurmas;
    private List<Integer> listaAtividades;

    public Turma(int id, int ano, int periodo, String local, String horario,
                    int vagas, int disciplina, int professor) {
        this.id = id;
        this.ano = ano;
        this.periodo = periodo;
        this.local = local;
        this.horario = horario;
        this.vagas = vagas;
        this.disciplina = disciplina;
        this.professor = professor;
        this.listaAlunoTurmas = new ArrayList<>();
        this.listaAtividades = new ArrayList<>();
    }
    public Turma(int id, int ano, int periodo, String local, String horario,
                    int vagas, int disciplina, int professor, List<Integer> alunos, List<Integer> atividades) {
        this(id, ano, periodo, local, horario, vagas, disciplina, professor);
        this.listaAlunoTurmas = alunos;
        this.listaAtividades = atividades;
    }	
    public int getDisciplina() {
        return disciplina;
    }
    public int getProfessor() {
        return professor;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public int getAno() {
        return ano;
    }
    public int getPeriodo() {
        return periodo;
    }
    /**
    * Converte o objeto para uma string de modo que ele possa ser 
    * reconstruido com os mesmos valores
    * 
    * Usado na escrita em arquivo
    */
    public String toStringIDs() {
        int nAlunos = this.listaAlunoTurmas.size();
        String sAlunos = new String();
        for (int i = 0; i < this.listaAlunoTurmas.size(); i++) {
            sAlunos += "\t" + this.listaAlunoTurmas.get(i);
        }
        int nAtividades = this.listaAtividades.size();
        String sAtividades = new String();
        for (int i = 0; i < nAtividades; i++) {
            sAtividades += "\t" + this.listaAtividades.get(i);
        }
        return String.format("%d\t%d\t%d\t%s\t%s\t%d\t%d\t%d\t%d%s\t%d%s",
                    id, ano, periodo, local, horario, vagas, disciplina,
                    professor, nAlunos, sAlunos,nAtividades,sAtividades);
    }
    @Override
    public String toString() {
        return String.format("ID: %d\tAno: %d/%d\tLocal: %s\t" +
                        "Horario: %s\tVagas: %d\tDisciplina: %d" +
                        "\tAlunos: %d", id, ano, periodo, local, horario, vagas,
                        disciplina, listaAlunoTurmas.size());
    }
    public int getId() {
        return id;
    }
    public boolean addRegistro(int regID){
        listaAlunoTurmas.add(new Integer(regID));
        return true;
    }
    public boolean equals(Object o){
        if((o instanceof Turma) && (((Turma)o).getId()==this.getId())){
            return true;
        } else {
            return false;
        }
    }
    public List<Integer> getListaRegistro() {
        return listaAlunoTurmas;
    }
}
