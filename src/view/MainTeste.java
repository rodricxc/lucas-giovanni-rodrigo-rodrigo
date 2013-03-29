/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.AlunoJpaController;
import controler.ProfessorJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.pojo.Aluno;
import model.pojo.Professor;

/**
 *
 * @author rodricxc
 */
public class MainTeste {
    private static final String PERSISTENCE_UNIT_NAME = "LucasGiovanniRodrigoRodrigo";
    private static EntityManagerFactory factory = 
           Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME); ;

    public static void main(String args[]) {
        Aluno a = new Aluno("rodrigo", "1231");
        Professor p = new Professor("poo","2123","comp");
        List<Aluno> lista;
        List<Professor> lista2;
        
        AlunoJpaController jpa = new AlunoJpaController(factory);
        ProfessorJpaController jpap = new ProfessorJpaController(factory);
        
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
        
    }
}
