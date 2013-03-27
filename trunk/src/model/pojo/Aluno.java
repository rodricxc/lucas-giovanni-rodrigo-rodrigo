/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author rodricxc
 */
public class Aluno extends Usuario {
    private List<Integer> listaAlunoTurmas;

    public Aluno(int id, String nome, String cpf) {
            super(nome, cpf);
            super.setId(id);
            this.listaAlunoTurmas = new ArrayList<>();
    }
    public Aluno(int id, String nome, String cpf, List<Integer> regTurmas){
            this(id, nome, cpf);
            this.listaAlunoTurmas = regTurmas;
    }
    /**
    * Converte o objeto para uma string de modo que ele possa ser 
    * reconstruido com os mesmos valores
    * 
    * Usado na escrita em arquivo
    */
    public String toStringIDs(){
            int nTurmas = this.listaAlunoTurmas.size();
            String sTurmas = new String();
            for (int i = 0; i < this.listaAlunoTurmas.size(); i++) {
                    sTurmas += "\t" + this.listaAlunoTurmas.get(i);
            }
            return String.format("%d\t%s\t%s\t%d%s", getId(), getNome(), getCpf(), nTurmas, sTurmas);
    }	
    @Override
    public String toString(){
            return String.format("ID: %d\tNome: %s\tCPF: %s", getId(), getNome(), getCpf());
    }
    @Override
    public int getId() {
            return super.getId();
    }	
    @Override
    public boolean equals(Object o){

     if((o instanceof Aluno) && (((Aluno)o).getCpf().equals(this.getCpf()))){
             return true;
     } else {
             return false;
     }
    }
    /**
    * Adiciona novo Registro relativo a matricula em uma turma no objeto 
    */
    public boolean addRegistro(int regID){
            listaAlunoTurmas.add(new Integer(regID));
            return false;
    }
}
