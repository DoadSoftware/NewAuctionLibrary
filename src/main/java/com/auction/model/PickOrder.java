package com.auction.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "PickOrder")
public class PickOrder {

  @Id
  @Column(name = "PickId")
  private int pickId;

  @Column(name = "PickRound")
  private String pickRound;

  @Column(name = "PickTeam1") 
  private Integer pickTeam1;
  
  @Column(name = "PickTeam2") 
  private Integer pickTeam2;
  
  @Column(name = "PickTeam3") 
  private Integer pickTeam3;
  
  @Column(name = "PickTeam4") 
  private Integer pickTeam4;
  
  @Column(name = "PickTeam5") 
  private Integer pickTeam5;

  public int getPickId() {
	return pickId;
  }

  public void setPickId(int pickId) {
	this.pickId = pickId;
  }

  public String getPickRound() {
	return pickRound;
  }

  public void setPickRound(String pickRound) {
	this.pickRound = pickRound;
  }

  public Integer getPickTeam1() {
	return pickTeam1;
  }

  public void setPickTeam1(Integer pickTeam1) {
	this.pickTeam1 = pickTeam1;
  }

  public Integer getPickTeam2() {
	return pickTeam2;
  }

  public void setPickTeam2(Integer pickTeam2) {
	this.pickTeam2 = pickTeam2;
  }

  public Integer getPickTeam3() {
	return pickTeam3;
  }

  public void setPickTeam3(Integer pickTeam3) {
	this.pickTeam3 = pickTeam3;
  }

  public Integer getPickTeam4() {
	return pickTeam4;
  }

  public void setPickTeam4(Integer pickTeam4) {
	this.pickTeam4 = pickTeam4;
  }

  public Integer getPickTeam5() {
	return pickTeam5;
  }

  public void setPickTeam5(Integer pickTeam5) {
	this.pickTeam5 = pickTeam5;
  }

  @Override
  public String toString() {
	return "PickOrder [pickId=" + pickId + ", pickRound=" + pickRound + ", pickTeam1=" + pickTeam1 + ", pickTeam2="
			+ pickTeam2 + ", pickTeam3=" + pickTeam3 + ", pickTeam4=" + pickTeam4 + ", pickTeam5=" + pickTeam5 + "]";
  }

}