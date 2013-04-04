/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.pojo.Professor;

/**
 *
 * @author rodricxc
 */
public interface ProfessorDao {
    static final String PERSISTENCE_UNIT_NAME = "LucasGiovanniRodrigoRodrigo";
    static EntityManagerFactory factory = 
           Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    
    public boolean add(Professor professor);
    public boolean delete(Professor professor);
    public Professor get(int id);
    public List<Professor> get(String nome);
    public List<Professor> getAprox(String nome);
    public List<Professor> get();
    public List<Professor> getCPF(String cpf);
    public void listar();
    public void clearAll();
    public boolean isEmpty();
    public boolean hasId(int id);

    public boolean update(Professor professor);
    
}
