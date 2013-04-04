/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dataBaseConections.AlunoJpaController;
import dataBaseConections.ProfessorJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.dao.AlunoDao;
import model.dao.AlunoDaoImpl;
import model.dao.DisciplinaDao;
import model.dao.DisciplinaDaoImpl;
import model.dao.ProfessorDao;
import model.dao.ProfessorDaoImpl;
import model.dao.TurmaDao;
import model.dao.TurmaDaoImpl;
import model.pojo.Aluno;
import model.pojo.Disciplina;
import model.pojo.Professor;
import model.pojo.Turma;

/**
 *
 * @author rodricxc
 */
public class MainTeste {
    private static final String PERSISTENCE_UNIT_NAME = "LucasGiovanniRodrigoRodrigo";
    private static EntityManagerFactory factory = 
           Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public static void main(String args[]) {
        
        ProfessorDao professorDao = ProfessorDaoImpl.getInstance();
        Professor prof = new Professor("asdf", "987", "dcomp");
        professorDao.add(prof);
        DisciplinaDao disciplinaDao = DisciplinaDaoImpl.getInstance();
        Disciplina disc = new Disciplina("aeds", "zcxjv", 72);
        disciplinaDao.add(disc);
        
        Disciplina disciplina = disciplinaDao.get().get(0);
        System.out.println(disciplina.getNome());
        Professor professor = professorDao.get().get(0);
        System.out.println(professor.getNome());
        
        TurmaDao turmaDao = TurmaDaoImpl.getInstance();
        
        Turma turma = new Turma(2012, 2, "ctan", "15:25", 60, disciplina, professor);
        turmaDao.add(turma);
        
        turma = turmaDao.get().get(0);
        turma.setLocalAula("csa");
        System.out.println(turmaDao.get().get(0).getLocalAula());
        
/*
        disciplinaDao.add(new Disciplina("GA", "- 1234; -4321; -11", 72));
        disciplinaDao.add(new Disciplina("AOC", "- 11; - poiu", 72));
        
        if (disciplinaDao.add(a)){
            System.out.println("disciplina 'added'");
        } else {
            System.out.println("nao foi possivel adicionar disciplina");
        }
  
  */
        /*
        System.out.println("listagem:\n-----------------------");
        for (Disciplina d : disciplinaDao.get()) {
            System.out.println(d.getNome()+"  "+d.getEmenta()+"  "+d.getEmenta());
        }
        System.out.println("-----------------------");
        
        
        if(disciplinaDao.delete(disciplinaDao.get().get(0))){
            System.out.println("aluno 'deleted'");
        }else{
            System.out.println("nao foi possivel deletar aluno");
        }
        
        
        /*
        AlunoJpaController jpa = new AlunoJpaController(factory);
        ProfessorJpaController jpap = new ProfessorJpaController(factory);
        
        
        
        /*
        System.out.println("listagem:");
        lista = jpa.findAlunoEntities();
        lista2 = jpap.findProfessorEntities();
        jpap.create(p);
        

        
        System.out.println("listagem:\n-----------------------");
        
        for (Aluno al : lista) {
            System.out.println(al.getNome()+"  "+al.getCpf());
        }
        System.out.println("-----------------------");
        
        
        if(!lista.contains(a)){
            jpa.create(a);
            lista = jpa.findAlunoEntities();
            System.out.println("inseriu");
        } else{
            System.out.println("erro, objeto ja inserido");
        }
        
        
       
        System.out.println("listagem:\n-----------------------");
        for (Aluno al : lista) {
            System.out.println(al.getNome()+"  "+al.getCpf());
        }
        System.out.println("-----------------------");
        */
    }
}