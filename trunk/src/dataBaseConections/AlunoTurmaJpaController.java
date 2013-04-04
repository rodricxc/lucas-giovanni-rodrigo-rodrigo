/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBaseConections;

import dataBaseConections.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.pojo.AlunoTurma;

/**
 *
 * @author rodricxc
 */
public class AlunoTurmaJpaController implements Serializable {

    public AlunoTurmaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AlunoTurma alunoTurma) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alunoTurma);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AlunoTurma alunoTurma) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            alunoTurma = em.merge(alunoTurma);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = alunoTurma.getId();
                if (findAlunoTurma(id) == null) {
                    throw new NonexistentEntityException("The alunoTurma with id " + id + " no longer exists.");
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
            AlunoTurma alunoTurma;
            try {
                alunoTurma = em.getReference(AlunoTurma.class, id);
                alunoTurma.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alunoTurma with id " + id + " no longer exists.", enfe);
            }
            em.remove(alunoTurma);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AlunoTurma> findAlunoTurmaEntities() {
        return findAlunoTurmaEntities(true, -1, -1);
    }

    public List<AlunoTurma> findAlunoTurmaEntities(int maxResults, int firstResult) {
        return findAlunoTurmaEntities(false, maxResults, firstResult);
    }

    private List<AlunoTurma> findAlunoTurmaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AlunoTurma.class));
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

    public AlunoTurma findAlunoTurma(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AlunoTurma.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlunoTurmaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AlunoTurma> rt = cq.from(AlunoTurma.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
