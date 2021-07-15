package me.Ravi.Lotr.Listeners;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.Ravi.Lotr.LotrFPlayer;
import me.Ravi.Lotr.LotrFaction;
import me.Ravi.Lotr.Main;
import me.Ravi.Lotr.LotrFaction.LotrSectEnum;
import me.Ravi.Lotr.Managers.LotrFPlayerManager;




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
           // Utils.Log(ChatColor.RED+"Error in playerJoin Event at Listeners.java");
            return;
        }
        
        LotrFPlayerManager.add(newPlayer);
    } 
    @EventHandler
    public void applyEffect(PlayerJoinEvent e)
    {
        LotrFPlayer p = LotrFPlayerManager.getPlayer(e.getPlayer());
        LotrFaction f = p.getLotrFaction();
        LotrSectEnum s = f.getSect();
        if(s==LotrSectEnum.MORDOR)
        {
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,Integer.MAX_VALUE,0));
        }
    }
}
