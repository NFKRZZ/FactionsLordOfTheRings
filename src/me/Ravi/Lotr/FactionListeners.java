package me.Ravi.Lotr;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.Ravi.Lotr.LotrFaction.Allegiance;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.event.FPlayerJoinEvent;
import com.massivecraft.factions.event.FactionDisbandEvent;
import com.massivecraft.factions.event.FactionRelationEvent;
import com.massivecraft.factions.event.FPlayerJoinEvent.PlayerJoinReason;

public class FactionListeners implements Listener 
{
    Main plugin;
	public FactionListeners(Main plugin)
	{
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
    @EventHandler
    public void FPlayerJoinEvent(FPlayerJoinEvent e)
    {
        PlayerJoinReason reason = e.getReason();
        Faction faction = e.getFaction();
        LotrFaction lotrFac = FactionManager.getLotrFaction(faction);
        LotrFPlayer lotrPlayer = LotrFPlayerManager.getPlayer(e.getfPlayer());
        if(reason == PlayerJoinReason.CREATE)
        {
            return;
        }
        else
        {
            lotrFac.AddMember(lotrPlayer);
        }
    }
    @EventHandler
    public void FactionRelationEvent(FactionRelationEvent e)
    {
        LotrFaction FactionSender = FactionManager.getLotrFaction(e.getFaction());
        LotrFaction FactionTarget = FactionManager.getLotrFaction(e.getTargetFaction());
        if(FactionSender.getAllegiance().equals(FactionSender.getAllegiance()) || FactionSender.getAllegiance().equals(Allegiance.NEUTRAL) || FactionTarget.getAllegiance().equals(Allegiance.NEUTRAL) )
        {
            
        }
        else
        {
            //cancel event
        }
    }
    @EventHandler
    public void FactionDeleteEvent(FactionDisbandEvent e)
    {
        Faction faction = e.getFaction();
        LotrFaction lFaction = FactionManager.getLotrFaction(faction);
        lFaction.getRSect().removeFaction(lFaction);
        FactionManager.removeFaction(lFaction);
        lFaction = null;
    }
}
