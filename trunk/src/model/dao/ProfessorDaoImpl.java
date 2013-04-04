/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import dataBaseConections.ProfessorJpaController;
import dataBaseConections.exceptions.NonexistentEntityException;
import java.util.List;
import model.pojo.Professor;

/**
 *
 * @author rodricxc
 */
public class ProfessorDaoImpl implements ProfessorDao {
    
    private static ProfessorDao instance = null;
    
    private ProfessorJpaController jpaProf = null;
    private ProfessorDaoImpl() {
        jpaProf = new ProfessorJpaController(factory);        
    }
    
    public static synchronized ProfessorDao getInstance(){
        if (instance == null){
            instance = new ProfessorDaoImpl();
        }
        return instance;
    }

    @Override
    public boolean add(Professor professor) {
        if(jpaProf.findProfessorEntities().contains(professor)){
            return false;
        } else {
            
            jpaProf.create(professor);
            return true;
        }
    }

    @Override
    public boolean delete(Professor professor) {
        if(!(jpaProf.findProfessorEntities().contains(professor))){
            return false;
        }
        try {
            jpaProf.destroy(professor.getId());
        } catch (NonexistentEntityException ex) {
            return false;
        }
        return true;}

    @Override
    public Professor get(int id) {
        return jpaProf.findProfessor(new Long(id));
    }

    @Override
    public List<Professor> get(String nome) {
        return jpaProf.getProfessorByNome(nome);
    }
    
    @Override
    public List<Professor> getAprox(String nome) {
        return jpaProf.getProfessorByNomeAprox(nome);
    }

    @Override
    public List<Professor> get() {
       return jpaProf.findProfessorEntities();
    }

    @Override
    public List<Professor> getCPF(String cpf) {
        return jpaProf.getProfessorByCPF(cpf);
    }

    @Override
    public boolean update(Professor professor) {
        return jpaProf.update(professor);
    }
    
}
