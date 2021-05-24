/*
 * I use DAO as query helpers ; passing EntityManager on constructor
 * and my bean classes (Stateless) control these DAOs and my controllers (actions) controls my beans
 * 
*/
package pvt.hob.csi_project.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import pvt.hob.csi_project.model.UserScenario;

public class UserScenarioQueryHelper {

	private EntityManager em;

	public UserScenarioQueryHelper(EntityManager em){
		this.em = em;
	}

	public UserScenario getUsuario(String login, String pass){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<UserScenario> query = builder.createQuery(UserScenario.class);
		Root<UserScenario> from = query.from(UserScenario.class);
		TypedQuery<UserScenario> typedQuery = em.createQuery(
				query.select(from )
				.where(
						builder.and(builder.equal(from.get("login"), login),  builder.equal(from.get("senha"), pass))
						)
				);

		try {
			return (UserScenario) typedQuery.getSingleResult();
		}

		catch (NoResultException | NonUniqueResultException x) { 
			return null;
		} 
	}

}
