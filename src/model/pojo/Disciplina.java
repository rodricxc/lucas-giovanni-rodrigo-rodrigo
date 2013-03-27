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
public class Disciplina {
    private int id;
    private String nome;
    private String ementa;
    private int cargaHoraria;

    List<Integer> turmas;

    public Disciplina(int id, String nome, String ementa, int cargaHoraria) {
            this.id = id;
            this.nome = nome;
            this.ementa = ementa;
            this.cargaHoraria = cargaHoraria;
            this.turmas = new ArrayList<>();
    }

    public Disciplina(int id, String nome, String ementa, int cargaHoraria,
                    List<Integer> turmas) {
            this(id, nome, ementa, cargaHoraria);
            this.turmas = turmas;
    }

    public int getId() {
            return id;
    }

    public String getNome() {
            return nome;
    }

    public String getEmenta() {
            return ementa;
    }

    public int getCargaHoraria() {
            return cargaHoraria;
    }
    /**
    * Converte o objeto para uma string de modo que ele possa ser 
    * reconstruido com os mesmos valores
    * 
    * Usado na escrita em arquivo
    */
    public String toStringIDs(){
            int nTurmas = this.turmas.size();
            String sTurmas = new String();
            for (int i = 0; i < this.turmas.size(); i++) {
                    sTurmas += "\t" + this.turmas.get(i);
            }
            return String.format("%d\t%s\t%s\t%d\t%d%s", id, nome, ementa, cargaHoraria, nTurmas, sTurmas);
    }

    @Override
    public String toString() {
            return String.format("ID: %d \tNome: %s\tEmenta:\t%s\tCarga Horaria: %d", id, nome, ementa, cargaHoraria);
    }
    /**
    * Converte o objeto para uma string para visualizaçao do usuario
    * 
    * Usado nas listagens
    */
    public String toStringSemEmenta() {
            return String.format("ID: %d \tNome: %s\tCarga Horaria: %d", id, nome, cargaHoraria);
    }

    @Override
    public boolean equals(Object o){

     if((o instanceof Disciplina) && (((Disciplina)o).getNome().equals(this.getNome()))){
             return true;
     } else {
             return false;
     }
    }
}
