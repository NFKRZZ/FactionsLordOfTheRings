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
		FPlayer player = e.getFPlayer();
		Player sender = player.getPlayer();
		Faction faction = e.getFaction();
		sender.sendMessage(ChatColor.ITALIC+""+ChatColor.GREEN+"What sect would you like your faction to side with?");
		sender.sendMessage(ChatColor.ITALIC+""+ChatColor.GREEN+"The West - 1.Gondor 2.Elves 3.Dwarves");
		sender.sendMessage(ChatColor.ITALIC+""+ChatColor.GREEN+"The East - 4.Mordor 5.Harad 6.Goblins of The Misty Mountains");
		response = "Mordor";
		if(response.equalsIgnoreCase("Gondor"))
		{
			FactionManager.addFaction(new LotrFaction(faction, LotrSectEnum.GONDOR,Allegiance.GOOD ));
			sect = LotrSectEnum.GONDOR;
		}
		else if(response.equalsIgnoreCase("Elves"))
		{
			FactionManager.addFaction(new LotrFaction(faction,LotrSectEnum.ELVES,Allegiance.GOOD));
			sect = LotrSectEnum.ELVES;
			 
		}
		else if(response.equalsIgnoreCase("Dwarves"))
		{
			FactionManager.addFaction(new LotrFaction(faction,LotrSectEnum.DWARVES,Allegiance.GOOD));
			sect = LotrSectEnum.DWARVES;
		}
		else if(response.equalsIgnoreCase("Mordor"))
		{
			FactionManager.addFaction(new LotrFaction(faction,LotrSectEnum.MORDOR,Allegiance.EVIL));
			sect = LotrSectEnum.MORDOR;
		}
		else if(response.equalsIgnoreCase("Harad"))
		{
			FactionManager.addFaction(new LotrFaction(faction,LotrSectEnum.HARAD,Allegiance.EVIL));
			sect = LotrSectEnum.HARAD;
		}
		else if(response.equalsIgnoreCase("Goblins"))
		{
			FactionManager.addFaction(new LotrFaction(faction,LotrSectEnum.GOBLINS,Allegiance.EVIL));
			sect = LotrSectEnum.GOBLINS;
		}
		else 
		{
			sender.sendMessage("Couldnt Understand please try again");
			this.FactionCreateEvent(e);
		}
		sender.sendMessage(ChatColor.BLUE+"You have joined the "+sect.toString()+" sect");
		wow = false;
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
