/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import dataBaseConections.TurmaJpaController;
import dataBaseConections.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import model.pojo.Aluno;
import model.pojo.AlunoTurma;
import model.pojo.Disciplina;
import model.pojo.Professor;
import model.pojo.Turma;

/**
 *
 * @author rodrigo
 */
public class TurmaDaoImpl implements TurmaDao {

    private static TurmaDaoImpl instance = null;
    
    private TurmaJpaController jpaTurma = null;
    private TurmaDaoImpl() {
        jpaTurma = new TurmaJpaController(factory);        
    }
    
    public static synchronized TurmaDao getInstance(){
        if (instance == null){
            instance = new TurmaDaoImpl();
        }
        return instance;
    }
    
    @Override
    public boolean add(Turma turma) {
        if(jpaTurma.findTurmaEntities().contains(turma)){
            return false;
        } else {
            jpaTurma.create(turma);
            ProfessorDao professorDao = ProfessorDaoImpl.getInstance();
            Professor professor = turma.getProfessor();
            professor.addTurma(turma);
            professorDao.update(professor);
            DisciplinaDao disciplinaDao = DisciplinaDaoImpl.getInstance();
            Disciplina disciplina = turma.getDisciplina();
            disciplina.addTurma(turma);
            disciplinaDao.update(disciplina);
            return true;
        }
    }

    @Override
    public boolean delete(Turma turma) {
        if(!(jpaTurma.findTurmaEntities().contains(turma))){
            return false;
        }
        try {
            jpaTurma.destroy(turma.getId());
        } catch (NonexistentEntityException ex) {
            return false;
        }
        return true;
    }

    @Override
    public Turma get(int id) {
        return jpaTurma.findTurma(new Long(id));
    }

    @Override
    public List<Turma> get() {
        return jpaTurma.findTurmaEntities();
    }

    @Override
    public List<Turma> getByDisciplinaAnoPeriodo(Disciplina disciplina, int ano, int periodo) {
        List<Turma> lista = new ArrayList<>();
        for (Turma turma : jpaTurma.findTurmaEntities()) {
            if (turma.getDisciplina().equals(disciplina) && 
                    turma.getAno() == ano && turma.getPeriodo() == periodo) {
                lista.add(turma);
            }
        }
        return lista;
    }

    @Override
    public List<AlunoTurma> situacaoAluno(Disciplina disciplina, Aluno aluno) {
        List<AlunoTurma> lista = new ArrayList<>();
        for (Turma turma : jpaTurma.findTurmaEntities()) {
            if (turma.getDisciplina().equals(disciplina)) {
                for (AlunoTurma alunoTurma : turma.getAlunoTurmas()) {
                    if (alunoTurma.getAluno().equals(aluno)) {
                        lista.add(alunoTurma);
                    }
                }
            }
        }
        return lista;
    }

    @Override
    public int numeroOfertasPorDisciplina(Disciplina disciplina) {
        int numero = 0;
        for (Turma turma : jpaTurma.findTurmaEntities()) {
            if (turma.getDisciplina().equals(disciplina)) {
                numero++;
            }
        }
        return numero;
    }

    @Override
    public int numeroDisciplinasPorProfessor(Professor professor) {
        List<Disciplina> disciplinasDoProfessor = new ArrayList<>();
        for (Turma turma : jpaTurma.findTurmaEntities()) {
            if (turma.getProfessor().equals(professor)) {
                if (!disciplinasDoProfessor.contains(turma.getDisciplina())) {
                    disciplinasDoProfessor.add(turma.getDisciplina());
                }
            }
        }
        return disciplinasDoProfessor.size();
    }

    @Override
    public List<Disciplina> disciplinasByList(List<Turma> turmas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Turma> getByProfessor(Professor professor) {
        List<Turma> lista = new ArrayList<>();
        for (Turma turma : jpaTurma.findTurmaEntities()) {
            if (turma.getProfessor().equals(professor)) {
                lista.add(turma);
            }
        }
        return lista;
    }

    @Override
    public boolean update(Turma turma) {
        if (!jpaTurma.findTurmaEntities().contains(turma)){
            return false;
        }
        return jpaTurma.update(turma);
    }
    
}
