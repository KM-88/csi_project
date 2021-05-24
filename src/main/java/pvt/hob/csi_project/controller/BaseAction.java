/*
 * Classe Base apra todas as Actions. 
 * 
 * Possue sistema de persistencia para as actions compartilharem objetos entre sis
 * e manter persistencia de informacoes sem ser no banco de dados.
 * 
*/
package pvt.hob.csi_project.controller;

import java.util.Map;

import javax.inject.Inject;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import pvt.hob.csi_project.business.LoginService;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport implements SessionAware{

	@Inject
	private LoginService loginService;
	
	private static final long serialVersionUID = 1L;

	private SessionMap<String,Object> sessionMap;
	
	
	/* method to get sessions
	*/
	@Override
	public void setSession(Map<String, Object> session) {
	    sessionMap = (SessionMap) session; 
	}
	
	public SessionMap getSessionMap(){
		return this.sessionMap;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}
