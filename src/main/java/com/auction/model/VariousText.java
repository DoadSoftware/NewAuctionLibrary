package com.auction.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@SuppressWarnings("unused")
@Entity
@Table(name = "VariousText")
public class VariousText
{
  @Id
  @Column(name = "HeaderID")
  private int headerID;

  @Column(name = "Prompt")
  private String prompt;
  
  @Column(name = "VariousType")
  private String variousType;
  
  @Column(name = "UseThis")
  private String useThis;

  public int getHeaderID() {
	return headerID;
}

  public void setHeaderID(int headerID) {
	this.headerID = headerID;
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

  public String getSubheader() {
	return subheader;
  }

  public void setSubheader(String subheader) {
	this.subheader = subheader;
  }

  public String getVariousType() {
	return variousType;
}

  public void setVariousType(String variousType) {
	this.variousType = variousType;
  }

  public String getUseThis() {
	return useThis;
}

  public void setUseThis(String useThis) {
	this.useThis = useThis;
  }


  @Column(name = "Header")
  private String header;
  
  @Column(name = "Subheader")
  private String subheader;

  public VariousText() {
		super();
  }


}