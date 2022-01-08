/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.PaqueteTuristico;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.ServicioTuristico;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Nico
 */
public class PaqueteTuristicoJpaController implements Serializable {

    public PaqueteTuristicoJpaController(EntityManagerFactory emf) {
	this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public PaqueteTuristicoJpaController() {
	emf = Persistence.createEntityManagerFactory("TPOFinalPU");
    }
    
    public EntityManager getEntityManager() {
	return emf.createEntityManager();
    }

    public void create(PaqueteTuristico paqueteTuristico) {
	if (paqueteTuristico.getLista_servicios() == null) {
	    paqueteTuristico.setLista_servicios(new ArrayList<ServicioTuristico>());
	}
	EntityManager em = null;
	try {
	    em = getEntityManager();
	    em.getTransaction().begin();
	    List<ServicioTuristico> attachedLista_servicios = new ArrayList<ServicioTuristico>();
	    for (ServicioTuristico lista_serviciosServicioTuristicoToAttach : paqueteTuristico.getLista_servicios()) {
		lista_serviciosServicioTuristicoToAttach = em.getReference(lista_serviciosServicioTuristicoToAttach.getClass(), lista_serviciosServicioTuristicoToAttach.getCod_servicio());
		attachedLista_servicios.add(lista_serviciosServicioTuristicoToAttach);
	    }
	    paqueteTuristico.setLista_servicios(attachedLista_servicios);
	    em.persist(paqueteTuristico);
	    for (ServicioTuristico lista_serviciosServicioTuristico : paqueteTuristico.getLista_servicios()) {
		lista_serviciosServicioTuristico.getLista_paquetes().add(paqueteTuristico);
		lista_serviciosServicioTuristico = em.merge(lista_serviciosServicioTuristico);
	    }
	    em.getTransaction().commit();
	} finally {
	    if (em != null) {
		em.close();
	    }
	}
    }

    public void edit(PaqueteTuristico paqueteTuristico) throws NonexistentEntityException, Exception {
	EntityManager em = null;
	try {
	    em = getEntityManager();
	    em.getTransaction().begin();
	    PaqueteTuristico persistentPaqueteTuristico = em.find(PaqueteTuristico.class, paqueteTuristico.getCod_paquete());
	    List<ServicioTuristico> lista_serviciosOld = persistentPaqueteTuristico.getLista_servicios();
	    List<ServicioTuristico> lista_serviciosNew = paqueteTuristico.getLista_servicios();
	    List<ServicioTuristico> attachedLista_serviciosNew = new ArrayList<ServicioTuristico>();
	    for (ServicioTuristico lista_serviciosNewServicioTuristicoToAttach : lista_serviciosNew) {
		lista_serviciosNewServicioTuristicoToAttach = em.getReference(lista_serviciosNewServicioTuristicoToAttach.getClass(), lista_serviciosNewServicioTuristicoToAttach.getCod_servicio());
		attachedLista_serviciosNew.add(lista_serviciosNewServicioTuristicoToAttach);
	    }
	    lista_serviciosNew = attachedLista_serviciosNew;
	    paqueteTuristico.setLista_servicios(lista_serviciosNew);
	    paqueteTuristico = em.merge(paqueteTuristico);
	    for (ServicioTuristico lista_serviciosOldServicioTuristico : lista_serviciosOld) {
		if (!lista_serviciosNew.contains(lista_serviciosOldServicioTuristico)) {
		    lista_serviciosOldServicioTuristico.getLista_paquetes().remove(paqueteTuristico);
		    lista_serviciosOldServicioTuristico = em.merge(lista_serviciosOldServicioTuristico);
		}
	    }
	    for (ServicioTuristico lista_serviciosNewServicioTuristico : lista_serviciosNew) {
		if (!lista_serviciosOld.contains(lista_serviciosNewServicioTuristico)) {
		    lista_serviciosNewServicioTuristico.getLista_paquetes().add(paqueteTuristico);
		    lista_serviciosNewServicioTuristico = em.merge(lista_serviciosNewServicioTuristico);
		}
	    }
	    em.getTransaction().commit();
	} catch (Exception ex) {
	    String msg = ex.getLocalizedMessage();
	    if (msg == null || msg.length() == 0) {
		int id = paqueteTuristico.getCod_paquete();
		if (findPaqueteTuristico(id) == null) {
		    throw new NonexistentEntityException("The paqueteTuristico with id " + id + " no longer exists.");
		}
	    }
	    throw ex;
	} finally {
	    if (em != null) {
		em.close();
	    }
	}
    }

    public void destroy(int id) throws NonexistentEntityException {
	EntityManager em = null;
	try {
	    em = getEntityManager();
	    em.getTransaction().begin();
	    PaqueteTuristico paqueteTuristico;
	    try {
		paqueteTuristico = em.getReference(PaqueteTuristico.class, id);
		paqueteTuristico.getCod_paquete();
	    } catch (EntityNotFoundException enfe) {
		throw new NonexistentEntityException("The paqueteTuristico with id " + id + " no longer exists.", enfe);
	    }
	    List<ServicioTuristico> lista_servicios = paqueteTuristico.getLista_servicios();
	    for (ServicioTuristico lista_serviciosServicioTuristico : lista_servicios) {
		lista_serviciosServicioTuristico.getLista_paquetes().remove(paqueteTuristico);
		lista_serviciosServicioTuristico = em.merge(lista_serviciosServicioTuristico);
	    }
	    em.remove(paqueteTuristico);
	    em.getTransaction().commit();
	} finally {
	    if (em != null) {
		em.close();
	    }
	}
    }

    public List<PaqueteTuristico> findPaqueteTuristicoEntities() {
	return findPaqueteTuristicoEntities(true, -1, -1);
    }

    public List<PaqueteTuristico> findPaqueteTuristicoEntities(int maxResults, int firstResult) {
	return findPaqueteTuristicoEntities(false, maxResults, firstResult);
    }

    private List<PaqueteTuristico> findPaqueteTuristicoEntities(boolean all, int maxResults, int firstResult) {
	EntityManager em = getEntityManager();
	try {
	    CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	    cq.select(cq.from(PaqueteTuristico.class));
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

    public PaqueteTuristico findPaqueteTuristico(int id) {
	EntityManager em = getEntityManager();
	try {
	    return em.find(PaqueteTuristico.class, id);
	} finally {
	    em.close();
	}
    }

    public int getPaqueteTuristicoCount() {
	EntityManager em = getEntityManager();
	try {
	    CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	    Root<PaqueteTuristico> rt = cq.from(PaqueteTuristico.class);
	    cq.select(em.getCriteriaBuilder().count(rt));
	    Query q = em.createQuery(cq);
	    return ((Long) q.getSingleResult()).intValue();
	} finally {
	    em.close();
	}
    }
    
}
