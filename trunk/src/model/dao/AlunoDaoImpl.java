/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import dataBaseConections.AlunoJpaController;
import dataBaseConections.exceptions.NonexistentEntityException;
import java.util.List;
import model.pojo.Aluno;

/**
 *
 * @author rodricxc
 */
public class AlunoDaoImpl implements AlunoDao {
    
    private static AlunoDaoImpl instance = null;
    
    private AlunoJpaController jpaAluno = null;
    private AlunoDaoImpl() {
        jpaAluno = new AlunoJpaController(factory);        
    }
    
    public static synchronized AlunoDao getInstance(){
        if (instance == null){
            instance = new AlunoDaoImpl();
        }
        return instance;
    }

    @Override
    public boolean add(Aluno aluno) {
        if(jpaAluno.findAlunoEntities().contains(aluno)){
            return false;
        }else{
            jpaAluno.create(aluno);
            return true;
        }
    }

    @Override
    public boolean delete(Aluno aluno) {
        if(!(jpaAluno.findAlunoEntities().contains(aluno))){
            return false;
        }
        try {
            jpaAluno.destroy(aluno.getId());
        } catch (NonexistentEntityException ex) {
            return false;
        }
        return true;
    }
 
    @Override
    public Aluno get(int id) {
        return jpaAluno.findAluno(new Long(id));
    }
    
    @Override
    public List<Aluno> getAprox(String nome) {
        return jpaAluno.getAlunoByNomeAprox(nome);
    }

    @Override
    public List<Aluno> get(String nome) {
        return jpaAluno.getAlunoByNome(nome);
    }

    @Override
    public List<Aluno> get() {
        return jpaAluno.findAlunoEntities();
    }

    @Override
    public List<Aluno> getCPF(String cpf) {
        return jpaAluno.getAlunoByCPF(cpf);
    }

    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return (jpaAluno.getAlunoCount() == 0);
    }

    @Override
    public boolean hasId(int id) {
        Aluno findAluno = jpaAluno.findAluno(new Long(id));
        return !(findAluno == null);
    }
    
}