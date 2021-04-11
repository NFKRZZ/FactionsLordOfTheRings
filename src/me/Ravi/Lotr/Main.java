package me.Ravi.Lotr;
import java.io.File;

import com.mysql.jdbc.Util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.Ravi.Lotr.LotrFaction.LotrSectEnum;

public class Main extends JavaPlugin
{
	public static File pluginDirectory;
	public void onEnable()
	{
		if (!getDataFolder().exists()) 
		{
			this.getDataFolder().mkdir();
		}
		this.saveDefaultConfig();
		new FactionCreateListener(this);
		new FactionListeners(this);
		new Listeners(this);
		this.getCommand("sectinfo").setExecutor(new SectCommand());
		this.getCommand("l").setExecutor(new SectCommand());
		this.getCommand("secttop").setExecutor(new SectCommand());
		pluginDirectory = this.getDataFolder();
		LoadData.LoadSect();
		LoadData.LoadFactions();
		LoadData.loadFPlayer();
		new SectManager();
		new FactionManager();
		new LotrFPlayerManager();
		Init();
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"FactionsUUID_LOTR Intiliazed");
//LOAD UP ALL FACTIONS ON START//LOAD UP ALL FPLAYERS//THEN APPLY ALL ATTRIBUTES TO FACTIONS/PLAYERS//LOAD UP ALL CURRENT WARS//
	}
	public void onDisable()
	{
		SaveData.saveSect();
		SaveData.saveFactions();
		SaveData.saveFPlayer();
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"FactionsUUID_LOTR say bye bye");
		this.saveConfig();
	}
	public void Init()
	{
		boolean lol = this.getConfig().getBoolean("first-time");
		Utils.Log("value of LOL "+lol);
		if(!lol)
		{
			return;
		}
		else 
		{
			Utils.Log(ChatColor.GREEN+"Starting First Time Init Of Sects");
			SectManager.addSect(new LotrSect(null, LotrSectEnum.DWARVES));
			SectManager.addSect(new LotrSect(null, LotrSectEnum.ELVES));
			SectManager.addSect(new LotrSect(null,LotrSectEnum.GOBLINS));
			SectManager.addSect(new LotrSect(null,LotrSectEnum.GONDOR));
			SectManager.addSect(new LotrSect(null,LotrSectEnum.HARAD));
			SectManager.addSect(new LotrSect(null,LotrSectEnum.MORDOR));
			this.getConfig().set("first-time", false);
		}
	}
}
