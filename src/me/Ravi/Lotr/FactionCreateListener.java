package me.Ravi.Lotr;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.event.FactionCreateEvent;


import me.Ravi.Lotr.LotrFaction.Allegiance;
import me.Ravi.Lotr.LotrFaction.LotrSectEnum;



public class FactionCreateListener implements Listener 
{
	String response = null;
	boolean wow = false;
	Main plugin;
	public FactionCreateListener(Main plugin)
	{
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void FactionCreateEvent(FactionCreateEvent e)
	{
		wow = true;
		LotrSectEnum sect = null;
		LotrFaction fac = null;
		FPlayer player = e.getFPlayer();
		Player sender = player.getPlayer();
		Faction faction = e.getFaction();
		sender.sendMessage(ChatColor.ITALIC+""+ChatColor.GREEN+"What sect would you like your faction to side with?");
		sender.sendMessage(ChatColor.ITALIC+""+ChatColor.GREEN+"The West - 1.Gondor 2.Elves 3.Dwarves");
		sender.sendMessage(ChatColor.ITALIC+""+ChatColor.GREEN+"The East - 4.Mordor 5.Harad 6.Goblins of The Misty Mountains");
		response = "Mordor";
		if(response.equalsIgnoreCase("Gondor"))
		{
			fac = new LotrFaction(faction, LotrSectEnum.GONDOR,Allegiance.GOOD);
			FactionManager.addFaction(fac);
			sect = LotrSectEnum.GONDOR;
		}
		else if(response.equalsIgnoreCase("Elves"))
		{
			fac = new LotrFaction(faction,LotrSectEnum.ELVES,Allegiance.GOOD);
			FactionManager.addFaction(fac);
			sect = LotrSectEnum.ELVES;
			 
		}
		else if(response.equalsIgnoreCase("Dwarves"))
		{
			fac = new LotrFaction(faction,LotrSectEnum.DWARVES,Allegiance.GOOD);
			FactionManager.addFaction(fac);
			sect = LotrSectEnum.DWARVES;
		}
		else if(response.equalsIgnoreCase("Mordor"))
		{
			fac = new LotrFaction(faction,LotrSectEnum.MORDOR,Allegiance.EVIL);
			FactionManager.addFaction(fac);
			sect = LotrSectEnum.MORDOR;
		}
		else if(response.equalsIgnoreCase("Harad"))
		{
			fac = new LotrFaction(faction,LotrSectEnum.HARAD,Allegiance.EVIL);
			FactionManager.addFaction(fac);
			sect = LotrSectEnum.HARAD;
		}
		else if(response.equalsIgnoreCase("Goblins"))
		{
			fac = new LotrFaction(faction,LotrSectEnum.GOBLINS,Allegiance.EVIL);
			FactionManager.addFaction(fac);
			sect = LotrSectEnum.GOBLINS;
		}
		else 
		{
			sender.sendMessage("Couldnt Understand please try again");
			this.FactionCreateEvent(e);
		}
		sender.sendMessage(ChatColor.BLUE+"You have joined the "+sect.toString()+" sect");
		wow = false;
		LotrFPlayer player2 = LotrFPlayerManager.getPlayer(player);
		player2.setLotrFaction(fac);
		
	}
	@EventHandler
	public void AsyncChat(AsyncPlayerChatEvent e)
	{
		if(wow)
		{
			response = e.getMessage();
		}
	}
	
}
