package me.Ravi.Lotr.Events;


import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import me.Ravi.Lotr.LotrFaction;
import me.Ravi.Lotr.War;

public class WarCreateEvent extends Event
{
    private static final HandlerList handlers = new HandlerList();
    private final War war;
    private final LotrFaction declarer;
    private final LotrFaction target;
    public WarCreateEvent(War war, LotrFaction declarer, LotrFaction target)
    {
        this.war = war;
        this.declarer = declarer;
        this.target = target;
    }
    @Override
    public HandlerList getHandlers() 
    {
        return handlers;
    }
    public LotrFaction getDeclarer()
    {
        return declarer;
    }
    public LotrFaction getTarget()
    {
        return target;
    }
    public War getWar()
    {
        return war;
    }
    
}
