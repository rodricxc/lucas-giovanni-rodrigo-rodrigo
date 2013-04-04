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
        }else{
            jpaTurma.create(turma);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Turma> get() {
        return jpaTurma.findTurmaEntities();
    }
    @Override
    public List<Turma> getByDisciplinaAnoPeriodo(int disciplina, int ano, int periodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AlunoTurma> situacaoAluno(List<Turma> turmas, Disciplina disciplina, Aluno aluno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int numeroOfertasPorDisciplina(int disciplina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int numeroDisciplinasPorProfessor(int professor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAluno(Aluno aluno, Turma turma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AlunoTurma> getByTurma(Turma turma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Disciplina> disciplinasByList(List<Turma> turmas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Turma> getByProfessor(Professor professor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listarPorProfessor(Professor professor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
