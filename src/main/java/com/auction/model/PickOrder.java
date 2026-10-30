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
	
  @Column(name = "PickTeam")
  private String pickTeam;

  @Column(name = "PickOrder")
  private String pickOrder;
  
  @Column(name = "PickRound")
  private String pickRound;

  public int getPickId() {
	return pickId;
  }

  public void setPickId(int pickId) {
	this.pickId = pickId;
  }

  public String getPickTeam() {
	return pickTeam;
  }

  public void setPickTeam(String pickTeam) {
	this.pickTeam = pickTeam;
  }

  public String getPickOrder() {
	return pickOrder;
  }

  public void setPickOrder(String pickOrder) {
	this.pickOrder = pickOrder;
  }

  public String getPickRound() {
	return pickRound;
  }

  public void setPickRound(String pickRound) {
	this.pickRound = pickRound;
  }

  @Override
  public String toString() {
	return "PickOrder [pickId=" + pickId + ", pickTeam=" + pickTeam + ", pickOrder=" + pickOrder + ", pickRound="
			+ pickRound + "]";
  }

}