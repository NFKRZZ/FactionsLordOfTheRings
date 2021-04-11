package me.Ravi.Lotr;
import java.util.ArrayList;
import java.util.List;

import com.massivecraft.factions.Faction;

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
	}
	public static void addFaction(LotrFaction faction)
	{
		factionList.add(faction);
	}
	public static void removeFaction(LotrFaction faction)
	{
		factionList.remove(faction);
	}
}
