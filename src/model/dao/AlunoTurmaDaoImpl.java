package model.dao;

import dataBaseConections.AlunoTurmaJpaController;
import dataBaseConections.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import model.pojo.Aluno;
import model.pojo.AlunoTurma;
import model.pojo.Turma;

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
            AlunoDao alunoDao = AlunoDaoImpl.getInstance();
            Aluno aluno = alunoTurma.getAluno();
            aluno.addAlunoTurma(alunoTurma);
            alunoDao.update(aluno);
            TurmaDao turmaDao = TurmaDaoImpl.getInstance();
            Turma turma = alunoTurma.getTurma();
            turma.addAlunoTurma(alunoTurma);
            turmaDao.update(turma);
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
    public List<AlunoTurma> getByAluno(Aluno aluno) {
        List<AlunoTurma> lista = new ArrayList<>();
        for (AlunoTurma alunoTurma : jpaAlunoTurma.findAlunoTurmaEntities()) {
            if (alunoTurma.getAluno().equals(aluno)) {
                lista.add(alunoTurma);
            }
        }
        return lista;
    }

    @Override
    public List<AlunoTurma> getByTurma(Turma turma) {
        List<AlunoTurma> lista = new ArrayList<>();
        for (AlunoTurma alunoTurma : jpaAlunoTurma.findAlunoTurmaEntities()) {
            if (alunoTurma.getTurma().equals(turma)) {
                lista.add(alunoTurma);
            }
        }
        return lista;
    }

    @Override
    public AlunoTurma getByAmbos(Turma turma, Aluno aluno) {
        for (AlunoTurma alunoTurma : jpaAlunoTurma.findAlunoTurmaEntities()) {
            if (alunoTurma.getAluno().equals(aluno) &&
                    alunoTurma.getTurma().equals(turma)) {
                return alunoTurma;
            }
        }
        return null;
    }

    @Override
    public List<AlunoTurma> get() {
        return jpaAlunoTurma.findAlunoTurmaEntities();
    }
    
}
