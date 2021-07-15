package me.Ravi.Lotr.Managers;
import java.util.ArrayList;
import java.util.List;

import com.massivecraft.factions.Faction;

import org.bukkit.ChatColor;

import me.Ravi.Lotr.LotrFaction;
import me.Ravi.Lotr.Utils;
import me.Ravi.Lotr.LotrFaction.LotrSectEnum;





public class FactionManager 
{
	private static List<LotrFaction> factionList = new ArrayList<LotrFaction>();
	
	public static List<LotrFaction> getSectFactions(LotrSectEnum sect)
	{
		List<LotrFaction> sectList = new ArrayList<LotrFaction>();
		for(LotrFaction a : factionList)
		{
			if(a.getSect().equals(sect))
			{
				sectList.add(a);
			}
		}
		return sectList;
		
	}
	public static LotrFaction getLotrFaction(Faction f)
	{
		LotrFaction lfaction = null;
		for(LotrFaction aFaction: factionList)
		{
			if(aFaction.getFaction().equals(f))
			{
				lfaction = aFaction;
				break;
			}
		}
		return lfaction;
	}
	public static  List<LotrFaction> getList()
	{
		return factionList;
	}
	public static void setList(List<LotrFaction> list)
	{
		factionList = list;
		Utils.Log(ChatColor.AQUA+" list for faction is "+factionList.size());
	}
	public static void addFaction(LotrFaction faction)
	{
		factionList.add(faction);
	}
	public static void removeFaction(LotrFaction faction)
	{
		factionList.remove(faction);
		faction.getRSect().removeFaction(faction);
	}
}
