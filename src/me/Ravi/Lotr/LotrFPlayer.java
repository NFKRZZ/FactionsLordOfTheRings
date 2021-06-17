package me.Ravi.Lotr;

import java.io.Serializable;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LotrFPlayer implements Serializable
{
    private static final long serialVersionUID = 1L;
    private FPlayer player;
    private String playerName;
    public LotrFPlayer(FPlayer player)
    {
        this.player = player;
        playerName = player.getPlayer().getName();
        Utils.Log(player.getClass().toString()+" PLAYER  CLASS");
    }
    public FPlayer getFPlayer()
    {
        return player;
    }
    public void setFPlayer(String name)
    {
        Player reg = (Player)Bukkit.getServer().getOfflinePlayer(name);
        player = FPlayers.getInstance().getByPlayer(reg);
    }
}
