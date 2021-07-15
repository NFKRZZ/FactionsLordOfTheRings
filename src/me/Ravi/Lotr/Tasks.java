package me.Ravi.Lotr;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;

import me.Ravi.Lotr.Managers.*;

public class Tasks 
{
    public static void WarTask(Plugin plugin)
    {
        
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() 
        {
            public void run() 
            {
                if(WarManager.warList != null)
                {
                    for(War war: WarManager.warList)
                    {
                        war.incrementDuration();
                    }
                }
            }
        }, 20L, 20L);
    }
    public static void PlayerCheck(Plugin plugin)
    {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() 
        {
            public void run() 
            {
                
                Utils.Log("Starting Player Check!");
                List<LotrFPlayer> pList = LotrFPlayerManager.getLotrFPlayers();
                Set<LotrFPlayer> set = new LinkedHashSet<>();
                if(pList != null)
                {
                   set.addAll(pList);
                   pList.clear();
                   pList.addAll(set);
                   LotrFPlayerManager.setLotrFPlayers(pList);
                }
            }
        }, 0L, 600L);
    }
    public static void AutoSave(Plugin plugin)
    {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable()
        {
            public void run()
            {
                SaveData.saveSect();
		        SaveData.saveFactions();
		        SaveData.saveFPlayer();
		        SaveData.saveWar();
                Bukkit.broadcastMessage(ChatColor.BOLD+""+ChatColor.RED+"Saving Data");
            }
        },72000L,72000L);
    }
    public static void Settlement(Plugin plugin)
    {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable()
        {
            public void run()
            {
                SettlementManager.collectIncome();
                
            }
        }, 72000L, 72000L);
    }

}
