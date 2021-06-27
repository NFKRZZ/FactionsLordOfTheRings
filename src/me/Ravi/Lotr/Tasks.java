package me.Ravi.Lotr;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;


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
        }, 0L, 20L);
    }
    public static void PlayerCheck(Plugin plugin)
    {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() 
        {
            public void run() 
            {
                
                Utils.Log("Starting Player Check!");
                return;
                //ASK JUSTIN FOR HELP FINDING DUPLICATES
                List<LotrFPlayer> pList = LotrFPlayerManager.getLotrFPlayers();
                if(pList != null)
                {
                    for(int i = pList.size()-1;i>0;i--)
                    {
                        for(int j = i-1;j>=0;j--)
                        {
                            Utils.Log("1st: "+pList.get(i).getFPlayer().getPlayer().getUniqueId()+" 2nd: "+pList.get(j).getFPlayer().getPlayer().getUniqueId());
                            if(pList.get(i).getFPlayer().getPlayer().getUniqueId().equals(pList.get(j).getFPlayer().getPlayer().getUniqueId()))
                            {
                                LotrFPlayerManager.remove(LotrFPlayerManager.getLotrFPlayers().get(i));
                                Utils.Log(ChatColor.RED+"Found duplicate player username: "+pList.get(i).toString()+", removing.");
                            }
                        }
                    }
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
