/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.Calendar;

/**
 *
 * @author rodricxc
 */
public class Atividade {
    private int id;
    private String nome;
    private String tipo;
    private Calendar data;
    private float valor;
    private int turmaId;

    public Atividade(int id, String nome, String tipo, Calendar data, float valor, int turmaId) {	
            this.id = id;
            this.nome = nome;
            this.tipo = tipo;
            this.data = data;
            this.valor = valor;
            this.turmaId = turmaId;	
    }

    public int getId() {
            return id;
    }

    public void setId(int id) {
            this.id = id;
    }

    public String getNome() {
            return nome;
    }


    public String getTipo() {
            return tipo;
    }

    public Calendar getData() {
            return data;
    }

    public float getValor() {
            return valor;
    }


    public int getTurmaId() {
            return turmaId;
    }
    /**
    * Converte o objeto para uma string de modo que ele possa ser 
    * reconstruido com os mesmos valores
    * 
    * Usado na escrita em arquivo
    */
    public String toStringIDs() {
            return String.format("%d\t%s\t%s\t%s\t%s\t%s\t%.2f\t%d", id, nome, tipo,
                            data.get(Calendar.DAY_OF_MONTH), data.get(Calendar.MONTH),
                            data.get(Calendar.YEAR), valor, turmaId);
    }

    @Override
    public String toString() {
            return String.format("ID: %d\tNome: %s\tTipo: %s\tData: %d/%d/%d\tValor: %.2f", id, nome, tipo,
                            data.get(Calendar.DAY_OF_MONTH), data.get(Calendar.MONTH),
                            data.get(Calendar.YEAR), valor);
    }

    public boolean equals(Object o){

    if((o instanceof Atividade) && (((Atividade) o).getId() == this.getId())){
     return true;
    } else {
     return false;
    }
    }    
}
