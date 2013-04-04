/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import dataBaseConections.AtividadeJpaController;
import dataBaseConections.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import model.pojo.Atividade;
import model.pojo.Turma;

/**
 *
 * @author rodrigo
 */
public class AtividadeDaoImpl implements AtividadeDao {

    private static AtividadeDaoImpl instance = null;
    
    private AtividadeJpaController jpaAtividade = null;
    private AtividadeDaoImpl() {
        jpaAtividade = new AtividadeJpaController(factory);
    }
    
    public static synchronized AtividadeDao getInstance(){
        if (instance == null){
            instance = new AtividadeDaoImpl();
        }
        return instance;
    }
    
    @Override
    public boolean add(Atividade atividade) {
        if (jpaAtividade.findAtividadeEntities().contains(atividade)){
            return false;
        } else {
            jpaAtividade.create(atividade);
            return true;
        }
    }

    @Override
    public boolean delete(Atividade atividade) {
        if (!(jpaAtividade.findAtividadeEntities().contains(atividade))){
            return false;
        }
        try {
            jpaAtividade.destroy(atividade.getId());
        } catch (NonexistentEntityException ex) {
            return false;
        }
        return true;
    }

    @Override
    public Atividade get(int id) {
        return jpaAtividade.findAtividade(new Long(id));
    }

    @Override
    public List<Atividade> get() {
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
    public ArrayList<Atividade> getByTurma(Turma turma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listarPorTurma(Turma turma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
