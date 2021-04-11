package me.Ravi.Lotr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import com.massivecraft.factions.Faction;
public class LotrFaction implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Faction faction;
	private Allegiance allegiance;
	private LotrSectEnum sect;
	private LotrSect rSect;
	private List<LotrFPlayer> memberList = new ArrayList<LotrFPlayer>();
	public LotrFaction(Faction faction,LotrSectEnum sect, Allegiance allegiance)
	{
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
	public me.Ravi.Lotr.LotrSect getRSect()
	{
		return rSect;
	}
	enum LotrSectEnum
	{
		GONDOR,
		ELVES,
		DWARVES,
		MORDOR,
		HARAD,
		GOBLINS
		
	}
	enum Allegiance
	{
		GOOD,
		NEUTRAL,
		EVIL
	}

}
