package com.auction.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

/**
 * @author DOAD-T8
 *
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "Split")
public class Split
{
  @Id
  @Column(name = "SPLITID")
  private int SplitId;

  @Column(name = "LEFTNAME")
  private String leftname;

  @Column(name = "RIGHTNAME")
  private String rightname;
  
  @Column(name = "Prompt")
  private String prompt;

  @Column(name = "SUBLINE1")
  private String subLine1;
  
  @Column(name = "SUBLINE2")
  private String subLine2;
  
  public Split() {
		super();
  }

 

public String getLeftname() {
	return leftname;
}



public void setLeftname(String leftname) {
	this.leftname = leftname;
}



public String getRightname() {
	return rightname;
}



public void setRightname(String rightname) {
	this.rightname = rightname;
}



public String getPrompt() {
	return prompt;
}



public void setPrompt(String prompt) {
	this.prompt = prompt;
}



public String getSubLine1() {
	return subLine1;
}



public void setSubLine1(String subLine1) {
	this.subLine1 = subLine1;
}



public String getSubLine2() {
	return subLine2;
}



public void setSubLine2(String subLine2) {
	this.subLine2 = subLine2;
}



public int getSplitId() {
	return SplitId;
}



public void setSplitId(int splitId) {
	SplitId = splitId;
}

}