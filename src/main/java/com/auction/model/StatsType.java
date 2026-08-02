package com.auction.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "StatsType")
public class StatsType {

  @Id
  @Column(name = "StatsId")
  private int stats_id;
	
  @Column(name = "StatsFullName")
  private String stats_full_name;

  @Column(name = "StatsShortName")
  private String stats_short_name;

public int getStats_id() {
	return stats_id;
}

public void setStats_id(int stats_id) {
	this.stats_id = stats_id;
}

public String getStats_full_name() {
	return stats_full_name;
}

public void setStats_full_name(String stats_full_name) {
	this.stats_full_name = stats_full_name;
}

public String getStats_short_name() {
	return stats_short_name;
}

public void setStats_short_name(String stats_short_name) {
	this.stats_short_name = stats_short_name;
}

}