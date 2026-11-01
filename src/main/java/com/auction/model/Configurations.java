package com.auction.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Configurations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Configurations {
	
	@XmlElement(name="filename")
	private String filename;
	
	@XmlElement(name="broadcaster")
	private String broadcaster;
	
	@XmlElement(name="sponsor")
	private String sponsor;
	
	@XmlElement(name="ipAddress")
	private String ipAddress;
	
	@XmlElement(name="portNumber")
	private int portNumber;
	
	@XmlElement(name="vizscene")
	private String vizscene;
	
	@XmlElement(name="secondaryipAddress")
	private String secondaryipAddress;
	
	@XmlElement(name="secondaryportNumber")
	private int secondaryportNumber;
	
	@XmlElement(name="tertiaryipAddress")
	private String tertiaryipAddress;
	
	@XmlElement(name="tertiaryportNumber")
	private int tertiaryportNumber;

	public Configurations(String filename, String broadcaster, 
			String sponsor, String ipAddress, int portNumber, String vizscene) {
		super();
		this.filename = filename;
		this.broadcaster = broadcaster;
		this.sponsor = sponsor;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
		this.vizscene = vizscene;
	}
	
	public Configurations(String broadcaster, String ipAddress, int portNumber, String secondaryipAddress,
			int secondaryportNumber) {
		super();
		this.broadcaster = broadcaster;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
		this.secondaryipAddress = secondaryipAddress;
		this.secondaryportNumber = secondaryportNumber;
	}
	
	public Configurations(String broadcaster, String ipAddress, int portNumber, String secondaryipAddress,
			int secondaryportNumber, String tertiaryipAddress, int tertiaryportNumber) {
		super();
		this.broadcaster = broadcaster;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
		this.secondaryipAddress = secondaryipAddress;
		this.secondaryportNumber = secondaryportNumber;
		this.tertiaryipAddress = tertiaryipAddress;
		this.tertiaryportNumber = tertiaryportNumber;
	}

	public Configurations() {
		super();
	}

	public String getVizscene() {
		return vizscene;
	}
	public void setVizscene(String vizscene) {
		this.vizscene = vizscene;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getBroadcaster() {
		return broadcaster;
	}
	public void setBroadcaster(String broadcaster) {
		this.broadcaster = broadcaster;
	}
	public String getSponsor() {
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	public int getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getSecondaryipAddress() {
		return secondaryipAddress;
	}
	public void setSecondaryipAddress(String secondaryipAddress) {
		this.secondaryipAddress = secondaryipAddress;
	}
	public int getSecondaryportNumber() {
		return secondaryportNumber;
	}
	public void setSecondaryportNumber(int secondaryportNumber) {
		this.secondaryportNumber = secondaryportNumber;
	}

	public String getTertiaryipAddress() {
		return tertiaryipAddress;
	}

	public void setTertiaryipAddress(String tertiaryipAddress) {
		this.tertiaryipAddress = tertiaryipAddress;
	}

	public int getTertiaryportNumber() {
		return tertiaryportNumber;
	}

	public void setTertiaryportNumber(int tertiaryportNumber) {
		this.tertiaryportNumber = tertiaryportNumber;
	}
	
}
