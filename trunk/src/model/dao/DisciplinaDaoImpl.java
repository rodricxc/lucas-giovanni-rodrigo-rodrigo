/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import dataBaseConections.DisciplinaJpaController;
import dataBaseConections.exceptions.NonexistentEntityException;
import java.util.List;
import model.pojo.Disciplina;

/**
 *aluno
 * @author rodrigo
 */
public class DisciplinaDaoImpl implements DisciplinaDao {

    private static DisciplinaDaoImpl instance = null;
    
    private DisciplinaJpaController jpaDisciplina = null;
    private DisciplinaDaoImpl() {
        jpaDisciplina = new DisciplinaJpaController(factory);        
    }
    
    public static synchronized DisciplinaDao getInstance(){
        if (instance == null){
            instance = new DisciplinaDaoImpl();
        }
        return instance;
    }

    @Override
    public boolean add(Disciplina disciplina) {
        if (jpaDisciplina.findDisciplinaEntities().contains(disciplina)){
            return false;
        } else {
            jpaDisciplina.create(disciplina);
            return true;
        }
    }

    @Override
    public boolean delete(Disciplina disciplina) {
        if(!(jpaDisciplina.findDisciplinaEntities().contains(disciplina))){
            return false;
        }
        try {
            jpaDisciplina.destroy(disciplina.getId());
        } catch (NonexistentEntityException ex) {
            return false;
        }
        return true;
    }

    @Override
    public Disciplina get(int id) {
        return jpaDisciplina.findDisciplina(new Long(id));
    }

    @Override
    public List<Disciplina> get() {
        return jpaDisciplina.findDisciplinaEntities();
    }
    
}
