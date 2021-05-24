package pvt.hob.csi_project.business;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pvt.hob.csi_project.dao.UserScenarioQueryHelper;
import pvt.hob.csi_project.model.UserScenario;

@Stateless(mappedName = "LoginService")
public class LoginService {

	@PersistenceContext(unitName="primary")
	private EntityManager em;

	private UserScenarioQueryHelper userQueryHelper;

	// here I initialize the UsuarioQueryHelper with the EntityManager 
	// and guarantee it only create one instance 
	// per bean . I always execute ensureHelper first of all querys. The
	// idea is consume EntityManager in Helpers classes
	private UserScenarioQueryHelper ensureHelper(){
		if (userQueryHelper == null) {
			this.userQueryHelper = new UserScenarioQueryHelper(em);
		}
		return this.userQueryHelper;
	}



	/*
	 * do login ; return not null for success
	 * @param String login
	 * @param String pass
	 * @return Usuario
	 */
	public UserScenario doLogin(String login, String pass){
		UserScenario usuario = ensureHelper().getUsuario(login, pass);
		if (usuario == null) {return null;}
		else {
			return usuario;
		}
	}

	public void createFirst(){
		System.out.println("\n\n\n CREATING USER TO CHECK ALL STUFFS!");
		UserScenario usuario = new UserScenario();
		usuario.setLogin("test"); // login
		usuario.setNome("Fulano Teste");
		usuario.setScenario("123"); // password
		getEm().persist(usuario);
		
		System.out.println("LoginService : createFirst : \n\n\n YOU CAN LOGIN FOR TEST "+usuario.getLogin() + " " + usuario.getScenario());
		System.out.println("********************************** IMPORTANT MESSAGE **********************************");
		System.out.println("*******************REMOVE createFirst() METHOD AND DELETE USER*******************");
		System.out.println("********************************** IMPORTANT MESSAGE **********************************");
	}


	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}



}
