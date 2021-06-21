package me.Ravi.Lotr;

import java.io.Serializable;

import javax.annotation.Nonnull;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LotrFPlayer implements Serializable
{
    private static final long serialVersionUID = 1L;
    private FPlayer player;
    private String playerName;
    private LotrFaction fac;
    public LotrFPlayer(@Nonnull FPlayer player)
    {
        this.player = player;
        playerName = player.getPlayer().getName();
        Utils.Log(player.getClass().toString()+" PLAYER  CLASS");
    }
    public FPlayer getFPlayer()
    {
        return player;
    }
    public LotrFaction getLotrFaction()
    {
        return fac;
    }
    public void setFPlayer(String name)
    {
        Player reg = (Player)Bukkit.getServer().getOfflinePlayer(name);
        player = FPlayers.getInstance().getByPlayer(reg);
    }
    public void setLotrFaction(LotrFaction f)
    {
        fac = f;
    }
}
