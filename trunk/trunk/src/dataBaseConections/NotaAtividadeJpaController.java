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
import model.pojo.NotaAtividade;

/**
 *
 * @author rodricxc
 */
public class NotaAtividadeJpaController implements Serializable {

    public NotaAtividadeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(NotaAtividade notaAtividade) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(notaAtividade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(NotaAtividade notaAtividade) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            notaAtividade = em.merge(notaAtividade);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = notaAtividade.getId();
                if (findNotaAtividade(id) == null) {
                    throw new NonexistentEntityException("The notaAtividade with id " + id + " no longer exists.");
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
            NotaAtividade notaAtividade;
            try {
                notaAtividade = em.getReference(NotaAtividade.class, id);
                notaAtividade.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The notaAtividade with id " + id + " no longer exists.", enfe);
            }
            em.remove(notaAtividade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<NotaAtividade> findNotaAtividadeEntities() {
        return findNotaAtividadeEntities(true, -1, -1);
    }

    public List<NotaAtividade> findNotaAtividadeEntities(int maxResults, int firstResult) {
        return findNotaAtividadeEntities(false, maxResults, firstResult);
    }

    private List<NotaAtividade> findNotaAtividadeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(NotaAtividade.class));
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

    public NotaAtividade findNotaAtividade(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(NotaAtividade.class, id);
        } finally {
            em.close();
        }
    }

    public int getNotaAtividadeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<NotaAtividade> rt = cq.from(NotaAtividade.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
