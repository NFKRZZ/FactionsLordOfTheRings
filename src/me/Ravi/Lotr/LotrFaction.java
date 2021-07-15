package me.Ravi.Lotr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
public class LotrFaction implements Serializable
{
	private static final long serialVersionUID = 1L;
	private transient Faction faction;
	public String fName;
	private Allegiance allegiance;
	private LotrSectEnum sect;
	private LotrSect rSect;
	public List<LotrFPlayer> memberList = new ArrayList<LotrFPlayer>();
	public LotrFaction(Faction faction,LotrSectEnum sect, Allegiance allegiance)
	{
		this.fName = faction.getTag();
		this.faction = faction;
		this.sect = sect;
		this.allegiance = allegiance;
		
	}
	public Faction getFaction()
	{
		return faction;
	}
	public LotrSectEnum getSect()
	{
		return sect;
	}
	public List<LotrFPlayer> getMembers()
	{
		return memberList;
	}
	public Allegiance getAllegiance()
	{
		return allegiance;
	}
	public void AddMember(LotrFPlayer player)
	{
		memberList.add(player);
	}
	public void removeMember(LotrFPlayer player)
	{
		memberList.remove(player);
	}
	public void setFaction(String tag)
	{
		faction = Factions.getInstance().getByTag(tag);
	}
	public me.Ravi.Lotr.LotrSect getRSect()
	{
		return rSect;
	}
	@Override
	public String toString()
	{
		return fName;
	}
	public enum LotrSectEnum
	{
		GONDOR,
		ELVES,
		DWARVES,
		MORDOR,
		HARAD,
		GOBLINS
		
	}
	public enum Allegiance
	{
		GOOD,
		NEUTRAL,
		EVIL
	}

}
