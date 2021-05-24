package pvt.hob.csi_project.controller;

import com.opensymphony.xwork2.Action;

import pvt.hob.csi_project.model.UserScenario;

public class LoginAction extends BaseAction{

	private String login;

	private String senha;


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String login(){
		UserScenario usuario = getLoginService().doLogin(getLogin(), getSenha());
		if (usuario != null) {
			// create session
			getSessionMap().put("Usuario", usuario);
			return "valid";
		}
		else {
			addActionError("INVALID LOGIN / PASSWORD");
			return "invalid";
		}

	}

	public String sessionTest(){
		System.out.println("LoginAction : sessionTest: \n Login Interceptor");
		UserScenario userLogin = (UserScenario) this.getSessionMap().get("Usuario");
		System.out.println("User Login: "+userLogin);
		return "success";
	}


	public String logout(){
		UserScenario userLogOut = (UserScenario) this.getSessionMap().get("Usuario");
		System.out.println("LoginAction : logout: \nEfetuando LOGOUT Usuario : "+userLogOut);
		this.getSessionMap().remove("Usuario");
		return Action.SUCCESS;
	}
}
