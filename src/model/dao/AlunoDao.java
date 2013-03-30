/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.pojo.Aluno;

/**
 *
 * @author rodricxc
 */
public interface AlunoDao {
    static final String PERSISTENCE_UNIT_NAME = "LucasGiovanniRodrigoRodrigo";
    static EntityManagerFactory factory = 
           Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    
    public boolean add(Aluno aluno);
    public boolean delete(Aluno aluno);
    public Aluno get(int id);
    public List<Aluno> get(String nome);
    public List<Aluno> get();
    public Aluno getCPF(String cpf);
    public void listar();
    public void clearAll();
    public boolean isEmpty();
    public boolean hasId(int id);
}
