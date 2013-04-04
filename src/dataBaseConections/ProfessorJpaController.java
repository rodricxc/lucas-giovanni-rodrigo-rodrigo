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
import model.pojo.Professor;

/**
 *
 * @author rodricxc
 */
public class ProfessorJpaController implements Serializable {

    public ProfessorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Professor professor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(professor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Professor professor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            professor = em.merge(professor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = professor.getId();
                if (findProfessor(id) == null) {
                    throw new NonexistentEntityException("The professor with id " + id + " no longer exists.");
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
            Professor professor;
            try {
                professor = em.getReference(Professor.class, id);
                professor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The professor with id " + id + " no longer exists.", enfe);
            }
            em.remove(professor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Professor> findProfessorEntities() {
        return findProfessorEntities(true, -1, -1);
    }

    public List<Professor> findProfessorEntities(int maxResults, int firstResult) {
        return findProfessorEntities(false, maxResults, firstResult);
    }

    private List<Professor> findProfessorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Professor.class));
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

    public Professor findProfessor(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Professor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProfessorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Professor> rt = cq.from(Professor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Professor> getProfessorByNomeAprox(String nome) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("select a from Professor a where a.nome"
                + " like '%"+ nome +"%' order by a.nome");
        return (List<Professor>) query.getResultList();
    }
    
    public List<Professor> getProfessorByNome(String nome) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("select a from Professor a where a.nome"
                + " like '"+ nome +"' order by a.nome");
        return (List<Professor>) query.getResultList();
    }

    public List<Professor> getProfessorByCPF(String cpf) {
        EntityManager em = getEntityManager();
        Query q = em.createQuery("select a from Professor a where a.cpf like '"
                +cpf+"'");
        
        return (List<Professor>) q.getResultList();
    }

    public boolean update(Professor professor) {
        if (this.findProfessorEntities().contains(professor)) {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.merge(professor);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }
    
}
