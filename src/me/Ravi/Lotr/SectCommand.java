package me.Ravi.Lotr;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.Ravi.Lotr.LotrFaction.LotrSectEnum;
import net.md_5.bungee.api.ChatColor;

public class SectCommand implements CommandExecutor 
{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(label.equalsIgnoreCase("sectinfo"))
		{
			sender.sendMessage("-----------Middle-Earth Info------------");
			sender.sendMessage("Mordor Factions: "+FactionManager.getSectFactions(LotrSectEnum.MORDOR).size());
			sender.sendMessage("Harad Factions: "+FactionManager.getSectFactions(LotrSectEnum.HARAD).size());
			sender.sendMessage("Goblin Factions: "+FactionManager.getSectFactions(LotrSectEnum.GOBLINS).size());
			sender.sendMessage("Gondor Factions: "+FactionManager.getSectFactions(LotrSectEnum.GONDOR).size());
			sender.sendMessage("Elvish Factions: "+FactionManager.getSectFactions(LotrSectEnum.ELVES).size());
			sender.sendMessage("Dwarvish Factions: "+FactionManager.getSectFactions(LotrSectEnum.DWARVES).size());
		}
		else if(label.equalsIgnoreCase("War"))
		{
			
		}
		else if(label.equalsIgnoreCase("l"))
		{
			if(args[0].equalsIgnoreCase("info"))
			{
				String lSect = null;
				try
				{
					lSect = args[1];
				}
				catch(Exception e)
				{
					if(e instanceof ArrayIndexOutOfBoundsException)
						sender.sendMessage(ChatColor.RED+"False Sect Specified or None Specified AT ALL");
						return false;
				}
				LotrSectEnum lol = LotrSectEnum.valueOf(lSect);
				LotrSect sect = SectManager.getSectFromEnum(lol);
				sender.sendMessage("----------Sect Info---------");
				sender.sendMessage("Sect Name:"+SectManager.getSectFromEnum(lol));
				sender.sendMessage("Sect Factions: "+FactionManager.getSectFactions(lol).size());
				sender.sendMessage("Sect Capital:"+sect.CapitalName+" "+sect.getCapital() );
				sender.sendMessage("Sect Population:");
			}
			else if(args[0].equalsIgnoreCase("debug"))
			{
				sender.sendMessage("-------------------------------");
				for(LotrSect sect : SectManager.getList())
				{
					sender.sendMessage(sect.getSect().toString());
				}
				sender.sendMessage("-------------------------------");
				for(LotrFaction fac : FactionManager.getList())
				{
					sender.sendMessage(fac.getFaction().getTag());
				}
				sender.sendMessage("-------------------------------");
				for(LotrFPlayer player:LotrFPlayerManager.getLotrFPlayers())
				{
					sender.sendMessage(player.getFPlayer().getPlayer().getName());
				}
			}
		}
		return false;	
	}
}
