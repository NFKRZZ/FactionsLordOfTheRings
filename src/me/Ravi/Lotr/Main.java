package me.Ravi.Lotr;
import java.io.File;
import me.Ravi.Lotr.Listeners.*;
import com.mysql.jdbc.Util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.Ravi.Lotr.LotrFaction.LotrSectEnum;
import me.Ravi.Lotr.Managers.*;
//TODO FINISH DESERIALIZER CODE. IMPLEMENT WARS START ADD COMMANDS IN//
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
		LoadData.loadWars();
		LoadData.loadSettlements();
		new SectManager();
		new FactionManager();
		new LotrFPlayerManager();
		Init();
		Tasks.WarTask(this);
		Tasks.PlayerCheck(this);
		Tasks.AutoSave(this);
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"FactionsUUID_LOTR Intiliazed");
//LOAD UP ALL FACTIONS ON START//LOAD UP ALL FPLAYERS//THEN APPLY ALL ATTRIBUTES TO FACTIONS/PLAYERS//LOAD UP ALL CURRENT WARS//
	}
	public void onDisable()
	{
		SaveData.saveSect();
		SaveData.saveFactions();
		SaveData.saveFPlayer();
		SaveData.saveWar();
		SaveData.saveSettlement();
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
