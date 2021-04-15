package me.Ravi.Lotr;
import java.util.List;

import net.md_5.bungee.api.ChatColor;

public class LoadData 
{
	static String sectFile = "sect.json";
	static String lFactionFile = "faction.json";
	static String lFPlayerFile = "player.json";

	public static void LoadSect() 
	{
		List<LotrSect> sects =(List<LotrSect>)Utils.Deserialize(sectFile);
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
		List<LotrFaction> factions = (List<LotrFaction>)Utils.Deserialize(lFactionFile);
		if(factions==null)
		{
			Utils.Log(ChatColor.RED+"Null list loaded from file - faction.bin");
		}
		else
		{
			Utils.Log(ChatColor.GOLD+"Loaded "+factions.size()+" Factions");
			FactionManager.setList(factions);
		}
	}
	public static void loadFPlayer() 	
	{
		List<LotrFPlayer> players = (List<LotrFPlayer>)Utils.Deserialize(lFPlayerFile);
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
}
