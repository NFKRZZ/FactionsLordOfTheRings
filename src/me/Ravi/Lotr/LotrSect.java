package me.Ravi.Lotr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

import me.Ravi.Lotr.LotrFaction.LotrSectEnum;
import net.minecraft.server.v1_16_R3.Vector3f;

public class LotrSect implements Serializable
{
	private static final long serialVersionUID = 1L;
	LotrSectEnum sect;
	Location Capital;
	String CapitalName;
	boolean isCapitalUnderAttack = false;
	int reinforcementAmount = 0;
	public List<War> wars = new ArrayList<War>();
	public List<LotrFaction> factions = new ArrayList<LotrFaction>();
	public List<LotrFPlayer> players = new ArrayList<LotrFPlayer>();
	public LotrSect(Location Capital, LotrSectEnum sect)
	{
		this.sect = sect;
		this.Capital = Capital;
	}
	public void setReinforcements(int amount)
	{
		if(isCapitalUnderAttack)
		{
			reinforcementAmount = amount;
		}
	}
	public int getReinforcements()
	{
		return reinforcementAmount;
	}
	public LotrSectEnum getSect()
	{
		return sect;
	}
	public Location getCapital()
	{
		return Capital;
	}
	public void setXpBoost()
	{
		
	}
	public void addFaction(LotrFaction faction)
	{
		factions.add(faction);
	}
	public void removeFaction(LotrFaction faction)
	{
		factions.remove(faction);
	}
	public void setFaction(String Tag)
	{

	}
}

