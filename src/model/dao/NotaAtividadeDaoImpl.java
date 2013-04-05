/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import dataBaseConections.NotaAtividadeJpaController;
import dataBaseConections.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import model.pojo.Atividade;
import model.pojo.NotaAtividade;

/**
 *
 * @author rodrigo
 */
public class NotaAtividadeDaoImpl implements NotaAtividadeDao {

    private static NotaAtividadeDaoImpl instance = null;
    
    private NotaAtividadeJpaController jpaNotaAtividade = null;
    private Object NotaAtividade;
    private NotaAtividadeDaoImpl() {
        jpaNotaAtividade = new NotaAtividadeJpaController(factory);        
    }
    
    public static synchronized NotaAtividadeDao getInstance(){
        if (instance == null){
            instance = new NotaAtividadeDaoImpl();
        }
        return instance;
    }
    @Override
    public boolean add(NotaAtividade notaAtividade) {
        if(jpaNotaAtividade.findNotaAtividadeEntities().contains(notaAtividade)){
            return false;
        }else{
            jpaNotaAtividade.create(notaAtividade);
            return true;
        }
    }

    @Override
    public boolean delete(NotaAtividade notaAtividade) {
        if(!(jpaNotaAtividade.findNotaAtividadeEntities().contains(notaAtividade))){
            return false;
        }
        try {
            jpaNotaAtividade.destroy(notaAtividade.getId());
        } catch (NonexistentEntityException ex) {
            return false;
        }
        return true;
    }

    @Override
    public NotaAtividade getById(int id) {
        return jpaNotaAtividade.findNotaAtividade(new Long(id));
    }

    @Override
    public List<NotaAtividade> getByAtividade(Atividade atividade) {
        List<NotaAtividade> lista = jpaNotaAtividade.findNotaAtividadeEntities();
        List<NotaAtividade> retorno = new ArrayList<>();
        for (NotaAtividade notaAtividade : lista) {
            if(notaAtividade.getAtividade().equals(atividade)){
                retorno.add(notaAtividade);
            }
        }
        return retorno;
    }

    @Override
    public void clearAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
