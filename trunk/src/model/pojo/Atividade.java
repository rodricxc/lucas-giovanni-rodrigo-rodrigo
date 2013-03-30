/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import java.util.Calendar;
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

    public Atividade(String nome, String tipo, Calendar dataAtividade, float valor, Turma turma) {
        this.nome = nome;
        this.tipo = tipo;
        this.dataAtividade = dataAtividade;
        this.valor = valor;
        this.turma = turma;
    }

    public Atividade() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atividade)) {
            return false;
        }
        Atividade other = (Atividade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.dao.Atividade[ id=" + id + " ]";
    }
    
}
