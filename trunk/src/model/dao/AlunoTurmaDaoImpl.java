package model.dao;

import dataBaseConections.AlunoTurmaJpaController;
import dataBaseConections.exceptions.NonexistentEntityException;
import java.util.List;
import model.pojo.AlunoTurma;

public class AlunoTurmaDaoImpl implements AlunoTurmaDao {
    
    private static AlunoTurmaDaoImpl instance = null;
    
    private AlunoTurmaJpaController jpaAlunoTurma = null;
    private AlunoTurmaDaoImpl() {
        jpaAlunoTurma = new AlunoTurmaJpaController(factory);        
    }
    
    public static synchronized AlunoTurmaDao getInstance(){
        if (instance == null){
            instance = new AlunoTurmaDaoImpl();
        }
        return instance;
    }

    @Override
    public boolean add(AlunoTurma alunoTurma) {
        if(jpaAlunoTurma.findAlunoTurmaEntities().contains(alunoTurma)){
            return false;
        }else{
            jpaAlunoTurma.create(alunoTurma);
            return true;
        }
    }

    @Override
    public boolean delete(AlunoTurma alunoTurma) {
        if(!(jpaAlunoTurma.findAlunoTurmaEntities().contains(alunoTurma))){
            return false;
        }
        try {
            jpaAlunoTurma.destroy(alunoTurma.getId());
        } catch (NonexistentEntityException ex) {
            return false;
        }
        return true;
    }

    @Override
    public AlunoTurma get(int id) {
        return jpaAlunoTurma.findAlunoTurma(new Long(id));
    }

    @Override
    public List<AlunoTurma> getByTurma(int turmaId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AlunoTurma> getByAluno(int alunoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AlunoTurma getByAmbos(int turmaId, int alunoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AlunoTurma> get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
