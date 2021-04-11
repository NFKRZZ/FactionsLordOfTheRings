package me.Ravi.Lotr;

import net.md_5.bungee.api.ChatColor;

public class SaveData 
{
	static String sectFile = "sect.bin";
	static String factionFile = "faction.bin";
	static String fPlayerFile = "player.bin";
	public static void saveSect()
	{
		for (LotrSect sect : SectManager.getList())
		{
			Utils.Log(ChatColor.GREEN+"Saving Sect: "+sect.getSect());
		}
		Utils.Serialize(SectManager.getList(), sectFile);
		Utils.Log(ChatColor.GREEN+"Saved "+SectManager.getList().size()+" Sects");
	}
	public static void saveFactions()
	{
		for (LotrFaction fac : FactionManager.getList())
		{
			Utils.Log(ChatColor.GREEN+"Saving Faction: "+fac.getFaction().getTag());
		}
		Utils.Serialize(FactionManager.getList(), factionFile);
		Utils.Log(ChatColor.GREEN+"Saved "+FactionManager.getList().size()+" factions");
	}
	public static void saveFPlayer()
	{
		for(LotrFPlayer player : LotrFPlayerManager.getLotrFPlayers())
		{
			Utils.Log(ChatColor.GREEN+"Saving Player: "+player.getFPlayer().getPlayer().getName());
		}
		Utils.Serialize(LotrFPlayerManager.getLotrFPlayers(), fPlayerFile);
		Utils.Log(ChatColor.GREEN+"Saved "+LotrFPlayerManager.getLotrFPlayers().size()+" Players");
	}
}
