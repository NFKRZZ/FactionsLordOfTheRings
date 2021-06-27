package me.Ravi.Lotr;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Factions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
				LotrSectEnum lol = LotrSectEnum.valueOf(lSect.toUpperCase());
				LotrSect sect = SectManager.getSectFromEnum(lol);
				sender.sendMessage("----------Sect Info---------");
				sender.sendMessage("Sect Name:"+SectManager.getSectFromEnum(lol).toString());
				sender.sendMessage("Sect Factions: "+FactionManager.getSectFactions(lol).size());
				sender.sendMessage(FactionManager.getSectFactions(lol).get(0).toString());
				sender.sendMessage(FactionManager.getSectFactions(lol).get(0).getFaction().getTag());
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
				sender.sendMessage("-------------------------------");
				for(War war: WarManager.warList)
				{
					sender.sendMessage("Attacker: "+war.attacker.toString()+" Defender: "+war.defender.toString()+" "+war.duration+" seconds");
				}
			}
			else if(args[0].equalsIgnoreCase("war"))
			{
				String faction;
				try
				{
					faction  = args[1];
				}
				catch(Exception e)
				{
					if(e instanceof ArrayIndexOutOfBoundsException)
						sender.sendMessage(ChatColor.RED+"No Faction Specified");
						return false;
				}
				Player player = (Player)sender;
				LotrFaction Attacker = FactionManager.getLotrFaction(FPlayers.getInstance().getByPlayer(player).getFaction());
				LotrFaction Defender = null;
				try
				{
					Defender = FactionManager.getLotrFaction(Factions.getInstance().getByTag(faction)); 
					if(Defender.getFaction() == null)
					{
						throw new Exception("Faction doesnt exist");
					}
					War war = new War(Attacker,Defender);
					new WarCreateEvent(war, Attacker, Defender);
					WarManager.warList.add(war);
				}
				catch(Exception e)
				{
					if(e.equals("Faction doesnt exist"))
					{
						sender.sendMessage(ChatColor.RED+"This Faction doesnt exist!");
						return false;
					}

				}
				sender.sendMessage(ChatColor.BOLD+""+ChatColor.GREEN+Attacker.toString()+" has declared war on "+Defender.toString());
				//SEND TO ALL FACTIONS INVOLVED
				for(LotrFPlayer g: Defender.memberList)
				{
					g.getFPlayer().getPlayer().sendMessage(Attacker.toString()+" has declared war on your faction");
				}
				for(LotrFPlayer l: Attacker.memberList)
				{
					l.getFPlayer().getPlayer().sendMessage("Your faction has declared war on "+Defender.toString());
				}
			}
		}
		return false;	
	}
}
