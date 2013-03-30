/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import controller.AlunoJpaController;
import controller.exceptions.NonexistentEntityException;
import java.util.List;
import model.pojo.Aluno;

/**
 *
 * @author rodricxc
 */
public class AlunoDaoImpl implements AlunoDao {
    
    private static AlunoDaoImpl instance = null;
    
    private AlunoJpaController jpaAluno = null;
    public AlunoDaoImpl() {
        jpaAluno = new AlunoJpaController(factory);        
    }
    
    public static synchronized AlunoDao getInstance(){
        if (instance == null){
            instance = new AlunoDaoImpl();
            System.out.println("criado nova instancia");
        }else{
            System.out.println("instancia ja criada");
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
        return jpaAluno.findAluno(id);
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
    public Aluno getCPF(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
