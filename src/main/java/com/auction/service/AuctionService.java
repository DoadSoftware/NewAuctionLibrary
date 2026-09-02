package com.auction.service;

import java.util.List;

import com.auction.model.Flipper;
import com.auction.model.NameSuper;
import com.auction.model.Player;
import com.auction.model.Split;
import com.auction.model.Squad;
import com.auction.model.Statistics;
import com.auction.model.StatsType;
import com.auction.model.Team;
import com.auction.model.VariousText;

public interface AuctionService {
  Player getPlayer(String whatToProcess, String valueToProcess);
  Team getTeam(String whatToProcess, String valueToProcess);
  List<Player> getPlayers(String whatToProcess, String valueToProcess);
  List<Team> getTeams();
  List<Statistics> getAllStats();
  List<Statistics> getStats();
  List<Player> getAllPlayer();
  List<NameSuper> getNameSupers();
  List<Squad> getSquads();
  List<StatsType> getStatsTypes();
  List<Flipper> getFlipper();
  List<Split> getSplits();
  List<VariousText> getVariousText();
}