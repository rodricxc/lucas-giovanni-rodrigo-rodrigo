/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AlunoJpaController;
import controller.ProfessorJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.dao.AlunoDao;
import model.dao.AlunoDaoImpl;
import model.pojo.Aluno;
import model.pojo.Professor;

/**
 *
 * @author rodricxc
 */
public class MainTeste {
    private static final String PERSISTENCE_UNIT_NAME = "LucasGiovanniRodrigoRodrigo";
    private static EntityManagerFactory factory = 
           Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public static void main(String args[]) {
        Aluno a = new Aluno("rodrigo", "131");
        Professor p = new Professor("poo","2123","comp");
        List<Aluno> lista;
        List<Professor> lista2;
        
        
        
        
        AlunoDao aDao = AlunoDaoImpl.getInstance();
        AlunoDao aDao2 = AlunoDaoImpl.getInstance();
        
        aDao.add(new Aluno("rodogildo", "11111"));
        aDao.add(new Aluno("rodolfo", "11"));
        aDao.add(new Aluno("carlosrod", "2211"));
        aDao.add(new Aluno("rodrigo", "21"));
        aDao.add(new Aluno("gildo", "222"));
        aDao.add(new Aluno("carlos", "77668711"));
        
        
        if(aDao.add(a)){
            System.out.println("aluno 'added'");
        }else{
            System.out.println("nao foi possivel adicionar aluno");
        }
        
        
        System.out.println("listagem:\n-----------------------");
        for (Aluno al : aDao.get()) {
            System.out.println(al.getNome()+"  "+al.getCpf());
        }
        System.out.println("-----------------------");
        
        /*
        if(aDao.delete(a)){
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
