package me.Ravi.Lotr.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.Ravi.Lotr.LotrFPlayer;
import me.Ravi.Lotr.LotrFaction;
import me.Ravi.Lotr.Main;
import me.Ravi.Lotr.Utils;
import me.Ravi.Lotr.LotrFaction.Allegiance;
import me.Ravi.Lotr.Managers.FactionManager;
import me.Ravi.Lotr.Managers.LotrFPlayerManager;
import net.md_5.bungee.api.ChatColor;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.event.FPlayerJoinEvent;
import com.massivecraft.factions.event.FactionAutoDisbandEvent;
import com.massivecraft.factions.event.FactionDisbandEvent;
import com.massivecraft.factions.event.FactionRelationEvent;
import com.massivecraft.factions.event.LandClaimEvent;
import com.massivecraft.factions.event.LandUnclaimAllEvent;
import com.massivecraft.factions.event.LandUnclaimEvent;
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
            lotrPlayer.setLotrFaction(lotrFac);
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
        try
        {
            Utils.Log("FACTION DELETE EVENT CALLED");
            Faction faction = e.getFaction();
            LotrFaction lFaction = FactionManager.getLotrFaction(faction);
            FactionManager.removeFaction(lFaction);
            lFaction = null;
        }
        catch(Exception fa)
        {
            Utils.Log(ChatColor.RED+"Some Error Happened!");
            Utils.Log(ChatColor.AQUA+fa.toString());
        }
    }
    @EventHandler
    public void FactionAutoDisband(FactionAutoDisbandEvent e)
    {
        try
        {
            LotrFaction fac = FactionManager.getLotrFaction(e.getFaction());
            FactionManager.removeFaction(fac);
            fac = null;
        }
        catch(Exception j)
        {
            Utils.Log(j.toString());
        }
    }
    @EventHandler
    public void FactionClaim(LandClaimEvent e)
    {
        
    }
    @EventHandler
    public void FactionUnClaim(LandUnclaimEvent e)
    {

    }
    @EventHandler
    public void FactionUnClaimAll(LandUnclaimAllEvent e)
    {
              
    }
}
