package me.Ravi.Lotr;

import org.bukkit.Location;




public class War 
{
	public LotrFaction attacker;
	public LotrFaction defender;
	Location attackerCap;
	Location defenderCap;
	
	long duration;
	public War(LotrFaction attacker, LotrFaction defender)
	{
		this.attacker = attacker;
		this.defender = defender;
		this.duration = 0; 
	}
	public void setDuration(long seconds)
	{
		this.duration = seconds;
	}
	public void incrementDuration()
	{
		duration++;
	}
	public Location getLocation()
	{
		return defender.getRSect().getCapital();
	}
}
