package pvt.hob.csi_project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class UserScenario {

	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name = "id", unique = true, nullable = false, precision = 15, scale = 0)
	@Id
	private int id;
	
	private String login;
	
	private String name;

	private String scenario;
	
	
	
	public String getScenario() {
		return scenario;
	}

	public void setScenario(String senha) {
		this.scenario = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}
	
	@Override
	public String toString(){
		return "[User: id = "+id+" ; nome = "+name+" ; login = "+login+"]";
	}
	
	

}
