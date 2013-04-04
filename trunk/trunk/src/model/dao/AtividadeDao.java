/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.pojo.Atividade;
import model.pojo.Turma;

public interface AtividadeDao {
    static final String PERSISTENCE_UNIT_NAME = "LucasGiovanniRodrigoRodrigo";
    static EntityManagerFactory factory = 
           Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    
    public boolean add(Atividade atividade);
    public boolean delete(Atividade atividade);
    public Atividade get(int id);
    public List<Atividade> get();
    public ArrayList<Atividade> getByTurma(Turma turma);
    public void listarPorTurma(Turma turma);
    public boolean hasId(int id);

}
