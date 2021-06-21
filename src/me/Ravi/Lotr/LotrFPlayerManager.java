package me.Ravi.Lotr;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.factions.FPlayer;

import org.bukkit.entity.Player;


public class LotrFPlayerManager 
{
    private static List<LotrFPlayer> playerList = new ArrayList<LotrFPlayer>();
    public static void add(LotrFPlayer player)
    {
        playerList.add(player);
    }
    public static void remove(LotrFPlayer player)
    {
        playerList.remove(player);
    }    
    public static LotrFPlayer getPlayer(FPlayer player)
    {
        LotrFPlayer LotrPlayer = null;
        for(LotrFPlayer fPlayer: playerList)
        {
            if(fPlayer.getFPlayer().equals(player))
            {
                LotrPlayer = fPlayer;
                break;
            }
        }
        return LotrPlayer;
    }
    public static LotrFPlayer getPlayer(Player player)
    {
        LotrFPlayer lotrplayer = null;
        for(LotrFPlayer fPlayer: playerList)
        {
            if(fPlayer.getFPlayer().getPlayer().equals(player))
            {
                lotrplayer = fPlayer;
                break;
            }
        }
        return lotrplayer;
    }
    public static boolean doesPlayerExist(Player player)
    {
        for(LotrFPlayer fplayer:playerList)
        {
            if(fplayer.getFPlayer().getPlayer().equals(player))
            {
                return true;
            }
        }
        return false;
    }
    public static List<LotrFPlayer> getLotrFPlayers()
    {
        return playerList;
    }
    public static void setLotrFPlayers(List<LotrFPlayer> players)
    {
        playerList = players;
    }
}
