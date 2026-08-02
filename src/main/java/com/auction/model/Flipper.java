package com.auction.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.ToStringStyle;
import jakarta.persistence.Column;

@SuppressWarnings("unused")
@Entity
@Table(name = "Flipper")
public class Flipper
{
  @Id
  @Column(name = "FlipperId")
  private int flipperId;

  @Column(name = "Prompt")
  private String prompt;

  @Column(name = "HEADER")
  private String header;
  
  @Column(name = "SUBLINE")
  private String subLine;
  
  @Column(name = "LOGO")
  private String logo;
  
  public Flipper() {
		super();
  }

public int getFlipperId() {
	return flipperId;
}

public void setFlipperId(int flipperId) {
	this.flipperId = flipperId;
}

public String getPrompt() {
	return prompt;
}

public void setPrompt(String prompt) {
	this.prompt = prompt;
}

public String getHeader() {
	return header;
}

public void setHeader(String header) {
	this.header = header;
}

public String getSubLine() {
	return subLine;
}

public void setSubLine(String subLine) {
	this.subLine = subLine;
}

public String getLogo() {
	return logo;
}

public void setLogo(String logo) {
	this.logo = logo;
}

}