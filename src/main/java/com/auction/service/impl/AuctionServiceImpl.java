package com.auction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auction.dao.AuctionDao;
import com.auction.model.Flipper;
import com.auction.model.NameSuper;
import com.auction.model.Player;
import com.auction.model.Squad;
import com.auction.model.Statistics;
import com.auction.model.StatsType;
import com.auction.model.Team;
import com.auction.service.AuctionService;

@Service("auctionService")
@Transactional
public class AuctionServiceImpl implements AuctionService {

 @Autowired
 private AuctionDao auctionDao;
 
@Override
public Player getPlayer(String whatToProcess, String valueToProcess) {
	return auctionDao.getPlayer(whatToProcess, valueToProcess);
}

@Override
public Team getTeam(String whatToProcess, String valueToProcess) {
	return auctionDao.getTeam(whatToProcess, valueToProcess);
}

@Override
public List<Team> getTeams() {
	return auctionDao.getTeams();
}

@Override
public List<Player> getPlayers(String whatToProcess, String valueToProcess) {
	return auctionDao.getPlayers(whatToProcess, valueToProcess);
}

@Override
public List<Statistics> getAllStats() {
	return auctionDao.getAllStats();
}

@Override
public List<Statistics> getStats() {
	return auctionDao.getStats();
}

@Override
public List<Player> getAllPlayer() {
	return auctionDao.getAllPlayer();
}

@Override
public List<NameSuper> getNameSupers(){
	return auctionDao.getNameSupers();
}

@Override
public List<Squad> getSquads() {
	return auctionDao.getSquads();
}

@Override
public List<StatsType> getStatsTypes() {
	return auctionDao.getStatsTypes();
}

@Override
public List<Flipper> getFlipper() {
	return auctionDao.getFlipper();
}

}