package com.auction.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.auction.model.Auction;
import com.auction.model.Player;
import com.auction.model.PlayerCount;
import com.auction.model.Team;
import com.auction.service.AuctionService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuctionFunctions {
	
	public static class PlayerStatsComparator implements Comparator<Player> {
	    @Override
	    public int compare(Player bs1, Player bs2) {
	       return Float.compare(Float.valueOf(bs2.getSoldForPoints()), Float.valueOf(bs1.getSoldForPoints()));
	    }
	}
	
	public static String getOnlineCurrentDate() throws IOException
	{
		HttpURLConnection httpCon = (HttpURLConnection) new URL("https://mail.google.com/").openConnection();
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date(httpCon.getDate()));
	}	
	
	public static Auction populateMatchVariables(Auction auction, List<Player> plyr, List<Team> tm) 
	{
		auction.setTeam(tm);
		auction.setPlayersList(plyr);
		return auction;
	}
	public static List<String> getSquadDataInZone(Auction match, int team_id) {
	    List<String> zone_data = new ArrayList<>();
	    Map<String, Integer> zoneQuotas = new LinkedHashMap<>(); // Preserves order of insertion

	    // Initialize quotas
	    zoneQuotas.put("NZ", 2);
	    zoneQuotas.put("CZ", 2);
	    zoneQuotas.put("EZ", 2);
	    zoneQuotas.put("WZ", 2);
	    zoneQuotas.put("SZ", 2);
	    zoneQuotas.put("U19", 2);
	    zoneQuotas.put("ZONE", 6);

	    // Process players in the match for the given team ID
	    if (match.getPlayers() != null) {
	        for (Player player : match.getPlayers()) {
	            if (player.getTeamId() == team_id) {
	                zone_data.add(String.valueOf(player.getPlayerId()));
	                for(Player plyr : match.getPlayersList()) {
	                	if(plyr.getPlayerId() == player.getPlayerId()) {
	                		 // Get the corresponding zone key for the player's category
	                        String categoryKey = getZoneKey(plyr.getCategory());
	                        if (categoryKey != null) {
	                            // Decrement quota if available, or fallback to "ZONE"
	                            if (zoneQuotas.get(categoryKey) > 0) {
	                                zoneQuotas.put(categoryKey, zoneQuotas.get(categoryKey) - 1);
	                            } else if (zoneQuotas.get("ZONE") > 0) {
	                                zoneQuotas.put("ZONE", zoneQuotas.get("ZONE") - 1);
	                            }
	                        }
	    	                break;
	                	}
	                }
	            }
	        }
	    }

	 // Add remaining quotas as placeholders in the list
	    for (Map.Entry<String, Integer> entry : zoneQuotas.entrySet()) {
	        String zone = entry.getKey();
	        int count = entry.getValue();
	        for (int i = 0; i < count; i++) {
	        	zone_data.add(zone);
	        }
	    }

	    return zone_data;
	}
	public static List<String> getSquadDataMT20InZone(Auction match, int team_id, String gender) {
	    List<String> zone_data = new ArrayList<>();
	    Map<String, Integer> zoneQuotas = new LinkedHashMap<>(); // Preserves order of insertion

	    // Initialize quotas
	    if(gender.equalsIgnoreCase("MEN")) {
	    	zoneQuotas.put("ICON", 1);
		    zoneQuotas.put("SENIOR", 3);
		    zoneQuotas.put("EMERGING", 3);
		    zoneQuotas.put("DEVELOPMENT", 5);
		    zoneQuotas.put("ZONE", 8);
	    }else {
	    	zoneQuotas.put("ICON", 1);
		    zoneQuotas.put("U19", 2);
		    zoneQuotas.put("GENERAL", 15);
	        zoneQuotas.put("ZONE", 0); // fallback safety
	    }
	    
	    // Process players in the match for the given team ID
	    if (match.getPlayers() != null) {
	        for (Player player : match.getPlayers()) {
	            if (player.getTeamId() == team_id) {
	                zone_data.add(String.valueOf(player.getPlayerId()));
	                for(Player plyr : match.getPlayersList()) {
	                	if(plyr.getPlayerId() == player.getPlayerId()) {
	                		 // Get the corresponding zone key for the player's category
	                        String categoryKey = plyr.getCategory().trim().toUpperCase();
	                        if (categoryKey != null) {
	                            // Decrement quota if available, or fallback to "ZONE"
//	                            if (zoneQuotas.get(categoryKey) > 0) {
//	                                zoneQuotas.put(categoryKey, zoneQuotas.get(categoryKey) - 1);
//	                            } else if (zoneQuotas.get("ZONE") > 0) {
//	                                zoneQuotas.put("ZONE", zoneQuotas.get("ZONE") - 1);
//	                            }
	                        	
	                        	 int quota = zoneQuotas.getOrDefault(categoryKey, 0);
	                             if (quota > 0) {
	                                 zoneQuotas.put(categoryKey, quota - 1);
	                             } else {
	                                 int zoneQuota = zoneQuotas.getOrDefault("ZONE", 0);
	                                 if (zoneQuota > 0) {
	                                     zoneQuotas.put("ZONE", zoneQuota - 1);
	                                 }
	                             }
	                        }
	    	                break;
	                	}
	                }
	            }
	        }
	    }

	 // Add remaining quotas as placeholders in the list
	    for (Map.Entry<String, Integer> entry : zoneQuotas.entrySet()) {
	        String zone = entry.getKey();
	        int count = entry.getValue();
	        for (int i = 0; i < count; i++) {
	        	zone_data.add(zone);
	        }
	    }
	    return zone_data;
	}
	
	public static List<String> getSquadDataPSLInZone(Auction match, int team_id) {
	    List<String> zone_data = new ArrayList<>();
	    Map<String, Integer> zoneQuotas = new LinkedHashMap<>(); // Preserves order of insertion

	    // Initialize quotas
	    zoneQuotas.put("ZONE", 20);

	    // Process players in the match for the given team ID
	    if (match.getPlayers() != null) {
	        for (Player player : match.getPlayers()) {
	            if (player.getTeamId() == team_id) {
	                zone_data.add(String.valueOf(player.getPlayerId()));
	                for(Player plyr : match.getPlayersList()) {
	                	if(plyr.getPlayerId() == player.getPlayerId()) {
	                		 // Get the corresponding zone key for the player's category
	                        String categoryKey = plyr.getCategory().trim().toUpperCase();
	                        if (categoryKey != null) {
	                            // Decrement quota if available, or fallback to "ZONE"
	                            if (zoneQuotas.get(categoryKey) > 0) {
	                                zoneQuotas.put(categoryKey, zoneQuotas.get(categoryKey) - 1);
	                            } else if (zoneQuotas.get("ZONE") > 0) {
	                                zoneQuotas.put("ZONE", zoneQuotas.get("ZONE") - 1);
	                            }
	                        }
	    	                break;
	                	}
	                }
	            }
	        }
	    }

	 // Add remaining quotas as placeholders in the list
	    for (Map.Entry<String, Integer> entry : zoneQuotas.entrySet()) {
	        String zone = entry.getKey();
	        int count = entry.getValue();
	        for (int i = 0; i < count; i++) {
	        	zone_data.add(zone);
	        }
	    }

	    return zone_data;
	}
	public static List<String> getSquadDataVCLInZone(Auction match, int team_id) {
	    List<String> zone_data = new ArrayList<>();
	    Map<String, Integer> zoneQuotas = new LinkedHashMap<>(); // Preserves order of insertion

	    // Initialize quotas
	    zoneQuotas.put("APEX", 1);
	    zoneQuotas.put("ELITE", 2);
	    zoneQuotas.put("PRO", 5);
	    zoneQuotas.put("ROOKIE", 5);
	    zoneQuotas.put("DARKHORSE", 1);
	    
	    // Process players in the match for the given team ID
	    if (match.getPlayers() != null) {
	        for (Player player : match.getPlayers()) {
	            if (player.getTeamId() == team_id) {
	                zone_data.add(String.valueOf(player.getPlayerId()));
	                for(Player plyr : match.getPlayersList()) {
	                	if(plyr.getPlayerId() == player.getPlayerId()) {
	                		 // Get the corresponding zone key for the player's category
	                        String categoryKey = plyr.getCategory().trim().toUpperCase();
	                        if (categoryKey != null) {
	                            // Decrement quota if available, or fallback to "ZONE"
//	                            if (zoneQuotas.get(categoryKey) > 0) {
//	                                zoneQuotas.put(categoryKey, zoneQuotas.get(categoryKey) - 1);
//	                            } else if (zoneQuotas.get("ZONE") > 0) {
//	                                zoneQuotas.put("ZONE", zoneQuotas.get("ZONE") - 1);
//	                            }
	                        	
	                        	 int quota = zoneQuotas.getOrDefault(categoryKey, 0);
	                             if (quota > 0) {
	                                 zoneQuotas.put(categoryKey, quota - 1);
	                             } else {
	                                 int zoneQuota = zoneQuotas.getOrDefault("ZONE", 0);
	                                 if (zoneQuota > 0) {
	                                     zoneQuotas.put("ZONE", zoneQuota - 1);
	                                 }
	                             }
	                        }
	    	                break;
	                	}
	                }
	            }
	        }
	    }

	 // Add remaining quotas as placeholders in the list
	    for (Map.Entry<String, Integer> entry : zoneQuotas.entrySet()) {
	        String zone = entry.getKey();
	        int count = entry.getValue();
	        for (int i = 0; i < count; i++) {
	        	zone_data.add(zone);
	        }
	    }
	    return zone_data;
	}
	
	
	
	public static List<String> getSquadDataKCLInZone(Auction match, int team_id) {
	    List<String> zone_data = new ArrayList<>();
	    Map<String, Integer> zoneQuotas = new LinkedHashMap<>(); // Preserves order of insertion

	    // Initialize quotas
//	    zoneQuotas.put("A+", 3);
//	    zoneQuotas.put("A", 3);
//	    zoneQuotas.put("B", 3);
//	    zoneQuotas.put("C", 4);
//	    zoneQuotas.put("ZONE", 14);

	    // Process players in the match for the given team ID
	    if (match.getPlayers() != null) {
	        for (Player player : match.getPlayers()) {
	            if (player.getTeamId() == team_id) {
	                zone_data.add(String.valueOf(player.getPlayerId()));
	                for(Player plyr : match.getPlayersList()) {
	                	if(plyr.getPlayerId() == player.getPlayerId()) {
	                		 // Get the corresponding zone key for the player's category
	                		String categoryKey = null;
	                		if(plyr.getCategory().contains("C")) {
	                			categoryKey = "C";
	                		}else {
	                			categoryKey = plyr.getCategory().trim().toUpperCase();
	                		}
	                        
	                        if (categoryKey != null) {
	                            // Decrement quota if available, or fallback to "ZONE"
	                            if (zoneQuotas.get(categoryKey) > 0) {
	                                zoneQuotas.put(categoryKey, zoneQuotas.get(categoryKey) - 1);
	                            } else if (zoneQuotas.get("ZONE") > 0) {
	                                zoneQuotas.put("ZONE", zoneQuotas.get("ZONE") - 1);
	                            }
	                        }
	    	                break;
	                	}
	                }
	            }
	        }
	    }

	 // Add remaining quotas as placeholders in the list
	    for (Map.Entry<String, Integer> entry : zoneQuotas.entrySet()) {
	        String zone = entry.getKey();
	        int count = entry.getValue();
	        for (int i = 0; i < count; i++) {
	        	zone_data.add(zone);
	        }
	    }

	    return zone_data;
	}
	
	
	public static List<String> getSquadDataUTTZone(Auction match, int team_id) {

	    List<String> zone_data = new ArrayList<>();

	    // Maintain order
	    Map<String, Integer> zoneQuotas = new LinkedHashMap<>();
	    zoneQuotas.put("IND_M", 2);
	    zoneQuotas.put("IND_F", 2);
	    zoneQuotas.put("INT_M", 1);
	    zoneQuotas.put("INT_F", 1);

	    if (match.getPlayers() != null) {
	        for (Player player : match.getPlayers()) {
	            if (player.getTeamId() != team_id) continue;
	            String categoryKey = getZoneKeyUTT(player.getCategory(), player.getGender());
	            if (categoryKey != null && zoneQuotas.containsKey(categoryKey)) {
	                int remaining = zoneQuotas.get(categoryKey);
	                if (remaining > 0) {
	                    zone_data.add(String.valueOf(player.getPlayerId()));
	                    zoneQuotas.put(categoryKey, remaining - 1);
	                }
	            }
	        }
	    }

	    for (Map.Entry<String, Integer> entry : zoneQuotas.entrySet()) {
	        String zone = entry.getKey();
	        int count = entry.getValue();

	        for (int i = 0; i < count; i++) {
	            zone_data.add(zone);
	        }
	    }

	    return zone_data;
	}
	// Helper method to map categories to zone keys
	private static String getZoneKey(String category) {
		if(category != null) {
			switch (category.toLowerCase()) {
		        case "north zone": return "NZ";
		        case "central zone": return "CZ";
		        case "east zone": return "EZ";
		        case "west zone": return "WZ";
		        case "south zone": return "SZ";
		        case "u19": return "U19";
		        default: return null; 
		    }
		}else {
			return null;
		}
	}
	
	private static String getZoneKeyUTT(String category, String gender) {
		switch (category.toUpperCase()) {
	        case "INT.M": return "INT_M";
	        case "INT.F": return "INT_F";
	        case "IND.M": return "IND_M";
	        case "IND.F": return "IND_F";
	        default: return null; 
	    }
	}


	public static HashMap<String, List<PlayerCount>> PlayerCountZoneWise(List<Team> tm, List<Player> ply, List<Player> PlayerDb) {
    List<PlayerCount> playerList = new ArrayList<PlayerCount>();
    
    HashMap<String, List<PlayerCount>> Zone_Team_Map = new HashMap<String, List<PlayerCount>>(); 
    
    if (tm != null) {
        for (Team team : tm) {
            PlayerCount playerCount = new PlayerCount();
            playerCount.setTeamId(team.getTeamId());
            playerCount.setTeamName1(team.getTeamName1());
            playerCount.setTeamName2(team.getTeamName2());
            playerCount.setTeamName3(team.getTeamName3());
            playerCount.setTeamName4(team.getTeamName4());
            playerCount.setTeamTotalPurse(team.getTeamTotalPurse());
            playerList.add(playerCount);
        }
    }

	    Zone_Team_Map.put("EAST ZONE", playerList);
	    Zone_Team_Map.put("WEST ZONE", playerList);
	    Zone_Team_Map.put("NORTH ZONE",playerList);
	    Zone_Team_Map.put("SOUTH ZONE", playerList);
	    Zone_Team_Map.put("CENTRAL ZONE", playerList);
	    Zone_Team_Map.put("U19", playerList);	    
   
	    if (ply != null) {
        for (Player plyer : ply) {
            if (plyer.getSoldOrUnsold().equalsIgnoreCase("RTM") || plyer.getSoldOrUnsold().equalsIgnoreCase("SOLD")) {                
            	Player playerInfo = PlayerDb.stream()
                        .filter(pl -> pl.getPlayerId() == plyer.getPlayerId())
                        .findAny().orElse(null);
            		if(playerInfo != null&& playerInfo.getCategory() != null) {
            		 
            			// Add new category to map if not already present
            			Zone_Team_Map.computeIfAbsent(playerInfo.getCategory(), k -> playerList);

            		 for (PlayerCount mapPlayer : Zone_Team_Map.get(playerInfo.getCategory().toUpperCase())) {
            			 if(mapPlayer.getTeamId()== plyer.getTeamId()) {
            				   switch (playerInfo.getCategory().toUpperCase()) {
                               case "CENTRAL ZONE":
                            	   mapPlayer.setCentralZone(mapPlayer.getCentralZone() + 1);
                                   break;
                               case "EAST ZONE":
                            	   mapPlayer.setEastZone(mapPlayer.getEastZone() + 1);
                                   break;
                               case "NORTH ZONE":
                            	   mapPlayer.setNorthZone(mapPlayer.getNorthZone() + 1);
                                   break;
                               case "SOUTH ZONE":
                            	   mapPlayer.setSouthZone(mapPlayer.getSouthZone() + 1);
                                   break;
                               case "WEST ZONE":
                            	   mapPlayer.setWestZone(mapPlayer.getWestZone() + 1);
                                   break;
                               case "U19":
                            	   mapPlayer.setU19(mapPlayer.getU19() + 1);
                                   break;
                               default :
                            	   // For dynamic zones, add category
                            	   mapPlayer.getCategory().put(playerInfo.getCategory().toUpperCase(), 
                            			   mapPlayer.getCategory().getOrDefault(playerInfo.getCategory().toUpperCase(), 0) + 1);
                            	   break;
                           }
            			 }
            		 }
            	}
            }
        }
    }
    return Zone_Team_Map;
}
	public static List<PlayerCount> PlayerCountPerTeamZoneWise(List<Team>tm,List<Player>ply, List<Player> PlayerDb, String broadcaster) throws Exception {
			List <PlayerCount> player = new ArrayList<PlayerCount>();
			
			player = new ObjectMapper().readValue(new ObjectMapper().writeValueAsString(tm), new TypeReference<List<PlayerCount>>() {});
			if (player == null) player = new ArrayList<>();
			if(tm != null) {
				for (PlayerCount team : player) {
				        team.setExpectedPurse(((300000*15) + 600000));
				        team.setRemaingPurse(Integer.valueOf(team.getTeamTotalPurse())-((300000*15) + 600000));
				        team.setPurseRemaing(Integer.valueOf(team.getTeamTotalPurse()));
				}
			}
			
			if (broadcaster == null) {
			    broadcaster = " "; 
			}
			switch (broadcaster) {
			case "UTT":
			    Map<Integer, Player> playerMap = PlayerDb.stream().collect(Collectors.toMap(Player::getPlayerId, p -> p));
			    if (ply != null) {
			        for (Player plyer : ply) {
			            for (PlayerCount tms : player) {
			                if (plyer.getTeamId() == tms.getTeamId()) {
			                    String[] playerIds = plyer.getPlayersId() != null ? plyer.getPlayersId().split(",")
			                            : new String[]{String.valueOf(plyer.getPlayerId())};

			                    boolean pairProcessed = false;
			                    for (String pidStr : playerIds) {
			                        int pid = Integer.parseInt(pidStr.trim());
			                        Player plyers = playerMap.get(pid);
			                        if (plyers == null) continue;
			                        String status = plyer.getSoldOrUnsold();

			                        if (!pairProcessed && status != null && (
			                                status.equalsIgnoreCase("RTM") ||
			                                status.equalsIgnoreCase("SOLD") ||
			                                status.equalsIgnoreCase("RETAIN"))) {

			                            if (status.equalsIgnoreCase("RTM")) {
			                                tms.setRtm(tms.getRtm() + 1);
			                            }

			                            int basePrice = Integer.parseInt(plyers.getBasePrice()) * 1000;
			                            tms.setExpectedPurse(tms.getExpectedPurse() - basePrice);
			                            tms.setRemaingPurse(tms.getRemaingPurse() - (plyer.getSoldForPoints() - basePrice));
			                            tms.setPurseRemaing(Math.max(0, tms.getPurseRemaing() - plyer.getSoldForPoints()));
			                            tms.setPlayers(tms.getPlayers() + 1);
			                            pairProcessed = true;
			                        }
			                        if (plyers.getNationality() != null && plyers.getGender() != null) {

			                            if (plyers.getNationality().equalsIgnoreCase("INDIA")) {
			                                if (plyers.getGender().equalsIgnoreCase("MALE")) {
			                                    tms.setInd_male(tms.getInd_male() + 1);
			                                } else {
			                                    tms.setInd_female(tms.getInd_female() + 1);
			                                }
			                            } else {
			                                if (plyers.getGender().equalsIgnoreCase("MALE")) {
			                                    tms.setFor_male(tms.getFor_male() + 1);
			                                } else {
			                                    tms.setFor_female(tms.getfor_female() + 1);
			                                }
			                            }
			                        }

			                        plyers.setSoldOrUnsold(status);
			                        plyers.setSoldForPoints(plyer.getSoldForPoints());
			                        plyers.setTeamId(plyer.getTeamId());

			                        tms.getPlayer().add(plyers);

			                        if (plyers.getCategory() != null) {

			                            String cat = plyers.getCategory().trim().toUpperCase();

			                            switch (cat) {
			                                case "CENTRAL ZONE":
			                                    tms.setCentralZone(tms.getCentralZone() + 1);
			                                    break;
			                                case "EAST ZONE":
			                                    tms.setEastZone(tms.getEastZone() + 1);
			                                    break;
			                                case "NORTH ZONE":
			                                    tms.setNorthZone(tms.getNorthZone() + 1);
			                                    break;
			                                case "SOUTH ZONE":
			                                    tms.setSouthZone(tms.getSouthZone() + 1);
			                                    break;
			                                case "WEST ZONE":
			                                    tms.setWestZone(tms.getWestZone() + 1);
			                                    break;
			                                case "U19":
			                                    tms.setU19(tms.getU19() + 1);
			                                    break;

			                                default:
			                                    tms.getCategory().put(
			                                            cat,
			                                            tms.getCategory().getOrDefault(cat, 0) + 1
			                                    );

			                                    tms.getPlayerCategoryWise()
			                                            .computeIfAbsent(cat, k -> new ArrayList<>())
			                                            .add(plyers);
			                            }
			                        }
			                    }
			                }
			            }
			        }
			    }

			    Set<String> allCategorie = PlayerDb.stream()
			            .map(Player::getCategory)
			            .filter(Objects::nonNull)
			            .map(String::trim)
			            .map(String::toUpperCase)
			            .collect(Collectors.toSet());

			    for (PlayerCount tms : player) {
			        for (String category : allCategorie) {
			            tms.getCategory().putIfAbsent(category, 0);
			            tms.getPlayerCategoryWise().computeIfAbsent(category, k -> new ArrayList<>());
			        }
			    }

			    for (PlayerCount tms : player) {
			        Map<String, Integer> sortedCategoryMap = tms.getCategory().entrySet()
			                .stream()
			                .sorted(Comparator.comparingInt(e -> e.getKey().length()))
			                .collect(Collectors.toMap(
			                        Map.Entry::getKey,
			                        Map.Entry::getValue,
			                        (e1, e2) -> e1,
			                        LinkedHashMap::new
			                ));

			        tms.setCategory(sortedCategoryMap);
			    }

			    break;
			default:
				if(ply != null) {
					for(Player plyer : ply) {
						for(PlayerCount tms: player) {
							if(plyer.getTeamId()== tms.getTeamId()) {
								
								Player plyers = PlayerDb.stream().filter(pl->pl.getPlayerId()== plyer.getPlayerId()).findAny().orElse(null);

								if (plyers == null) {
								    continue;
								}

								if(plyer.getSoldOrUnsold().equalsIgnoreCase("RTM") || plyer.getSoldOrUnsold().equalsIgnoreCase("SOLD") 
								        || plyer.getSoldOrUnsold().equalsIgnoreCase("RETAIN")) {
									if(plyer.getSoldOrUnsold().equalsIgnoreCase("RTM")){
										tms.setRtm(tms.getRtm()+1);
									}
									if(plyer.getIconic()!= null && plyer.getIconic().equals(AuctionUtil.YES)) {
										tms.setExpectedPurse(tms.getExpectedPurse()- Integer.valueOf(plyers.getBasePrice() + "000"));
										tms.setRemaingPurse(tms.getRemaingPurse()-(plyer.getSoldForPoints()- Integer.valueOf(plyers.getBasePrice() + "000")));
										tms.setPurseRemaing(Math.max(0, tms.getPurseRemaing() - plyer.getSoldForPoints()));
									}else {
										tms.setExpectedPurse(tms.getExpectedPurse()- Integer.valueOf(plyers.getBasePrice() + "000"));
										tms.setRemaingPurse(tms.getRemaingPurse()-(plyer.getSoldForPoints()- Integer.valueOf(plyers.getBasePrice() + "000")));
										tms.setPurseRemaing(Math.max(0, tms.getPurseRemaing() - plyer.getSoldForPoints()));
									}
								}
								//Total Squad Size
								tms.setPlayers(tms.getPlayers()+1);
								
								if(plyers != null && plyers.getNationality() != null) {
									if (plyers.getNationality().equalsIgnoreCase("INDIA"))
										tms.setInd_male(plyers.getGender().equalsIgnoreCase("MALE") ? tms.getInd_male() + 1 : tms.getInd_female() + 1);
									else
										if(plyers.getGender() != null) {
											tms.setFor_male(plyers.getGender().equalsIgnoreCase("MALE") ? tms.getFor_male() + 1 : tms.getfor_female() + 1);
										}
								}
								
								if(plyers!= null) {
									
									plyers.setSoldOrUnsold(plyer.getSoldOrUnsold());
									plyers.setSoldForPoints(plyer.getSoldForPoints());
									plyers.setTeamId(plyer.getTeamId());
									
									//player's in a team
									tms.getPlayer().add(plyers);
									
									//Category
									if(plyers.getCategory()!= null && plyers.getCategory().equalsIgnoreCase("Central Zone")) {
										tms.setCentralZone(tms.getCentralZone()+1);
									}else if(plyers.getCategory()!= null && plyers.getCategory().equalsIgnoreCase("East Zone")) {
										tms.setEastZone(tms.getEastZone()+1);
									}else if(plyers.getCategory()!= null && plyers.getCategory().equalsIgnoreCase("North Zone")) {
										tms.setNorthZone(tms.getNorthZone()+1);
									}else if(plyers.getCategory()!= null && plyers.getCategory().equalsIgnoreCase("South Zone")) {
										tms.setSouthZone(tms.getSouthZone()+1);
									}else if(plyers.getCategory()!= null && plyers.getCategory().equalsIgnoreCase("West Zone")) {
										tms.setWestZone(tms.getWestZone()+1);
									}else if(plyers.getCategory()!= null && plyers.getCategory().equalsIgnoreCase("UNDER19")) {
										tms.setU19(tms.getU19()+1);
									}else {
										if(plyers.getCategory()!= null) {
											//Total player in a category
		                                    tms.getCategory().put(plyers.getCategory().trim().toUpperCase(), tms.getCategory()
		                                    		.getOrDefault(plyers.getCategory().trim().toUpperCase(), 0) + 1);
		                                    //Add player category wise
		                                    tms.getPlayerCategoryWise()
		                                    .computeIfAbsent(plyers.getCategory().trim().toUpperCase(), k -> new ArrayList<>())
		                                    .add(plyers);
										}
									}
								}
							}
						}
					}
				}
				// Dynamically gather all unique categories from PlayerDb
			    Set<String> allCategories = PlayerDb.stream().map(Player::getCategory)
			            .filter(Objects::nonNull).map(String::trim).map(String::toUpperCase)
			            .collect(Collectors.toSet());

			    // Ensure every team has all categories, even if zero players
			    for (PlayerCount tms : player) {
			        for (String category : allCategories) {
			            tms.getCategory().putIfAbsent(category, 0);
			            tms.getPlayerCategoryWise().computeIfAbsent(category, k -> new ArrayList<>());
			        }
			    }
			    for (PlayerCount tms : player) {
			    	 Map<String, Integer> sortedCategoryMap = tms.getCategory().entrySet()
				    	    .stream()
				    	    .sorted(Comparator.comparingInt(e -> e.getKey().length()))
				    	    .collect(Collectors.toMap(
				    	        Map.Entry::getKey,
				    	        Map.Entry::getValue,
				    	        (e1, e2) -> e1,
				    	        LinkedHashMap::new
				    	    ));

				    	tms.setCategory(sortedCategoryMap); // Assuming setter exists	
			    }
				break;
			}
			
		 
		return player;		
	}
	
	public static List<Player> PlayerCountCategoryWise(List<Team>tm,List<Player>ply, List<Player> PlayerDb) {

		for(Player dbPlayer : PlayerDb) {
			for(Player match :ply) {
				if(match.getPlayerId()==dbPlayer.getPlayerId()) {
					dbPlayer.setSoldOrUnsold(match.getSoldOrUnsold());
					if(match.getSoldOrUnsold().equalsIgnoreCase("RTM")||match.getSoldOrUnsold().equalsIgnoreCase("SOLD")) {
						dbPlayer.setSoldForPoints(match.getSoldForPoints());
						dbPlayer.setTeamId(match.getTeamId());
						dbPlayer.setTeam(tm.stream().filter(team -> team.getTeamId() == match.getTeamId()).findAny().orElse(null));

					}
				}
			}
		}
	 	return PlayerDb;		
}
	
	public static String ConvertToLakh(double num,boolean isCurrentBid) {
	    String str = String.format("%.2f", num / 100000);
       if(isCurrentBid) {
    	   // Remove .00 if present
    	   if (str.endsWith(".00")) {
   	        return str.substring(0, str.length() - 3);
   	    }
       }
	   
	    return str;
	}
	public static String ConvertToLakh(double num) {
	    String str = String.format("%.2f", num / 100000);
      
    	   // Remove .00 if present
//    	   if (str.endsWith(".00")) {
//   	        return str.substring(0, str.length() - 3);
//   	    
//    	   }
	   
	    return str;
	}

//  public static String ConvertToLakh(double num) { 
//	  double thousandValue = num /
//	 1000.0; String formatted = String.format("%.2f", thousandValue);
//  
//	 return formatted.substring(0, formatted.length() - 3); 
//  }

	public static String formatRawAmount(double amount) {
	    BigDecimal bdAmount = new BigDecimal(Double.toString(amount));

	    // CRORE (>= 1 CR)
	    if (bdAmount.compareTo(new BigDecimal("10000000")) >= 0) {
	        BigDecimal croreValue = bdAmount.divide(new BigDecimal("10000000"), 3, RoundingMode.DOWN);
	        return croreValue.toPlainString() + ",CR";
	    }

	    // LAKH (< 1 CR)
	    BigDecimal lakhValue = bdAmount.divide(new BigDecimal("100000"), 2, RoundingMode.DOWN);
	    return lakhValue.toPlainString() + ",L";
	}
	
	public static String formatAmountInCrore(double amount) {
		BigDecimal bdAmount = new BigDecimal(Double.toString(amount));
		BigDecimal croreValue = bdAmount.divide(new BigDecimal("10000000"), 3, RoundingMode.DOWN);
        return croreValue.toPlainString() + ",CR";
	}
	
}
