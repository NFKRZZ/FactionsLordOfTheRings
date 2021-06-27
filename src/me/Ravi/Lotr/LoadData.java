package me.Ravi.Lotr;
import java.util.List;

import com.massivecraft.factions.Factions;

import net.md_5.bungee.api.ChatColor;

public class LoadData 
{
	static String sectFile = "sect.json";
	static String lFactionFile = "faction.json";
	static String lFPlayerFile = "player.json";

	public static void LoadSect() 
	{
		Utils.Log(ChatColor.GREEN+"LOADING UP SECTS");
		List<LotrSect> sects =  Utils.DeserializeSect();
		Utils.Log(ChatColor.GREEN+"LOADED UP SECTS");
		if(sects==null)
		{
			Utils.Log(ChatColor.RED+"Null list loaded from file - sect.bin");
		}
		else
		{
			Utils.Log(ChatColor.GOLD+"Loaded "+sects.size()+" Sects");
			SectManager.setList(sects);
		}

	}
	public static void LoadFactions() 
	{
		List<LotrFaction> factions = Utils.DeserializeFaction();
		if(factions==null)
		{
			Utils.Log(ChatColor.RED+"Null list loaded from file - faction.bin");
		}
		else
		{
			for(LotrFaction fac : factions)
			{
				fac.setFaction(fac.fName);
				Utils.Log(ChatColor.BLUE+"Set faction for "+fac.toString()+" faction is "+fac.fName);
			}
			Utils.Log(ChatColor.GOLD+"Loaded "+factions.size()+" Factions");
			FactionManager.setList(factions);
		}
	}
	public static void loadFPlayer() 	
	{
		List<LotrFPlayer> players = Utils.DeserializePlayer();
		if(players == null)
		{
			Utils.Log(ChatColor.RED+"Null list loaded from file - player.bin");
		}
		else
		{
			Utils.Log(ChatColor.GOLD+"Loaded "+players.size()+" Players");
			LotrFPlayerManager.setLotrFPlayers(players);
		}
	}
	public static void loadWars()
	{
		List<War> wars = Utils.DeserializeWar();
		if(wars == null)
		{
			Utils.Log(ChatColor.RED+"Null list loaded from file - war.json");
		}
		else
		{
			Utils.Log(ChatColor.GREEN+"Loaded "+wars.size()+" wars");
			WarManager.warList = wars;
		}
	}
	public static void loadSettlements()
	{
		List<Settlement> settlements = Utils.DeserializeSettelments();
		if(settlements == null)
		{
			Utils.Log(ChatColor.RED+"Null list loaded from file - settlements.json");
		}
		else
		{
			Utils.Log(ChatColor.GREEN+"Loaded"+settlements.size()+" settelements");
			SettlementManager.settlementList = settlements;
		}

	}
}
