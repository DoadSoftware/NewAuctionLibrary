package com.auction.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.auction.dao.AuctionDao;
import com.auction.model.Flipper;
import com.auction.model.NameSuper;
import com.auction.model.Player;
import com.auction.model.Split;
import com.auction.model.Squad;
import com.auction.model.Statistics;
import com.auction.model.StatsType;
import com.auction.model.Team;
import com.auction.util.AuctionUtil;

@Transactional
@Repository("auctionDao")
public class AuctionDaoImpl implements AuctionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Player getPlayer(String whatToProcess, String valueToProcess) {

        switch (whatToProcess) {

        case AuctionUtil.PLAYER:
            return sessionFactory.getCurrentSession()
                    .createQuery("from Player where PlayerId = :playerId", Player.class)
                    .setParameter("playerId", Integer.parseInt(valueToProcess))
                    .uniqueResult();

        default:
            return null;
        }
    }

    @Override
    public Team getTeam(String whatToProcess, String valueToProcess) {

        switch (whatToProcess) {

        case AuctionUtil.TEAM:
            return sessionFactory.getCurrentSession()
                    .createQuery("from Team where TeamId = :teamId", Team.class)
                    .setParameter("teamId", Integer.parseInt(valueToProcess))
                    .uniqueResult();

        default:
            return null;
        }
    }

    @Override
    public List<Team> getTeams() {

        return sessionFactory.getCurrentSession()
                .createQuery("from Team", Team.class)
                .getResultList();
    }

    @Override
    public List<Player> getPlayers(String whatToProcess, String valueToProcess) {

        switch (whatToProcess) {

        case AuctionUtil.TEAM:
            return sessionFactory.getCurrentSession()
                    .createQuery("from Player where TeamId = :teamId", Player.class)
                    .setParameter("teamId", Integer.parseInt(valueToProcess))
                    .getResultList();

        default:
            return null;
        }
    }

    @Override
    public List<Statistics> getAllStats() {

        return sessionFactory.getCurrentSession()
                .createQuery("from Statistics", Statistics.class)
                .getResultList();
    }

    @Override
    public List<Statistics> getStats() {

        return sessionFactory.getCurrentSession()
                .createQuery("from Statistics", Statistics.class)
                .getResultList();
    }

    @Override
    public List<Player> getAllPlayer() {

        return sessionFactory.getCurrentSession()
                .createQuery("from Player", Player.class)
                .getResultList();
    }

    @Override
    public List<NameSuper> getNameSupers() {

        return sessionFactory.getCurrentSession()
                .createQuery("from NameSuper", NameSuper.class)
                .getResultList();
    }
    
    @Override
    public List<Split> getsSplits() {
    	return sessionFactory.getCurrentSession().createQuery("from Split", Split.class).getResultList();
    }

    @Override
    public List<Squad> getSquads() {

        return sessionFactory.getCurrentSession()
                .createQuery("from Squad", Squad.class)
                .getResultList();
    }

    @Override
    public List<StatsType> getStatsTypes() {

        return sessionFactory.getCurrentSession()
                .createQuery("from StatsType", StatsType.class)
                .getResultList();
    }

    @Override
    public List<Flipper> getFlipper() {

        return sessionFactory.getCurrentSession()
                .createQuery("from Flipper", Flipper.class)
                .getResultList();
    }
}