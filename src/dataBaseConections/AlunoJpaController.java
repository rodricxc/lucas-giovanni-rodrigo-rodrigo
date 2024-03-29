/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBaseConections;

import dataBaseConections.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.pojo.Aluno;
import model.pojo.Usuario;

/**
 *
 * @author rodricxc
 */
public class AlunoJpaController implements Serializable {

    public AlunoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aluno aluno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Aluno aluno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            aluno = em.merge(aluno);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = aluno.getId();
                if (findAluno(id) == null) {
                    throw new NonexistentEntityException("The aluno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aluno aluno;
            try {
                aluno = em.getReference(Aluno.class, id);
                aluno.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The aluno with id " + id + " no longer exists.", enfe);
            }
            em.remove(aluno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Aluno> findAlunoEntities() {
        return findAlunoEntities(true, -1, -1);
    }

    public List<Aluno> findAlunoEntities(int maxResults, int firstResult) {
        return findAlunoEntities(false, maxResults, firstResult);
    }

    private List<Aluno> findAlunoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Aluno.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Aluno findAluno(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aluno.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlunoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Aluno> rt = cq.from(Aluno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Aluno> getAlunoByCPF(String cpf) {
        EntityManager em = getEntityManager();
        Query q = em.createQuery("select a from Aluno a where a.cpf like '"+cpf+"'");
       // List<Aluno> results = (List<Aluno>) q.getResultList();
        
        return (List<Aluno>) q.getResultList();
    }
    
    public List<Aluno> getAlunoByNome(String nome) {
        EntityManager em = getEntityManager();
        //Query q = em.createQuery("SELECT * FROM ALUNO WHERE NOME='"+nome+"'");
        //List<Aluno> results = (List<Aluno>) q.getResultList();
        Query query = em.createQuery("select a from Aluno a where a.nome like '"+
                nome +"' order by a.nome");
        return (List<Aluno>) query.getResultList();
    }
    
    public List<Aluno> getAlunoByNomeAprox(String nome) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("select a from Aluno a where a.nome like '%"+
                nome +"%'  order by a.nome");
        return (List<Aluno>) query.getResultList();
    }
    
    public boolean update(Aluno aluno) {
        if (this.findAlunoEntities().contains(aluno)) {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }
    
}
