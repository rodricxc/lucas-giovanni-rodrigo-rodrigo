/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

/**
 *
 * @author rodricxc
 */
public class NotaAtividade {
    private int id;
    private Atividade atividade;
    private float nota;

    public NotaAtividade( Atividade at) {
            this.atividade = at;
            this.nota = 0;
    }
    public NotaAtividade(Atividade at, float nota) {
            this(at);
            this.nota = nota;
    }

    public int getId() {
            return id;
    }
    public Atividade getAtividade() {
            return atividade;
    }
    public float getNota() {
            return nota;
    }
    public void setNota(float nota) {
            this.nota = nota;
    }
}
