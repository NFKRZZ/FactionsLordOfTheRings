package me.Ravi.Lotr;

import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;

import javax.lang.model.util.ElementScanner6;

import com.massivecraft.factions.FPlayers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Listeners implements Listener
{
    Main plugin;
	public Listeners(Main plugin)
	{
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
    @EventHandler
    public void playerJoin(PlayerJoinEvent e)
    {
        LotrFPlayer newPlayer = null;
        Player player = e.getPlayer();
        boolean playedBefore  = player.hasPlayedBefore();
        boolean doesExistInList = LotrFPlayerManager.doesPlayerExist(player);
        if((!playedBefore&&!doesExistInList)||(playedBefore&&!doesExistInList))
        {
            newPlayer = new LotrFPlayer(FPlayers.getInstance().getByPlayer(player));
        }
        else
        {
            Utils.Log(ChatColor.RED+"Error in playerJoin Event at Listeners.java");
            return;
        }
        
        LotrFPlayerManager.add(newPlayer);

    }    
}
