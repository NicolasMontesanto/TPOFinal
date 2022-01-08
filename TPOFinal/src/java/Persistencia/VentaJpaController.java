/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Cliente;
import Logica.Usuario;
import Logica.Venta;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Nico
 */
public class VentaJpaController implements Serializable {

    public VentaJpaController(EntityManagerFactory emf) {
	this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public VentaJpaController() {
	emf = Persistence.createEntityManagerFactory("TPOFinalPU");
    }
    
    public EntityManager getEntityManager() {
	return emf.createEntityManager();
    }

    public void create(Venta venta) {
	EntityManager em = null;
	try {
	    em = getEntityManager();
	    em.getTransaction().begin();
	    Cliente cliente = venta.getCliente();
	    if (cliente != null) {
		cliente = em.getReference(cliente.getClass(), cliente.getId_persona());
		venta.setCliente(cliente);
	    }
	    Usuario usuario = venta.getUsuario();
	    if (usuario != null) {
		usuario = em.getReference(usuario.getClass(), usuario.getId_usuario());
		venta.setUsuario(usuario);
	    }
	    em.persist(venta);
	    if (cliente != null) {
		cliente.getLista_ventas().add(venta);
		cliente = em.merge(cliente);
	    }
	    if (usuario != null) {
		usuario.getLista_ventas().add(venta);
		usuario = em.merge(usuario);
	    }
	    em.getTransaction().commit();
	} finally {
	    if (em != null) {
		em.close();
	    }
	}
    }

    public void edit(Venta venta) throws NonexistentEntityException, Exception {
	EntityManager em = null;
	try {
	    em = getEntityManager();
	    em.getTransaction().begin();
	    Venta persistentVenta = em.find(Venta.class, venta.getCod_venta());
	    Cliente clienteOld = persistentVenta.getCliente();
	    Cliente clienteNew = venta.getCliente();
	    Usuario usuarioOld = persistentVenta.getUsuario();
	    Usuario usuarioNew = venta.getUsuario();
	    if (clienteNew != null) {
		clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getId_persona());
		venta.setCliente(clienteNew);
	    }
	    if (usuarioNew != null) {
		usuarioNew = em.getReference(usuarioNew.getClass(), usuarioNew.getId_usuario());
		venta.setUsuario(usuarioNew);
	    }
	    venta = em.merge(venta);
	    if (clienteOld != null && !clienteOld.equals(clienteNew)) {
		clienteOld.getLista_ventas().remove(venta);
		clienteOld = em.merge(clienteOld);
	    }
	    if (clienteNew != null && !clienteNew.equals(clienteOld)) {
		clienteNew.getLista_ventas().add(venta);
		clienteNew = em.merge(clienteNew);
	    }
	    if (usuarioOld != null && !usuarioOld.equals(usuarioNew)) {
		usuarioOld.getLista_ventas().remove(venta);
		usuarioOld = em.merge(usuarioOld);
	    }
	    if (usuarioNew != null && !usuarioNew.equals(usuarioOld)) {
		usuarioNew.getLista_ventas().add(venta);
		usuarioNew = em.merge(usuarioNew);
	    }
	    em.getTransaction().commit();
	} catch (Exception ex) {
	    String msg = ex.getLocalizedMessage();
	    if (msg == null || msg.length() == 0) {
		int id = venta.getCod_venta();
		if (findVenta(id) == null) {
		    throw new NonexistentEntityException("The venta with id " + id + " no longer exists.");
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
	    Venta venta;
	    try {
		venta = em.getReference(Venta.class, id);
		venta.getCod_venta();
	    } catch (EntityNotFoundException enfe) {
		throw new NonexistentEntityException("The venta with id " + id + " no longer exists.", enfe);
	    }
	    Cliente cliente = venta.getCliente();
	    if (cliente != null) {
		cliente.getLista_ventas().remove(venta);
		cliente = em.merge(cliente);
	    }
	    Usuario usuario = venta.getUsuario();
	    if (usuario != null) {
		usuario.getLista_ventas().remove(venta);
		usuario = em.merge(usuario);
	    }
	    em.remove(venta);
	    em.getTransaction().commit();
	} finally {
	    if (em != null) {
		em.close();
	    }
	}
    }

    public List<Venta> findVentaEntities() {
	return findVentaEntities(true, -1, -1);
    }

    public List<Venta> findVentaEntities(int maxResults, int firstResult) {
	return findVentaEntities(false, maxResults, firstResult);
    }

    private List<Venta> findVentaEntities(boolean all, int maxResults, int firstResult) {
	EntityManager em = getEntityManager();
	try {
	    CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	    cq.select(cq.from(Venta.class));
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

    public Venta findVenta(int id) {
	EntityManager em = getEntityManager();
	try {
	    return em.find(Venta.class, id);
	} finally {
	    em.close();
	}
    }

    public int getVentaCount() {
	EntityManager em = getEntityManager();
	try {
	    CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	    Root<Venta> rt = cq.from(Venta.class);
	    cq.select(em.getCriteriaBuilder().count(rt));
	    Query q = em.createQuery(cq);
	    return ((Long) q.getSingleResult()).intValue();
	} finally {
	    em.close();
	}
    }
    
}
