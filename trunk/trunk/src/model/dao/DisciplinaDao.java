/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.pojo.Disciplina;
import model.pojo.Turma;

public interface DisciplinaDao {
    static final String PERSISTENCE_UNIT_NAME = "LucasGiovanniRodrigoRodrigo";
    static EntityManagerFactory factory = 
           Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    
    public boolean add(Disciplina disciplina);
    public boolean delete(Disciplina disciplina);
    public Disciplina get(int id);
    public List<Disciplina> get();

    public boolean update(Disciplina disciplina);
}
