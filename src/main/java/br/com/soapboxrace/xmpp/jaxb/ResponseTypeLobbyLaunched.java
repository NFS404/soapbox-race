package br.com.soapboxrace.xmpp.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseTypeLobbyLaunched", propOrder = { "lobbyInvite" })
@XmlRootElement(name = "response")
public class ResponseTypeLobbyLaunched {

	@XmlElement(name = "LobbyLaunched", required = true)
	protected LobbyLaunchedType lobbyInvite;
	@XmlAttribute(name = "status")
	protected int status = 1;
	@XmlAttribute(name = "ticket")
	protected int ticket = 0;

	public LobbyLaunchedType getLobbyInvite() {
		return lobbyInvite;
	}

	public void setLobbyInvite(LobbyLaunchedType lobbyInvite) {
		this.lobbyInvite = lobbyInvite;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

}