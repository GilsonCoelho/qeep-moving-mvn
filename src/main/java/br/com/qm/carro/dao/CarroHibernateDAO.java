package br.com.qm.carro.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import br.com.qm.carro.pojo.CarroHibernate;

public class CarroHibernateDAO {
	
	private EntityManager em;

	public CarroHibernateDAO(EntityManager em) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("carros");
		this.em = factory.createEntityManager();
		
	}
	
	public CarroHibernateDAO() {
		
	}

	public boolean insereCarro(CarroHibernate carro) {
		
		em.getTransaction().begin();
		em.persist(carro);
		em.getTransaction().commit();		
		
		return true;
	}
	
	public boolean removeCarro(String placa) {
		
		CarroHibernate carro = em.find(CarroHibernate.class, placa);
		
		if (carro == null) {
			return false;
		}
		em.getTransaction().begin();
		em.remove(carro);
		em.getTransaction().commit();
		
		return true;
	}
	
	public CarroHibernate consultaCarro(String placa) {
		return em.find(CarroHibernate.class, placa);
		
	}
	
	public boolean alteraCarro(CarroHibernate carro) {
		
		CarroHibernate carroDB = em.find(CarroHibernate.class, carro.getPlaca());
		carroDB.setCor(carro.getCor());
		carroDB.setModelo(carro.getModelo());
		carroDB.setMarca(carro.getMarca());
		carroDB.setAno(carro.getAno());
		carroDB.setVelMax(carro.getVelMax());
		
		em.getTransaction().begin();
		em.merge(carroDB);
		em.getTransaction().commit();
		
		return true;
	}
	
	
	public List<CarroHibernate> listarCarros(){
		
		Query query = em.createQuery("select c from CarroHibernate as c");
		
		return query.getResultList();
	}

	
	
	
}
