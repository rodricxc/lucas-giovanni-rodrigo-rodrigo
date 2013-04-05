/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.pojo.Atividade;
import model.pojo.NotaAtividade;

public interface NotaAtividadeDao {
    static final String PERSISTENCE_UNIT_NAME = "LucasGiovanniRodrigoRodrigo";
    static EntityManagerFactory factory = 
           Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    
    public boolean add(NotaAtividade registroAtividade);
    public boolean delete(NotaAtividade registroAtividade);
    public boolean update(NotaAtividade registroAtividade);
    public NotaAtividade getById(int id);
    public List<NotaAtividade> getByAtividade(Atividade atividade);
}
