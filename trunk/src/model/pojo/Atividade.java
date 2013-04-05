/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author rodricxc
 */
@Entity
public class Atividade implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    private String tipo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataAtividade;
    private float valor;
    @ManyToOne
    private Turma turma;

    public Atividade() {
    }
    
    public Atividade(String nome, String tipo, Calendar dataAtividade, float valor, Turma turma) {
        this.nome = nome;
        this.tipo = tipo;
        this.dataAtividade = dataAtividade;
        this.valor = valor;
        this.turma = turma;
    }

    public Turma getTurma() {
        return turma;
    }
    
    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.tipo);
        hash = 97 * hash + Objects.hashCode(this.dataAtividade);
        hash = 97 * hash + Float.floatToIntBits(this.valor);
        hash = 97 * hash + Objects.hashCode(this.turma);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atividade other = (Atividade) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.dataAtividade, other.dataAtividade)) {
            return false;
        }
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.turma, other.turma)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return getNome()+"("+getTipo()+")";
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the dataAtividade
     */
    public Calendar getDataAtividade() {
        return dataAtividade;
    }

    /**
     * @param dataAtividade the dataAtividade to set
     */
    public void setDataAtividade(Calendar dataAtividade) {
        this.dataAtividade = dataAtividade;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
}
