package me.Ravi.Lotr;

import org.bukkit.Location;



public class War 
{
	LotrFaction attacker;
	LotrFaction defender;
	Location attackerCap;
	long duration;
	public War(LotrFaction attacker, LotrFaction defender)
	{
		this.attacker = attacker;
		this.defender = defender;
	}
	public void setDuration(long seconds)
	{
		this.duration = seconds;
	}
	public Location getLocation()
	{
		return defender.getRSect().getCapital();
	}
}
