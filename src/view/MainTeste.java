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
import model.dao.AlunoTurmaDao;
import model.dao.AlunoTurmaDaoImpl;
import model.dao.DisciplinaDao;
import model.dao.DisciplinaDaoImpl;
import model.dao.ProfessorDao;
import model.dao.ProfessorDaoImpl;
import model.dao.TurmaDao;
import model.dao.TurmaDaoImpl;
import model.pojo.Aluno;
import model.pojo.AlunoTurma;
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
        
        AlunoDao alunoDao = AlunoDaoImpl.getInstance();
        Aluno aluno = new Aluno("a", "1");
        alunoDao.add(aluno);
        aluno = new Aluno("b", "2");
        alunoDao.add(aluno);
        aluno = new Aluno("c", "3");
        alunoDao.add(aluno);
        aluno = new Aluno("d", "4");
        alunoDao.add(aluno);
        
        TurmaDao turmaDao = TurmaDaoImpl.getInstance();
        Turma turma = turmaDao.get().get(0);
        aluno = alunoDao.get().get(0);
        
        AlunoTurmaDao alunoTurmaDao = AlunoTurmaDaoImpl.getInstance();
        
        AlunoTurma alunoTurma = new AlunoTurma(turma, aluno);
        
        if (alunoTurmaDao.add(alunoTurma)) {
            System.out.println("AlunoTurma Inserido");
        } else {
            System.out.println("AlunoTurma NÂO Inserido");
        }
        
        System.out.println("listagem:\n-----------------------");
        for (AlunoTurma at : alunoTurmaDao.get()) {
            System.out.println(at.getAluno().getNome()+"  "+at.getTurma().getLocalAula());
        }
        turma = turmaDao.get().get(0);
        System.out.println(turma.getAlunoTurma().size());
        System.out.println("-----------------------");
        
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
