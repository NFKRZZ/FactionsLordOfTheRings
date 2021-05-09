package me.Ravi.Lotr;

import java.io.Serializable;

import com.massivecraft.factions.FPlayer;

public class LotrFPlayer implements Serializable
{
    private static final long serialVersionUID = 1L;
    private FPlayer player;
    public LotrFPlayer(FPlayer player)
    {
        this.player = player;
        Utils.Log(player.getClass().toString()+" PLAYER  CLASS");
    }
    public FPlayer getFPlayer()
    {
        return player;
    }

}
