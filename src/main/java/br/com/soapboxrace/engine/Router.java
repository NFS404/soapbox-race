package br.com.soapboxrace.engine;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.server.Request;

import br.com.soapboxrace.bo.SessionBO;

public class Router {

	private String target;

	private HttpServletRequest request;

	private Request baseRequest;

	protected String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	protected HttpServletRequest getRequest() {
		return request;
	}

	protected String getParam(String param) {
		return baseRequest.getParameter(param);
	}

	protected String getHeader(String param) {
		return request.getHeader(param);
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setBaseRequest(Request baseRequest) {
		this.baseRequest = baseRequest;
	}

	protected String readInputStream() {
		StringBuilder buffer = new StringBuilder();
		try {
			BufferedReader reader = request.getReader();
			String line;
			while ((line = reader.readLine()) != null)
				buffer.append(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	protected Long getLoggedPersonaId() {
		SessionBO sessionBO = new SessionBO();
		Long loggedPersonaId = sessionBO.getLoggedPersonaId(getSecurityToken(), getUserId());
		if(loggedPersonaId == 0){
			System.out.println("==================================");
			System.out.println("debug personaId");
			System.out.println("userId [" + getUserId() + "]");
			System.out.println("securitToken [" + getSecurityToken() + "]");
			System.out.println("loggedPersonaId [" + loggedPersonaId + "]");
			System.out.println("==================================");
		}
		return loggedPersonaId;
	}

	protected String getSecurityToken() {
		return getHeader("securityToken");
	}

	protected Long getUserId() {
		String header = getHeader("userId");
		if (header == null) {
			header = "0";
		}
		return Long.valueOf(header);
	}

}
