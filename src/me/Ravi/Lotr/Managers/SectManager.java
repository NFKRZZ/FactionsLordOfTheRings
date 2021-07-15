package me.Ravi.Lotr.Managers;

import java.util.ArrayList;
import java.util.List;

import me.Ravi.Lotr.LotrSect;
import me.Ravi.Lotr.LotrFaction.LotrSectEnum;

public class SectManager 
{
	private static List<LotrSect> sectList = new ArrayList<LotrSect>();
	public static me.Ravi.Lotr.LotrSect getSectFromEnum(LotrSectEnum sect)
	{
		LotrSect lol = null;
		for(LotrSect a: sectList)
		{
			if(a.sect == sect)
			{
				lol = a;
			}
			else 
			{
				
			}
		}
		return lol;
	}
	public static List<LotrSect> getList()
	{
		return sectList;
	}
	public static void setList(List<LotrSect> list)
	{
		sectList = list;
	}
	public static void addSect(LotrSect sect)
	{
		
		sectList.add(sect);
	}
	public static void removeSect(LotrSect sect)
	{
		sectList.remove(sect);
	}
}
