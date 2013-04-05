/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.pojo.Aluno;
import model.pojo.AlunoTurma;
import model.pojo.Disciplina;
import model.pojo.Professor;
import model.pojo.Turma;

public interface TurmaDao {
    static final String PERSISTENCE_UNIT_NAME = "LucasGiovanniRodrigoRodrigo";
    static EntityManagerFactory factory = 
           Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    
    public boolean add(Turma turma);
    public boolean delete(Turma turma);
    public Turma get(int id);
    public List<Turma> get();
    public List<Turma> getByDisciplinaAnoPeriodo(Disciplina disciplina, int ano, int periodo);
    public List<AlunoTurma> situacaoAluno(Disciplina disciplina, Aluno aluno);
    public int numeroOfertasPorDisciplina(Disciplina disciplina);
    public int numeroDisciplinasPorProfessor(Professor professor);
    public List<Disciplina> disciplinasByList(List<Turma> turmas);
    public List<Turma> getByProfessor(Professor professor);

    public boolean update(Turma turma);
}
